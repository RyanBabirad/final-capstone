package com.techelevator.dao;

import com.techelevator.model.Landlord;
import com.techelevator.model.Property;
import com.techelevator.model.Tenant;

import java.util.List;

public interface LandlordDao {

    //boolean createLandlord(int userId, String firstName, String lastName, String email, String phone);
    boolean createLandlord(int landlordId, Landlord landlord);
    // this does not work yet - Colin
    void assignTenant(int propertyId, int landlordId, int tenantId);

    int findLandlordIdByEmail(String email);

    int getUserId(int userId);

    Landlord getLandLordById(int landLordId);

    Landlord updateLandlord(Landlord landlord); //update can also be used to remove an inactive landlord from page maybe? - Colin

    int getPropertyIdByLandlord(String email);

    void assignPropertyToTenant(int tenantId, int landlordId, int propertyId);


    }
