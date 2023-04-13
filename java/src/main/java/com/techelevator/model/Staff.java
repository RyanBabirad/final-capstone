package com.techelevator.model;

public class Staff {
    private int staffId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private int landlordId;

    public Staff() {}; //default constructor


    public Staff(int staffId, String firstName, String lastName, String email, String phone, int landlordId) {
        this.staffId = staffId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.landlordId = landlordId;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
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

    public int getLandlordId() {
        return landlordId;
    }

    public void setLandlordId(int landlordId) {
        this.landlordId = landlordId;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "staffId=" + staffId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", landlordId=" + landlordId +
                '}';
    }
}
