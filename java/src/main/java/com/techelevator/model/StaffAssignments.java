package com.techelevator.model;

public class StaffAssignments {

    private int staffId;
    private int assignmentId;

    public StaffAssignments() {
    }

    public StaffAssignments(int staffId, int assignmentId) {
        this.staffId = staffId;
        this.assignmentId = assignmentId;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public int getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }
}
