package com.techelevator.dao;

import com.techelevator.model.Landlord;
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
    public boolean createLandlord(String firstName, String lastName, String email, String phone) {

        String sql = "INSERT into landlord (first_name, last_name, email, phone) VALUES (?, ?, ?, ?) RETURNING landlord_id;";
        Integer newLandLordId;
        newLandLordId = jdbcTemplate.queryForObject(sql, Integer.class, firstName, lastName, email, phone);


        return newLandLordId != null;
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
        landlord.setFirstName(rowSet.getString("firstName"));
        landlord.setLastName(rowSet.getString("lastName"));
        landlord.setEmail(rowSet.getString("email"));
        landlord.setPhone(rowSet.getString("phone"));
        landlord.setUserId(rowSet.getInt("user_id"));

        return landlord;
    }



}
