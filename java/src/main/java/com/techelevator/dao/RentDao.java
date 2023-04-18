package com.techelevator.dao;

import com.techelevator.model.Rent;

import java.util.List;

public interface RentDao {

    public boolean createRent();

    public List<Rent> getRentsByTenantId();

    public List<Rent> getRentsByLandlordId();

    public List<Rent> getRentsByPropertyId();

<<<<<<< HEAD
    // public updateRent(int rentId);
=======
  //  public updateRent(int rentId);
>>>>>>> e8c71a929ea927b903f578a24073c451c18a9abe
}
