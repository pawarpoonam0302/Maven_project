package com.demo.testhr;


import com.nec.hr.HRService;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.sql.SQLException;


public class HRTest {

    private HRService hrservice;

    //@Before
    public void setUp(){
        hrservice = new HRService();
    }


    @Test
    public void hireEmpTest() throws SQLException {
     boolean result = hrservice.hireEmployee();
     assertFalse(result, "test should fail with empty data");
    }
}
