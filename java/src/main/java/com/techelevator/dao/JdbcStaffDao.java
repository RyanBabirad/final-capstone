package com.techelevator.dao;

import com.techelevator.model.Staff;
import com.techelevator.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class JdbcStaffDao implements StaffDao {


    private final JdbcTemplate jdbcTemplate;

    public JdbcStaffDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public boolean createStaff(int staffId, Staff staff) {

        String sql = "INSERT into staff (staff_id, first_name, last_name, email, phone) VALUES ((SELECT user_id from users where user_id = ?), ?, ?, ?, ?);";
        int newId = jdbcTemplate.update(sql, staff.getStaffId(), staff.getFirstName(), staff.getLastName(), staff.getEmail(), staff.getPhone());

        return newId == 1;
    }

    @Override
    public Staff getStaffById(int staffId) {
        String sql = "SELECT * FROM staff WHERE staff_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, staffId);
        if (results.next()) {
            return mapRowToStaff(results);
        } else {
            return null;
        }
    }

    @Override
    public Staff updateStaff(Staff staff) {
        return null;
    }



    private Staff mapRowToStaff(SqlRowSet rs) {
        Staff staff = new Staff();
        staff.setStaffId(rs.getInt("staff_id"));
        staff.setFirstName(rs.getString("firstName"));
        staff.setLastName(rs.getString("lastName"));
        staff.setEmail(rs.getString("email"));
        staff.setPhone(rs.getString("phone"));
        return staff;
    }
}
