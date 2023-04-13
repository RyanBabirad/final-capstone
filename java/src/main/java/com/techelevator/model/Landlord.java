package com.techelevator.model;

public class Landlord {

    private int landLordId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private int userId;


    public Landlord() {}; //default constructor

    public Landlord(int landLordId, String firstName, String lastName, String email, String phone, int userId) {
        this.landLordId = landLordId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.userId = userId;
    }

    public int getLandLordId() {
        return landLordId;
    }

    public void setLandLordId(int landLordId) {
        this.landLordId = landLordId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
