package com.techelevator.dao;

import com.techelevator.model.Rent;

import java.util.List;

public interface RentDao {

    boolean createRent(Rent rent);

    List<Rent> getRentsByTenantId(int tenantId);

    List<Rent> getRentsByLandlordId(int landlordId);

}

    // public updateRent(int rentId);
