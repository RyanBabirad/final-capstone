package com.techelevator.controller;

import com.techelevator.dao.AssignmentsDao;
import com.techelevator.dao.StaffAssignmentsDao;
import com.techelevator.model.StaffAssignments;
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
    @Autowired
    private StaffAssignmentsDao staffAssignmentsDao;

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/landlord/maintenance-request/assignments", method = RequestMethod.POST)
    public Assignments createAssignment(@Valid @RequestBody AssignmentsDto assignmentsDto) {
        // first create an entry in the assignments table

        Assignments assignment = new Assignments();

        assignment.setAssignmentId(assignmentsDto.getAssignmentId());
        assignment.setRequestId(assignmentsDto.getRequestId());
        assignment.setAssigned(assignmentsDto.isAssigned());
        assignment.setDate(assignmentsDto.getDate());
        assignment.setPropertyId(assignmentsDto.getPropertyId());

        assignmentsDao.createAssignment(assignment);

        // then create an entry in the staff_assignments table



        return assignment;
    }

    @RequestMapping(path = "/landlord/maintenance-request/assignments/{id}", method = RequestMethod.GET)
    public Assignments getAssignmentById(@PathVariable int id) {
        return assignmentsDao.getAssignmentById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/landlord/maintenance-request/assignments", method = RequestMethod.PUT)
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
    @RequestMapping(path = "/landlord/maintenance-request/assignments/{id}", method = RequestMethod.DELETE)
    public void deleteAssignment(@PathVariable int id) {
        Assignments assignment = assignmentsDao.getAssignmentById(id);
        assignmentsDao.deleteAssignments(assignment);
    }

}
