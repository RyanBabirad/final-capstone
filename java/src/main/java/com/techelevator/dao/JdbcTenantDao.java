package com.techelevator.dao;

import com.techelevator.model.Landlord;
import com.techelevator.model.Property;
import com.techelevator.model.Tenant;
import com.techelevator.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class JdbcTenantDao implements TenantDao {


    private final JdbcTemplate jdbcTemplate;

    public JdbcTenantDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public boolean createTenant(int tenantId, Tenant tenant) {

        String sql = "INSERT into tenant (tenant_id, first_name, last_name, email, phone) VALUES ((SELECT user_id from users where user_id = ?), ?, ?, ?, ?);";
        int newId = jdbcTemplate.update(sql, tenant.getTenantId(), tenant.getFirstName(), tenant.getLastName(), tenant.getEmail(), tenant.getPhone());

        return newId == 1;
    }

    @Override
    public Tenant getTenantById(int tenantId) {
        String sql = "SELECT * FROM tenant WHERE tenant_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, tenantId);
        if (results.next()) {
            return mapRowToTenant(results);
        } else {
            return null;
        }
    }

    @Override
    public Tenant updateTenant(Tenant tenant) {
        return null;
    }

    @Override
    public Landlord getLandlordByTenantId(int tenantId) {

        String sql = "select landlord.first_name, landlord.last_name, landlord.email, landlord.phone from landlord\n" +
                "JOIN tenant on landlord.landlord_id = tenant.landlord_id\n" +
                "where tenant_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, tenantId);
        if (results.next()) {
            return mapRowToLandlord(results);
        }
        return null;
    }

    @Override
    public Property getPropertyByTenantId(int tenantId) {

        String sql = "select streetaddress, zipcode, unit, state, rentamount, tenant_id from property\n" +
                "JOIN tenant on property.property_id = tenant.property_id\n" +
                "where tenant_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, tenantId);
        if (results.next()) {
            return mapRowToProperty(results);
        }
        return null;
    }


    private Tenant mapRowToTenant(SqlRowSet rs) {
        Tenant tenant = new Tenant();
        tenant.setTenantId(rs.getInt("tenant_id"));
        tenant.setFirstName(rs.getString("first_name"));
        tenant.setLastName(rs.getString("last_name"));
        tenant.setEmail(rs.getString("email"));
        tenant.setPhone(rs.getString("phone"));
        tenant.setPropertyId(rs.getInt("property_id"));
        return tenant;
    }

    private Landlord mapRowToLandlord(SqlRowSet rowSet) {
        Landlord landlord = new Landlord();

    //    landlord.setLandLordId(rowSet.getInt("landlord_id"));
        landlord.setFirstName(rowSet.getString("first_name"));
        landlord.setLastName(rowSet.getString("last_name"));
        landlord.setEmail(rowSet.getString("email"));
        landlord.setPhone(rowSet.getString("phone"));

        return landlord;
    }

    private Property mapRowToProperty(SqlRowSet rowSet) {
        Property property = new Property();

     //   property.setPropertyId(rowSet.getInt("property_id"));
     //   property.setImgSrc(rowSet.getString("imgSrc"));
        property.setStreetAddress(rowSet.getString("streetAddress"));
        property.setZipCode(rowSet.getInt("zipcode"));
        property.setState(rowSet.getString("state"));
        property.setUnit(rowSet.getString("unit"));
        property.setRentAmount(rowSet.getInt("rentAmount"));
     //   property.setDescription(rowSet.getString("description"));
     //   property.setLandlordId(rowSet.getInt("landlord_id"));

        return property;
    }



}
