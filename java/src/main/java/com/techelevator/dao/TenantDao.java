package com.techelevator.dao;

import com.techelevator.model.Landlord;
import com.techelevator.model.Property;
import com.techelevator.model.Tenant;

public interface TenantDao {

    boolean createTenant(int tenantId, Tenant tenant);

    Tenant getTenantById(int tenantId);

    Tenant updateTenant(Tenant tenant);

    Landlord getLandlordByTenantId(int tenantId);

    Property getPropertyByTenantId(int tenantId);

}
