package com.techelevator.controller;

import com.techelevator.dao.AssignmentsDao;
import com.techelevator.model.Assignments;
import com.techelevator.model.AssignmentsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
public class AssignmentsController {

    @Autowired
    private AssignmentsDao assignmentsDao;

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/landlord/maintenance-requests/assignment", method = RequestMethod.POST)
    public Assignments createAssignment(@Valid @RequestBody AssignmentsDto assignmentsDto) {
        Assignments assignment = new Assignments();

        assignment.setAssignmentId(assignmentsDto.getAssignmentId());
        assignment.setRequestId(assignmentsDto.getRequestId());
        assignment.setAssigned(assignmentsDto.isAssigned());
        assignment.setDate(assignmentsDto.getDate());
        assignment.setPropertyId(assignmentsDto.getPropertyId());

        assignmentsDao.createAssignment(assignment);

        return assignment;
    }

    @RequestMapping(path = "/landlord/maintenance-requests/assignment/{id}", method = RequestMethod.GET)
    public Assignments getAssignmentById(@PathVariable int id) {
        return assignmentsDao.getAssignmentById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/landlord/maintenance-requests/assignment", method = RequestMethod.PUT)
    public boolean updateAssignment(@Valid @RequestBody AssignmentsDto assignmentsDto) {
        Assignments assignment = new Assignments();

        assignment.setAssignmentId(assignmentsDto.getAssignmentId());
        assignment.setRequestId(assignmentsDto.getRequestId());
        assignment.setAssigned(assignmentsDto.isAssigned());
        assignment.setDate(assignmentsDto.getDate());
        assignment.setPropertyId(assignmentsDto.getPropertyId());

        return assignmentsDao.updateAssignment(assignment);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/landlord/maintenance-requests/assignment/{id}", method = RequestMethod.DELETE)
    public void deleteAssignment(@PathVariable int id) {
        Assignments assignment = assignmentsDao.getAssignmentById(id);
        assignmentsDao.deleteAssignments(assignment);
    }

}
