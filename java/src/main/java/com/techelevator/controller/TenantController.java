package com.techelevator.controller;

import com.techelevator.dao.LandlordDao;
import com.techelevator.dao.PropertyDao;
import com.techelevator.dao.TenantDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@CrossOrigin
public class TenantController {

    @Autowired
    private TenantDao tenantDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private LandlordDao landlordDao;
    @Autowired
    private PropertyDao propertyDao;

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/tenant", method = RequestMethod.POST)
    public Tenant createTenant(@Valid @RequestBody TenantDto tenantDto, Principal principal) {
        Tenant tenant = new Tenant();
        User user = userDao.findByUsername(principal.getName());

        tenant.setTenantId(user.getId());
        tenant.setFirstName(tenantDto.getFirstName());
        tenant.setLastName(tenantDto.getLastName());
        tenant.setEmail(tenantDto.getEmail());
        tenant.setPhone(tenantDto.getPhone());

        tenantDao.createTenant(tenant.getTenantId(), tenant);
        return tenant;
    }


    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/landlord/tenant/{tenantId}", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateTenantPropertyAndLandlordId(
            @PathVariable int tenantId,


            Principal principal) {

       Landlord landlord = landlordDao.getLandLordById(userDao.findIdByUsername(principal.getName()));






        int landlordId = landlord.getLandLordId();
        int propertyId = landlordDao.getPropertyIdByLandlord(principal.getName());

        landlordDao.assignPropertyToTenant(tenantId, landlordId, propertyId);
        return ResponseEntity.ok().build();
    }


}
