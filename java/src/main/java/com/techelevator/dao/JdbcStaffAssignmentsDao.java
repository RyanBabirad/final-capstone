package com.techelevator.dao;

import com.techelevator.model.StaffAssignment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcStaffAssignmentsDao implements StaffAssignmentsDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcStaffAssignmentsDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean createStaffAssignment(int staffId, int assignmentId) {

        String sql = "INSERT INTO staff_assignment (staff_id, assignment_id) VALUES (?, ?);";
        int numRowsAffected = jdbcTemplate.update(sql, staffId, assignmentId);

        return numRowsAffected == 1;
    }

    @Override
    public List<StaffAssignment> getStaffAssignmentsByStaffId(int staffId) {
        List<StaffAssignment> list = new ArrayList<>();

        String sql = "SELECT * FROM staff_assignment WHERE staff_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, staffId);

        while(results.next()) {
            list.add(mapRowToStaffAssignment(results));
        }

        return list;
    }

    @Override
    public List<StaffAssignment> getStaffAssignmentsByAssignmentId(int assignmentId) {
        List<StaffAssignment> list = new ArrayList<>();

        String sql = "SELECT * FROM staff_assignment WHERE assignment_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, assignmentId);

        while(results.next()) {
            list.add(mapRowToStaffAssignment(results));
        }

        return list;
    }

    private StaffAssignment mapRowToStaffAssignment(SqlRowSet row) {
        StaffAssignment staffAssignment = new StaffAssignment();

        staffAssignment.setStaffId(row.getInt("staff_id"));
        staffAssignment.setAssignmentId(row.getInt("assignment_id"));

        return staffAssignment;
    }

}
