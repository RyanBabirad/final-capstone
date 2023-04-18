package com.techelevator.dao;

import com.techelevator.model.StaffAssignments;

import java.util.List;

public interface StaffAssignmentsDao {

    boolean createStaffAssignment(int staffId, int assignmentId);

    List<StaffAssignments> getStaffAssignmentsByStaffId(int staffId);

    List<StaffAssignments> getStaffAssignmentsByAssignmentId(int assignmentId);

}
