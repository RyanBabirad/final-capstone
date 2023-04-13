package com.techelevator.dao;

import com.techelevator.model.Landlord;

public interface LandlordDao {

    //boolean createLandlord(int userId, String firstName, String lastName, String email, String phone);
    boolean createLandlord(int landlordId, Landlord landlord);

    int findLandlordIdByEmail(String email);

    int getUserId(int userId);

    Landlord getLandLordById(int landLordId);

    Landlord updateLandlord(Landlord landlord); //update can also be used to remove an inactive landlord from page maybe? - Colin


}
