package com.techelevator.model;

public class AssignmentsDto {

    private int assignmentId;
    private int requestId;
    private boolean isAssigned;
    private String date;
    private int propertyId;

    public AssignmentsDto() {}; //default constructor

    public AssignmentsDto(int assignmentId, int requestId, boolean isAssigned, String date, int propertyId) {
        this.assignmentId = assignmentId;
        this.requestId = requestId;
        this.isAssigned = isAssigned;
        this.date = date;
        this.propertyId = propertyId;
    }

    public int getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public boolean isAssigned() {
        return isAssigned;
    }

    public void setAssigned(boolean assigned) {
        isAssigned = assigned;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
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

