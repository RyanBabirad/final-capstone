package com.techelevator.dao;

import com.techelevator.model.Landlord;
import com.techelevator.model.Property;
import com.techelevator.model.Tenant;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcLandlordDao implements LandlordDao {


    private final JdbcTemplate jdbcTemplate;

    public JdbcLandlordDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean createLandlord(int landlordId, Landlord landlord) { //int userId, String firstName, String lastName, String email, String phone) {

        String sql = "INSERT into landlord (landlord_id, first_name, last_name, email, phone) VALUES ((SELECT user_id from users where user_id = ?), ?, ?, ?, ?);";
        int newId = jdbcTemplate.update(sql, landlord.getLandLordId(), landlord.getFirstName(), landlord.getLastName(), landlord.getEmail(), landlord.getPhone());

        return newId == 1;
    }

    @Override
    public void assignTenant(int landlordId, Tenant tenant, Landlord landlord, Property property) {

        String sql = "UPDATE tenant SET first_name = ?, last_name = ?, email = ?, phone = ?, property_id = ?, landlord_id = ? WHERE tenant_id=?";


        jdbcTemplate.update(sql, tenant.getFirstName(), tenant.getLastName(), tenant.getEmail(), tenant.getPhone(), property.getPropertyId(), landlord.getLandLordId());

    }

    @Override
    public int findLandlordIdByEmail(String email) {

        int landlordId;
        String sql = "SELECT email from landlord where email = ?;";
        landlordId = jdbcTemplate.queryForObject(sql, int.class, email);

        return landlordId;
    }

    @Override
    public int getUserId(int userId) {

        String sql = "SELECT user_id from users WHERE username = ?;";
        userId = jdbcTemplate.queryForObject(sql, int.class, userId);

        return userId;
    }

    @Override
    public Landlord getLandLordById(int landLordId) {
        String sql = "SELECT * from landlord WHERE landlord_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, landLordId);
        if (results.next()) {
            return mapRowToLandlord(results);
        }
        return null;
    }

    @Override
    public Landlord updateLandlord(Landlord landlord) {     // not sure we will need this. - Colin
        return null;
    }


    private Landlord mapRowToLandlord(SqlRowSet rowSet) {
        Landlord landlord = new Landlord();

        landlord.setLandLordId(rowSet.getInt("landlord_id"));
        landlord.setFirstName(rowSet.getString("first_name"));
        landlord.setLastName(rowSet.getString("last_name"));
        landlord.setEmail(rowSet.getString("email"));
        landlord.setPhone(rowSet.getString("phone"));
        //landlord.setUserId(rowSet.getInt("user_id"));

        return landlord;
    }





}
