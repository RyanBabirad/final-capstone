package com.techelevator.model;

import java.math.BigDecimal;

public class Property {

    private int propertyId;
    private String imgSrc;
    private String streetAddress;
    private int zipCode;
    private String state;
    private String unit;
    private int rentAmount;
    private String description;
    private int landlordId;


    public Property() {
    }

    public Property(int propertyId, String imgSrc, String streetAddress, int zipCode, String state, String unit,
                    int rentAmount, String description, int landlordId) {
        this.propertyId = propertyId;
        this.imgSrc = imgSrc;
        this.streetAddress = streetAddress;
        this.zipCode = zipCode;
        this.state = state;
        this.unit = unit;
        this.rentAmount = rentAmount;
        this.description = description;
        this.landlordId = landlordId;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getRentAmount() {
        return rentAmount;
    }

    public void setRentAmount(int rentAmount) {
        this.rentAmount = rentAmount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLandlordId() {
        return landlordId;
    }

    public void setLandlordId(int landlordId) {
        this.landlordId = landlordId;
    }
}