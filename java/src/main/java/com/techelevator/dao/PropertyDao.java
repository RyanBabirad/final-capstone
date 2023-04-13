package com.techelevator.dao;

import com.techelevator.model.Property;

public interface PropertyDao {

    boolean saveProperty(int propertyId, Property property);

    Property getPropertyById(int propertyId);

    Property updateProperty(Property property);



}
