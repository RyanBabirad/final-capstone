package com.techelevator.dao;

import com.techelevator.model.StaffAssignments;
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
    public List<StaffAssignments> getStaffAssignmentsByStaffId(int staffId) {
        List<StaffAssignments> list = new ArrayList<>();

        String sql = "SELECT * FROM staff_assignment WHERE staff_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, staffId);

        while(results.next()) {
            list.add(mapRowToStaffAssignments(results));
        }

        return list;
    }

    @Override
    public List<StaffAssignments> getStaffAssignmentsByAssignmentId(int assignmentId) {
        List<StaffAssignments> list = new ArrayList<>();

        String sql = "SELECT * FROM staff_assignment WHERE assignment_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, assignmentId);

        while(results.next()) {
            list.add(mapRowToStaffAssignments(results));
        }

        return list;
    }

    private StaffAssignments mapRowToStaffAssignments(SqlRowSet row) {
        StaffAssignments staffAssignments = new StaffAssignments();

        staffAssignments.setStaffId(row.getInt("staff_id"));
        staffAssignments.setAssignmentId(row.getInt("assignment_id"));

        return staffAssignments;
    }

}
