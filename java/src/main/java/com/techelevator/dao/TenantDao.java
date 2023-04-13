package com.techelevator.dao;

import com.techelevator.model.Tenant;

public interface TenantDao {

    boolean createTenant(int tenantId, Tenant tenant);

    Tenant getTenantById(int tenantId);

    Tenant updateTenant(Tenant tenant);


}
