package com.techelevator.model;

public class AssignmentsDto {

    private int assignmentId;
    private int requestId;
    private boolean isAssigned;
    private String date;
    private int propertyId;
    private int staffId;

    public AssignmentsDto() {};

    public AssignmentsDto(int assignmentId, int requestId, boolean isAssigned, String date, int propertyId, int staffId) {
        this.assignmentId = assignmentId;
        this.requestId = requestId;
        this.isAssigned = isAssigned;
        this.date = date;
        this.propertyId = propertyId;
        this.staffId = staffId;
    }

    public int getAssignmentId() {
        return assignmentId;
    }

    public int getRequestId() {
        return requestId;
    }

    public boolean isAssigned() {
        return isAssigned;
    }

    public String getDate() {
        return date;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public int getStaffId() {
        return staffId;
    }

    @Override
    public String toString() {
        return "AssignmentsDto{" +
                "assignmentId=" + assignmentId +
                ", requestId=" + requestId +
                ", isAssigned=" + isAssigned +
                ", date='" + date + '\'' +
                ", propertyId=" + propertyId +
                '}';
    }

}

