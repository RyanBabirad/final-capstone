package com.techelevator.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcRentDao {

    // instance variables ..............................................................................................

    private final JdbcTemplate jdbcTemplate;


    // constructor .....................................................................................................

    public JdbcRentDao() {
    }
}
