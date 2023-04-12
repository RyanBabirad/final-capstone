package com.techelevator.dao;

import com.techelevator.model.Tenant;

public interface TenantDao {

    Tenant createTenant(Tenant tenant);

    Tenant getTenantById(int tenantId);

    Tenant updateTenant(Tenant tenant);


}
