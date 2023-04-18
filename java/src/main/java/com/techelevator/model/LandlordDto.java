package com.techelevator.model;

public class LandlordDto {

    // instance variables ..............................................................................................

    private int landLordId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private int userId;
    private int propertyId;
    private int tenantId;


    // getters .........................................................................................................

    public int getLandLordId() {
        return landLordId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public int getUserId() {
        return userId;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public int getTenantId() {
        return tenantId;
    }
}
