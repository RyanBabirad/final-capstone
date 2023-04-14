package com.techelevator.dao;

import com.techelevator.model.Landlord;
import com.techelevator.model.Property;

public interface PropertyDao {

    boolean saveProperty(int landlordId, Property property, Landlord landlord);



    Property getPropertyById(int propertyId);

    Property updateProperty(Property property);



}
