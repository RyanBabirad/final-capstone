package com.techelevator.dao;

import com.techelevator.model.MaintenanceRequests;

public interface MaintenanceRequestsDao {

//    maintenance request params:
//    request_id SERIAL,
//    status boolean DEFAULT false,
//    date_requested date,
//    description varchar(350),
//    tenant_id int,
//    property_id int,

//    createMaintenanceRequest
//            getMaintenanceRequestById
//    updateMaintenanceRequest
//            deleteMaintenanceRequest

    boolean createMaintenanceRequests(MaintenanceRequests maintenanceRequest);

    MaintenanceRequests getMaintenanceRequestById(int id);

    boolean updateMaintenanceRequests(MaintenanceRequests maintenanceRequest);

    void deleteMaintenanceRequests(MaintenanceRequests maintenanceRequest);


}
