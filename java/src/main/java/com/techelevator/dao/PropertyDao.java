package com.techelevator.dao;

import com.techelevator.model.Landlord;
import com.techelevator.model.Property;

import java.util.List;

public interface PropertyDao {

    boolean saveProperty(int landlordId, Property property, Landlord landlord);

    List<Property> listAllProperties();

    Property getPropertyById(int propertyId);

    Property updateProperty(Property property);



}
