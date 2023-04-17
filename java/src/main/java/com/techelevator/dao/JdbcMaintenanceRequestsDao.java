package com.techelevator.dao;

import com.techelevator.model.MaintenanceRequests;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcMaintenanceRequestsDao implements MaintenanceRequestsDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcMaintenanceRequestsDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

//    @Override
//    public boolean createMaintenanceRequests(MaintenanceRequests maintenanceRequest) {
//        String sql = "INSERT INTO maintenance_request (request_id, status, date_requested, description, tenant_id, property_id) VALUES (DEFAULT, ?, ?, ?, ?, ?)";
//        int rowsAffected = jdbcTemplate.update(sql, maintenanceRequest.getRequestId(), maintenanceRequest.isStatus(), maintenanceRequest.getDate(), maintenanceRequest.getDescription(), maintenanceRequest.getTenantId(), maintenanceRequest.getPropertyId());
//        return rowsAffected == 1;
//    }


    @Override
    public boolean createMaintenanceRequests(MaintenanceRequests maintenanceRequest) {
        String sql = "INSERT INTO maintenance_request (status, date_requested, description, tenant_id, property_id) VALUES (?, ?, ?, ?, ?)";
        int rowsAffected = jdbcTemplate.update(sql, maintenanceRequest.isStatus(), maintenanceRequest.getDate(), maintenanceRequest.getDescription(), maintenanceRequest.getTenantId(), maintenanceRequest.getPropertyId());
        return rowsAffected == 1;
    }

    @Override
    public MaintenanceRequests getMaintenanceRequestById(int id) {
        String sql = "SELECT * FROM maintenance_request WHERE request_id = ?";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, id);
        if (rowSet.next()) {
            return mapRowToMaintenanceRequests(rowSet);
        } else {
            throw new RuntimeException("Maintenance request not found with id: " + id);
        }
    }

    @Override
    public boolean updateMaintenanceRequests(MaintenanceRequests maintenanceRequest) {
        String sql = "UPDATE maintenance_request SET status = ?, date_requested = ?, description = ?, tenant_id = ?, property_id = ? WHERE request_id = ?";
        int rowsAffected = jdbcTemplate.update(sql, maintenanceRequest.isStatus(), maintenanceRequest.getDate(), maintenanceRequest.getDescription(), maintenanceRequest.getTenantId(), maintenanceRequest.getPropertyId(), maintenanceRequest.getRequestId());
        return rowsAffected == 1;
    }

    @Override
    public void deleteMaintenanceRequests(int id) {
        String sql = "DELETE FROM maintenance_request WHERE request_id = ?";
        jdbcTemplate.update(sql, id);
    }

    private MaintenanceRequests mapRowToMaintenanceRequests(SqlRowSet rowSet) {
        MaintenanceRequests maintenanceRequest = new MaintenanceRequests();
        maintenanceRequest.setRequestId(rowSet.getInt("request_id"));
        maintenanceRequest.setStatus(rowSet.getBoolean("status"));
        maintenanceRequest.setDate(rowSet.getString("date_requested"));
        maintenanceRequest.setDescription(rowSet.getString("description"));
        maintenanceRequest.setTenantId(rowSet.getInt("tenant_id"));
        maintenanceRequest.setPropertyId(rowSet.getInt("property_id"));
        return maintenanceRequest;
    }
}


//    private int requestId;
//    private boolean status;
//    private String date;  // BE SURE TO CHECK THIS!!!!
//    private String description;
//    private int tenantId;
//    private int propertyId;

//    request_id SERIAL,
//    status boolean DEFAULT false,
//    date_requested (Katy changed to STRING) date,
//    description varchar(350),
//    tenant_id int,
//    property_id int,


