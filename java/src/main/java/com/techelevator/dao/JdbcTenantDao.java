package com.techelevator.dao;

import com.techelevator.model.Tenant;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

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
        return null;
    }

    @Override
    public Tenant updateTenant(Tenant tenant) {
        return null;
    }
}
