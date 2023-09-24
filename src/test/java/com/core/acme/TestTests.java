package com.core.acme;


import com.core.acme.service.TestService;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.mongodb.assertions.Assertions.assertNotNull;

@SpringBootTest

public class TestTests {
    @Autowired
    TestService testService;


    @Test
    public void contextLoads() {
    }

    @Test
    public void findAllTests(){
        List<com.core.acme.domain.Test> allTests =  testService.getAllTests();
        System.out.println("student List  :"+allTests.size());
        for(int i =0; i<allTests.size();i++){
            System.out.println(allTests.get(i).toString());
        }
        assertNotNull(allTests);
    }
    @Test
    public void findStudentByName(){
        String testName = "GMAT MTH 1";
        com.core.acme.domain.Test testsWithName =  testService.getTestByName(testName);
        System.out.println("test with test name |"+testName+"| :"+testsWithName);
        
        assertNotNull(testsWithName);
    }
}
