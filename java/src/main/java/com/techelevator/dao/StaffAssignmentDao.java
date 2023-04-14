package com.techelevator.dao;

import com.techelevator.model.StaffAssignment;

import java.util.List;

public interface StaffAssignmentDao {

    boolean createStaffAssignment(int staffId, int assignmentId);

    StaffAssignment getStaffAssignment(int staffId, int assignmentId);

    List<StaffAssignment> getStaffAssignmentsByStaffId(int staffId);

    List<StaffAssignment> getStaffAssignmentsByAssignmentId(int assignmentId);

}
