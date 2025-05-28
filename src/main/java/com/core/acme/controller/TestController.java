package com.core.acme.controller;
import com.core.acme.domain.test.Test;
import com.core.acme.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
@CrossOrigin(origins = "*")
@Slf4j
public class TestController {
    private final TestService testService;

    @Autowired
    public TestController(TestService testService) {
        this.testService = testService;
    }

    @PostMapping("/create-test")
    public ResponseEntity<Test> createTest(@RequestBody Test test)
    {
        log.info("[TEST][CONTROLLER] Create Test : {} ", test);
        Test savedTest = testService.saveTest(test);
        return ResponseEntity.ok(savedTest);
    }

    @PostMapping("/create-test-from-form")
    public ResponseEntity<Test> createTestFromForm( Test test)
    {
        log.info("[TEST][CONTROLLER] Create Test via form : {} ", test);
        Test savedTest = testService.saveTest(test);
        return ResponseEntity.ok(savedTest);
    }


    @GetMapping("/{testId}")
    public ResponseEntity<Test> getTestByTestId(@RequestBody String id)
    {
        log.info("[TEST][CONTROLLER] Get Test By testId : {} ", id);
        return ResponseEntity.ok(testService.getTestById(id));
    }

    @GetMapping("/test-list")
    public ResponseEntity<List<Test>> getAllTests()
    {
        log.info("[TEST][CONTROLLER] Get All Tests ");
        return ResponseEntity.ok(testService.getAllTests());
    }

    @GetMapping("/get-test-by-test-name")
    public ResponseEntity<Test> getTestByName(String testName){
        log.info("[TEST][CONTROLLER] Get Test By name : {} ", testName);
        return ResponseEntity.ok(testService.getTestByName(testName));
    }

    @DeleteMapping("/delete-all-tests")
    public void deleteAllTests(){
        log.info("[TEST][CONTROLLER] Delete All Tests ");
        testService.deleteAllTests();
    }

    @DeleteMapping("/delete-by-test-id")
    public void deleteByTestId(String testId){
        log.info("[TEST][CONTROLLER] Delete Test By testId : {} ", testId);
        testService.deleteByTestId(testId);
    }
}
