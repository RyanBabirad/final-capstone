package com.techelevator.dao;

import com.techelevator.model.StaffAssignment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

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


        return null;
    }

    @Override
    public List<StaffAssignment> getStaffAssignmentsByAssignmentId(int assignmentId) {


        return null;
    }

}
