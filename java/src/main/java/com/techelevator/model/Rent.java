package com.techelevator.model;

import java.math.BigDecimal;

public class Rent {

    // instance variables ..............................................................................................

    private int rentId;
    private String dueDate;
    private String paidDate;
    private int paymentStatus;  // 0 for due, 1 for paid, 2 for overdue
    private float amountPaid;
    private float amountDue;
    private int propertyId;
    private int tenantId;
    private int landlordId;


    // constructors ....................................................................................................

    public Rent() {
    }

    public Rent(int rentId, String dueDate, String paidDate, int paymentStatus, float amountPaid,
                float amountDue, int propertyId, int tenantId, int landlordId) {
        this.rentId = rentId;
        this.dueDate = dueDate;
        this.paidDate = paidDate;
        this.paymentStatus = paymentStatus;
        this.amountPaid = amountPaid;
        this.amountDue = amountDue;
        this.propertyId = propertyId;
        this.tenantId = tenantId;
        this.landlordId = landlordId;
    }


    // Getters and setters .............................................................................................

    public int getRentId() {
        return rentId;
    }

    public void setRentId(int rentId) {
        this.rentId = rentId;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(String paidDate) {
        this.paidDate = paidDate;
    }

    public int getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(int paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public float getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(float amountPaid) {
        this.amountPaid = amountPaid;
    }

    public float getAmountDue() {
        return amountDue;
    }

    public void setAmountDue(float amountDue) {
        this.amountDue = amountDue;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public int getTenantId() {
        return tenantId;
    }

    public void setTenantId(int tenantId) {
        this.tenantId = tenantId;
    }

    public int getLandlordId() {
        return landlordId;
    }

    public void setLandlordId(int landlordId) {
        this.landlordId = landlordId;
    }
}
