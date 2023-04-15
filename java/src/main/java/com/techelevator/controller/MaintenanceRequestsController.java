package com.techelevator.controller;

import com.techelevator.dao.MaintenanceRequestsDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.MaintenanceRequests;
import com.techelevator.model.MaintenanceRequestsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@CrossOrigin
public class MaintenanceRequestsController {

    @Autowired
    private MaintenanceRequestsDao maintenanceRequestsDao;

    @Autowired
    private UserDao userDao;

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/staff/maintenance-requests", method = RequestMethod.POST)
    public MaintenanceRequests createMaintenanceRequest(@Valid @RequestBody MaintenanceRequestsDto maintenanceRequestsDto, Principal principal) {
        MaintenanceRequests maintenanceRequest = new MaintenanceRequests();

        maintenanceRequest.setRequestId(maintenanceRequestsDto.getRequestId());
        maintenanceRequest.setStatus(maintenanceRequestsDto.isStatus());
        maintenanceRequest.setDate(maintenanceRequestsDto.getDateRequested());
        maintenanceRequest.setDescription(maintenanceRequestsDto.getDescription());
        maintenanceRequest.setTenantId(maintenanceRequestsDto.getTenantId());
        maintenanceRequest.setPropertyId(maintenanceRequestsDto.getPropertyId());

        maintenanceRequestsDao.createMaintenanceRequests(maintenanceRequest);

        return maintenanceRequest;
    }

    @RequestMapping(path = "/staff/maintenance-requests/{id}", method = RequestMethod.GET)
    public MaintenanceRequests getMaintenanceRequestById(@PathVariable int id, Principal principal) {
        return maintenanceRequestsDao.getMaintenanceRequestById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/staff/maintenance-requests/{id}", method = RequestMethod.PUT)
    public boolean updateMaintenanceRequest(@PathVariable int id, @Valid @RequestBody MaintenanceRequestsDto maintenanceRequestsDto, Principal principal) {
        MaintenanceRequests maintenanceRequest = maintenanceRequestsDao.getMaintenanceRequestById(id);

        maintenanceRequest.setStatus(maintenanceRequestsDto.isStatus());
        maintenanceRequest.setDate(maintenanceRequestsDto.getDateRequested());
        maintenanceRequest.setDescription(maintenanceRequestsDto.getDescription());
        maintenanceRequest.setTenantId(maintenanceRequestsDto.getTenantId());
        maintenanceRequest.setPropertyId(maintenanceRequestsDto.getPropertyId());

        return maintenanceRequestsDao.updateMaintenanceRequests(maintenanceRequest);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/staff/maintenance-requests/{id}", method = RequestMethod.DELETE)
    public void deleteMaintenanceRequest(@PathVariable int id, Principal principal) {
        MaintenanceRequests maintenanceRequest = maintenanceRequestsDao.getMaintenanceRequestById(id);
        maintenanceRequestsDao.deleteMaintenanceRequests(id);
    }
}

