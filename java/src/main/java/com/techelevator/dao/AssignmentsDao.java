package com.techelevator.dao;

import com.techelevator.model.Assignments;


public interface AssignmentsDao {
//    assignments table params:
//    assignment_id SERIAL PRIMARY KEY,
//    request_id int,
//    is_assigned boolean DEFAULT false,
//    date_assigned date,
//    property_id int,

//    createAssignment
//            getAssignmentById
//    updateAssignment
//            deleteAssignment

    boolean createAssignment(Assignments assignment);

    Assignments getAssignmentById(int id);

    boolean updateAssignment(Assignments assignment);

    void deleteAssignments(Assignments assignment);


}
