package com.techelevator.controller;

import com.techelevator.dao.TenantDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Tenant;
import com.techelevator.model.TenantDto;
import com.techelevator.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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



}
