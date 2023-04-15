package com.techelevator.dao;

import com.techelevator.model.Assignments;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Component
public class JdbcAssignmentsDao implements AssignmentsDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcAssignmentsDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean createAssignment(Assignments assignment) {
        String sql = "INSERT INTO assignments (request_id, is_assigned, date_assigned, property_id) VALUES (?, ?, ?, ?)";
        int rowsAffected = jdbcTemplate.update(sql, assignment.getRequestId(), assignment.isAssigned(), assignment.getDate(), assignment.getPropertyId());
        return rowsAffected > 0;
    }

    @Override
    public Assignments getAssignmentById(int id) {
        Assignments assignment;
        try {
            String sql = "SELECT * FROM assignments WHERE assignments_id = ?";
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, id);
            if (rowSet.next()) {
                assignment = mapRowToAssignments(rowSet);
            } else {
                throw new EmptyResultDataAccessException("No assignment found with the specified ID", 1);
            }
        } catch (EmptyResultDataAccessException e) {
            throw new UsernameNotFoundException("No assignment found with the specified ID", e);
        }
        return assignment;
    }

    @Override
    public boolean updateAssignment(Assignments assignment) {
        String sql = "UPDATE assignments SET request_id = ?, is_assigned = ?, date_assigned = ?, property_id = ? WHERE assignments_id = ?";
        int rowsAffected = jdbcTemplate.update(sql, assignment.getRequestId(), assignment.isAssigned(), assignment.getDate(), assignment.getPropertyId(), assignment.getAssignmentId());
        return rowsAffected > 0;
    }

    @Override
    public void deleteAssignments(Assignments assignment) {
        String sql = "DELETE FROM assignments WHERE assignments_id = ?";
        jdbcTemplate.update(sql, assignment.getAssignmentId());
    }

    private Assignments mapRowToAssignments(SqlRowSet rowSet) {
        Assignments assignment = new Assignments();
        assignment.setAssignmentId(rowSet.getInt("assignments_id"));
        assignment.setRequestId(rowSet.getInt("request_id"));
        assignment.setAssigned(rowSet.getBoolean("is_assigned"));
        assignment.setDate(rowSet.getString("date_assigned"));
        assignment.setPropertyId(rowSet.getInt("property_id"));
        return assignment;
    }
}



//    private int assignmentId;
//    private int requestId;
//    private boolean isAssigned;
//    private String date; // BE SURE TO CHECK THIS!!
//    private int propertyId;

//    assignments table params:
//    assignment_id SERIAL PRIMARY KEY,
//    request_id int,
//    is_assigned boolean DEFAULT false,
//    date_assigned (Katy changed to STRING) date,
//    property_id int,


