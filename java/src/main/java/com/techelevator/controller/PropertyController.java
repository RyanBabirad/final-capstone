package com.techelevator.controller;


import com.techelevator.dao.LandlordDao;
import com.techelevator.dao.PropertyDao;
import com.techelevator.model.Landlord;
import com.techelevator.model.Property;
import com.techelevator.model.PropertyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@CrossOrigin
public class PropertyController {

    @Autowired
    private PropertyDao propertyDao;
    @Autowired
    private LandlordDao landlordDao;

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/landlord/properties", method = RequestMethod.POST)
    public Property saveProperty(@Valid @RequestBody PropertyDto propertyDto, Principal principal) {
        Property property = new Property();
        Landlord landlord = landlordDao.getLandLordById(Integer.parseInt(principal.getName()));

        property.setImgSrc(propertyDto.getImgSrc());
        property.setStreetAddress(propertyDto.getStreetAddress());
        property.setZipCode(propertyDto.getZipCode());
        property.setState(propertyDto.getState());
        property.setUnit(propertyDto.getUnit());
        property.setLandlordId(landlord.getLandLordId());

        propertyDao.saveProperty(property.getPropertyId(), property);

        return property;
    }





}
