package com.techelevator.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import com.techelevator.model.Rent;

@Component
public class JdbcRentDao {

    // instance variables ..............................................................................................

    private final JdbcTemplate jdbcTemplate;


    // constructor .....................................................................................................

    public JdbcRentDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    // CRUD methods ....................................................................................................

    @Override
    public boolean createRent(Rent rent) {
        String sql = "INSERT INTO rent (rent_id, due_date, paid_date, payment_status, amount_paid," +
                "amount_due, property_id, tenant_id, landlord_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        int numRowsAffected = jdbcTemplate.update(sql, rent.getRentId(), rent.getDueDate(), rent.getPaidDate(), rent.getPaymentStatus(),
                rent.getAmountPaid(), rent.getAmountDue(), rent.getPropertyId(), rent.getTenantId(), rent.getLandlordId());

        return numRowsAffected == 1;
    }

    public
}
