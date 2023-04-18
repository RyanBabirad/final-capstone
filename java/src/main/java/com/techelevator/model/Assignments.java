package com.techelevator.model;

public class Assignments {

//    assignment_id SERIAL PRIMARY KEY,
//    request_id int,
//    is_assigned boolean DEFAULT false,
//    date_assigned date,
//    property_id int,

    private int assignmentId;
    private int requestId;
    private boolean isAssigned;
    private String date;
    private int propertyId;
    private int staffId;

    public Assignments() {};


    public Assignments(int assignmentId, int requestId, boolean isAssigned, String date, int propertyId, int staffId) {
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

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    @Override
    public String toString() {
        return "Assignments{" +
                "assignmentId=" + assignmentId +
                ", requestId=" + requestId +
                ", isAssigned=" + isAssigned +
                ", date='" + date + '\'' +
                ", propertyId=" + propertyId +
                '}';
    }
}
