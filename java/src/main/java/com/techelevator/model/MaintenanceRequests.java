package com.techelevator.model;

public class MaintenanceRequests {

//    request_id SERIAL,
//    status boolean DEFAULT false,
//    date_requested date,
//    description varchar(350),
//    tenant_id int,
//    property_id int,

    private int requestId;
    private int status;
    private String date;  // BE SURE TO CHECK THIS!!!!
    private String description;
    private int tenantId;
    private int propertyId;

    public MaintenanceRequests() {}; //default constructor


    public MaintenanceRequests(int requestId, int status, String date, String description, int tenantId, int propertyId) {
        this.requestId = requestId;
        this.status = status;
        this.date = date;
        this.description = description;
        this.tenantId = tenantId;
        this.propertyId = propertyId;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public int isStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTenantId() {
        return tenantId;
    }

    public void setTenantId(int tenantId) {
        this.tenantId = tenantId;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    @Override
    public String toString() {
        return "MaintenanceRequests{" +
                "requestId=" + requestId +
                ", status=" + status +
                ", date='" + date + '\'' +
                ", description='" + description + '\'' +
                ", tenantId=" + tenantId +
                ", propertyId=" + propertyId +
                '}';
    }


}
