package com.techelevator.model;

public class PropertyDto {

    // instance variables ..............................................................................................

    private int propertyId;
    private String imgSrc;
    private String streetAddress;
    private int zipCode;
    private String state;
    private String unit;
    private int rentAmount;
    private String description;
    private int landlordId;


    // getters .........................................................................................................

    public int getPropertyId() {
        return propertyId;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public int getZipCode() {
        return zipCode;
    }

    public String getState() {
        return state;
    }

    public String getUnit() {
        return unit;
    }

    public int getRentAmount() {
        return rentAmount;
    }

    public String getDescription() {
        return description;
    }

    public int getLandlordId() {
        return landlordId;
    }
}
