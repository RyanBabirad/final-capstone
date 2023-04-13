//package com.techelevator.dao;
//
//import com.sun.tools.javac.Main;
//import com.techelevator.model.MaintenanceRequests;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.support.rowset.SqlRowSet;
//import org.springframework.stereotype.Component;
//import org.springframework.dao.EmptyResultDataAccessException;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.support.rowset.SqlRowSet;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//@Component
//
//public class JdbcMaintenanceRequestsDao implements MaintenanceRequestsDao {
//
//    private JdbcTemplate jdbcTemplate;
//
//    public JdbcUserDao(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    @Override
//    public boolean createMaintenanceRequests(MaintenanceRequests maintenanceRequest) {
//        return false;
//    }
//
//    @Override
//    public MaintenanceRequests getMaintenanceRequestById(int id) {
//        return null;
//    }
//
//    @Override
//    public boolean updateMaintenanceRequests(MaintenanceRequests maintenanceRequest) {
//        return false;
//    }
//
//    @Override
//    public void deleteMaintenanceRequests(MaintenanceRequests maintenanceRequest) {
//
//    }
//
//    private MaintenanceRequests mapRowToMaintenanceRequests(SqlRowSet rowSet) {
//        MaintenanceRequests maintenanceRequest = new MaintenanceRequests();
//        maintenanceRequest.setRequestId(rowSet.getInt("maintenanceRequests_id"));
//        maintenanceRequest.setStatus(rowSet.getBoolean("status"));
//        maintenanceRequest.setDate(rowSet.getString("date_requested")); // CHECK THIS IS A STRING!!
//        maintenanceRequest.setDescription(rowSet.getString("description"));
//        maintenanceRequest.setTenantId(rowSet.getInt("tenant_id"));
//        maintenanceRequest.setPropertyId(rowSet.getInt("property_id"));
//        return maintenanceRequest;
//    }
//
////    private int requestId;
////    private boolean status;
////    private String date;  // BE SURE TO CHECK THIS!!!!
////    private String description;
////    private int tenantId;
////    private int propertyId;
//
////    request_id SERIAL,
////    status boolean DEFAULT false,
////    date_requested (Katy changed to STRING) date,
////    description varchar(350),
////    tenant_id int,
////    property_id int,
//
//}
