package com.techelevator.dao;

import com.techelevator.model.Rent;

import java.util.List;

public interface RentDao {

    public boolean createRent();

    public List<Rent> getRentsByTenantId();

    public List<Rent> getRentsByLandlordId();

    public List<Rent> getRentsByPropertyId();

    public updateRent(int rentId);
}
