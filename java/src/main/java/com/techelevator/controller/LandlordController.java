package com.techelevator.controller;

import com.techelevator.dao.LandlordDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;


@RestController
@CrossOrigin
public class LandlordController {

    @Autowired
    private LandlordDao landlordDao;
    @Autowired
    private UserDao userDao;

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


//    @RequestMapping(path = "/landlord/tenant/{id}", method = RequestMethod.PUT)
//    public Landlord assignTenant(@PathVariable int id, @RequestBody LandlordDto landlordDto, PropertyDto propertyDto, TenantDto tenantDto) {
//
//        Landlord landlord = landlordDao.assignTenant(id, propertyDto.getLandlordId(), tenantDto.getTenantId());
//
//        return landlord;
//    }




}
