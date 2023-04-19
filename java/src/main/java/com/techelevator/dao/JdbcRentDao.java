package com.techelevator.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import com.techelevator.model.Rent;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcRentDao implements RentDao {

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

    @Override
    public List<Rent> getRentsByTenantId(int tenantId) {
        List<Rent> list = new ArrayList<>();

        String sql = "SELECT * FROM rent WHERE tenant_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, tenantId);
        if (results.next()) {
            list.add(mapRowToTenant(results));
        }

        return null;
    }

    @Override
    public List<Rent> getRentsByLandlordId(int landlordId) {
        return null;
    }

    private Rent mapRowToTenant(SqlRowSet row) {
        Rent rent = new Rent();

        rent.setRentId(row.getInt("rent_id"));
        rent.setDueDate(row.getString("duedate"));
        rent.setPaidDate(row.getString("paiddate"));
        rent.setPaymentStatus(row.getInt("paymentstatus"));
        rent.setAmountPaid(row.getFloat("amountpaid"));
        rent.setAmountDue(row.getFloat("amountdue"));
        rent.setPropertyId(row.getInt("property_id"));
        rent.setTenantId(row.getInt("tenant_id"));
        rent.setLandlordId(row.getInt("landlord_id"));

        return rent;
    }

}
