package com.techelevator.dao;

import com.techelevator.model.Property;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcPropertyDao implements PropertyDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcPropertyDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public boolean saveProperty(int propertyId, Property property) {

        String sql = "INSERT into property (imgSrc, streetAddress, zipCode, state, unit, landlord_id)" +
                " VALUES (?, ?, ?, ?, (SELECT landlord_id from landlord where landlord_id = ?));";

        int newId = jdbcTemplate.update(sql, property.getPropertyId(), property.getImgSrc(),
                property.getStreetAddress(), property.getZipCode(), property.getState(), property.getUnit());

        return newId == 1;
    }

    @Override
    public Property getPropertyById(int propertyId) {
        return null;
    }

    @Override
    public Property updateProperty(Property property) {
        return null;
    }
}
