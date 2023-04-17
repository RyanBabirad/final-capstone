package com.techelevator.dao;

import com.techelevator.model.StaffAssignment;

import java.util.List;

public interface StaffAssignmentsDao {

    boolean createStaffAssignment(int staffId, int assignmentId);

    List<StaffAssignment> getStaffAssignmentsByStaffId(int staffId);

    List<StaffAssignment> getStaffAssignmentsByAssignmentId(int assignmentId);

}
