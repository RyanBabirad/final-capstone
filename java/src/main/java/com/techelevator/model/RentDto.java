package com.techelevator.model;

import java.math.BigDecimal;

public class RentDto {

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


    // getters .........................................................................................................

    public int getRentId() {
        return rentId;
    }

    public String getDueDate() {
        return dueDate;
    }

    public String getPaidDate() {
        return paidDate;
    }

    public int getPaymentStatus() {
        return paymentStatus;
    }

    public float getAmountPaid() {
        return amountPaid;
    }

    public float getAmountDue() {
        return amountDue;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public int getTenantId() {
        return tenantId;
    }

    public int getLandlordId() {
        return landlordId;
    }
}
