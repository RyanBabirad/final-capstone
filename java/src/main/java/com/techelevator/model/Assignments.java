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
    private String date; // BE SURE TO CHECK THIS!!
    private int propertyId;

    public Assignments() {}; //default constructor


    public Assignments(int assignmentId, int requestId, boolean isAssigned, String date, int propertyId) {
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
        return "Assignments{" +
                "assignmentId=" + assignmentId +
                ", requestId=" + requestId +
                ", isAssigned=" + isAssigned +
                ", date='" + date + '\'' +
                ", propertyId=" + propertyId +
                '}';
    }
}
