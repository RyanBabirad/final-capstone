//package com.techelevator.dao;
//
//import com.techelevator.model.Staff;
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
//public class JdbcStaffDao implements StaffDao {
//
//    private JdbcTemplate jdbcTemplate;
//
//    public JdbcUserDao(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    @Override
//    public boolean createStaff(Staff staff) {
//        return false;
//    }
//
//    @Override
//    public Staff getStaffById(int id) {
//        return null;
//    }
//
//    @Override
//    public boolean updateStaff(Staff staff) {
//        return false;
//    }
//
//    @Override
//    public void deleteStaff(Staff staff) {
//
//    }
//
//    private Staff mapRowToStaff(SqlRowSet rowSet) {
//        Staff staff = new Staff();
//        staff.setStaffId(rowSet.getInt("staff_id"));
//        staff.setFirstName(rowSet.getString("first_name"));
//        staff.setLastName(rowSet.getString("last_name"));
//        staff.setEmail(rowSet.getString("email"));
//        staff.setPhone(rowSet.getString("phone"));
//        staff.setLandlordId(rowSet.getInt("landlord_id"));
//        return staff;
//    }
//}
////    private int staffId;
////    private String firstName;
////    private String lastName;
////    private String email;
////    private String phone;
////    private int landlordId;
//
////        staff_id int,
////                first_name varchar(20) NOT NULL,
////                last_name varchar(20) NOT NULL,
////                email varchar(50) NOT NULL,
////                phone varchar(12) NOT NULL,
////                landlord_id int,