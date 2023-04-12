package com.techelevator.dao;

import com.techelevator.model.Landlord;

public interface LandlordDao {

    boolean createLandlord(String firstName, String lastName, String email, String phone);

    Landlord getLandLordById(int landLordId);

    Landlord updateLandlord(Landlord landlord); //update can also be used to remove an inactive landlord from page maybe? - Colin


}
