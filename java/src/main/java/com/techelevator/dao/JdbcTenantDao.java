package com.techelevator.dao;

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



    private Tenant mapRowToTenant(SqlRowSet rs) {
        Tenant tenant = new Tenant();
        tenant.setTenantId(rs.getInt("tenant_id"));
        tenant.setFirstName(rs.getString("firstName"));
        tenant.setLastName(rs.getString("lastName"));
        tenant.setEmail(rs.getString("email"));
        tenant.setPhone(rs.getString("phone"));
        return tenant;
    }




}
