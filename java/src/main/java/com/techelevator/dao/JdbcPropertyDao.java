package com.techelevator.dao;

import com.techelevator.model.Landlord;
import com.techelevator.model.Property;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcPropertyDao implements PropertyDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcPropertyDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean saveProperty(int landlordId, Property property, Landlord landlord) {
        int landLordId;

        String sql = "INSERT into property (imgSrc, streetAddress, zipCode, state, unit, rentAmount, description, landlord_id)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, (SELECT landlord_id from landlord where email = ?));";

        int newId = jdbcTemplate.update(sql, property.getImgSrc(), property.getStreetAddress(), property.getZipCode(),
                property.getState(), property.getUnit(), property.getRentAmount(), property.getDescription(), landlord.getEmail());

        return newId == 1;
    }

    @Override
    public List<Property> listAllProperties() {
        List<Property> properties = new ArrayList<>();
        String sql = "select * from property;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Property property = mapRowToLandlord(results);
            properties.add(property);
        }

        return properties;
    }

    @Override
    public Property getPropertyById(int propertyId) {

        String sql = "SELECT * from property where property_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, propertyId);

        if (results.next()) {
            mapRowToLandlord(results);
        }
        return null;
    }


    @Override
    public Property updateProperty(Property property) {
        return null;
    }


    private Property mapRowToLandlord(SqlRowSet rowSet) {
        Property property = new Property();

        property.setPropertyId(rowSet.getInt("property_id"));
        property.setImgSrc(rowSet.getString("imgSrc"));
        property.setStreetAddress(rowSet.getString("streetAddress"));
        property.setZipCode(rowSet.getInt("zipcode"));
        property.setState(rowSet.getString("state"));
        property.setUnit(rowSet.getString("unit"));
        property.setRentAmount(rowSet.getInt("rentAmount"));
        property.setDescription(rowSet.getString("description"));
        property.setLandlordId(rowSet.getInt("landlord_id"));

        return property;
    }

}
