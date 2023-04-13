package com.techelevator.dao;

import com.techelevator.model.Staff;

//staff table params:
//        staff_id int,
//        first_name varchar(20) NOT NULL,
//        last_name varchar(20) NOT NULL,
//        email varchar(50) NOT NULL,
//        phone varchar(12) NOT NULL,
//        landlord_id int,

public interface StaffDao {
    boolean createStaff(Staff staff);
    Staff getStaffById(int id);
    boolean updateStaff(Staff staff);
    void deleteStaff(Staff staff);

}
