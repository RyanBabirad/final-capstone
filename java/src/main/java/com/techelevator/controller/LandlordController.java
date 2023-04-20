package com.techelevator.controller;

import com.techelevator.dao.LandlordDao;
import com.techelevator.dao.PropertyDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.time.LocalDate;
import java.util.List;


@RestController
@CrossOrigin
public class LandlordController {

    @Autowired
    private LandlordDao landlordDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private PropertyDao propertyDao;

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path= "/landlord", method = RequestMethod.POST)
    public Landlord createLandlord(@Valid @RequestBody LandlordDto landlordDto, Principal principal) {
        Landlord landlord = new Landlord();
        User user = userDao.findByUsername(principal.getName());

        landlord.setLandLordId(user.getId());
        landlord.setFirstName(landlordDto.getFirstName());
        landlord.setLastName(landlordDto.getLastName());
        landlord.setEmail(landlordDto.getEmail());
        landlord.setPhone(landlordDto.getPhone());

        landlordDao.createLandlord(landlord.getLandLordId(), landlord);

        return landlord;
    }

    @RequestMapping(path = "/landlord", method = RequestMethod.GET)
    public List<Property> listPropertiesByLandlord(Principal principal) {
        User user = userDao.findByUsername(principal.getName());
        int landlordId = user.getId();
        return propertyDao.getPropertiesByLandlord(landlordId);
    }


    // this does not work yet. - Colin
//    @RequestMapping(path = "/landlord/tenant", method = RequestMethod.PUT)
//    public void assignPropertyToTenant(@RequestBody Principal principal, Tenant tenant, LandlordDao landlordDao) {
//
//        int landlordId = landlordDao.findLandlordIdByEmail(principal.getName());
//        int propertyId = landlordDao.getPropertyIdByLandlord(principal.getName());    // grabbing empty id
//        int tenantId = tenant.getTenantId();
//
//
//        landlordDao.assignTenant(propertyId, landlordId, tenantId);
//    }




}
