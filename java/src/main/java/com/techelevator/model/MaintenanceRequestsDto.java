package com.techelevator.model;

public class MaintenanceRequestsDto {

    private int requestId;
    private int status;
    private String dateRequested;
    private String description;
    private int tenantId;
    private int propertyId;

    public MaintenanceRequestsDto() {};

    public MaintenanceRequestsDto(int requestId, int status, String dateRequested, String description, int tenantId, int propertyId) {
        this.requestId = requestId;
        this.status = status;
        this.dateRequested = dateRequested;
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

    public String getDateRequested() {
        return dateRequested;
    }

    public void setDateRequested(String dateRequested) {
        this.dateRequested = dateRequested;
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
        return "MaintenanceRequestsDto{" +
                "requestId=" + requestId +
                ", status=" + status +
                ", dateRequested='" + dateRequested + '\'' +
                ", description='" + description + '\'' +
                ", tenantId=" + tenantId +
                ", propertyId=" + propertyId +
                '}';
    }
}
