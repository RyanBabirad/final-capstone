package com.techelevator.controller;

import com.techelevator.dao.StaffDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Staff;
import com.techelevator.model.StaffDto;
import com.techelevator.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@CrossOrigin
public class StaffController {

    @Autowired
    private StaffDao staffDao;
    @Autowired
    private UserDao userDao;

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/staff", method = RequestMethod.POST)
    public Staff createStaff(@Valid @RequestBody StaffDto staffDto, Principal principal) {
        Staff staff = new Staff();
        User user = userDao.findByUsername(principal.getName());

        staff.setStaffId(user.getId());
        staff.setFirstName(staffDto.getFirstName());
        staff.setLastName(staffDto.getLastName());
        staff.setEmail(staffDto.getEmail());
        staff.setPhone(staffDto.getPhone());

        staffDao.createStaff(staff.getStaffId(), staff);
        return staff;
    }

}

