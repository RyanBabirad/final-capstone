package com.techelevator.dao;

import com.techelevator.model.Property;

public interface PropertyDao {

    Property createProperty(Property property);

    Property getPropertyById(int propertyId);

    Property updateProperty(Property property);



}
