package com.core.acme.controller;

import com.core.acme.domain.Question;
import com.core.acme.domain.Test;
import com.core.acme.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @PostMapping("/create-test")
    public ResponseEntity<Test> saveTest(@RequestBody Test test)
    {
        Test savedTest = testService.saveTest(test);
        return ResponseEntity.ok().body(savedTest);
    }
    @PostMapping("/create-test-from-form")
    public ResponseEntity<Test> saveTestFromForm(@RequestBody Test test)
    {
        Test savedTest = testService.saveTest(test);
        return ResponseEntity.ok().body(savedTest);
    }
    @GetMapping("/get-test-by-id")
    public ResponseEntity<Test> getTestById(@RequestBody String id)
    {
        return ResponseEntity.ok().body(testService.getTestById(id));
    }
    @GetMapping("/get-test-by-test-id")
    public ResponseEntity<Test> getTestByTestId(@RequestBody String id)
    {
        return ResponseEntity.ok().body(testService.getTestById(id));
    }
    @GetMapping("/test-list")
    public ResponseEntity<List<Test>> getAllTests(){
        return ResponseEntity.ok().body(testService.getAllTests());
    }
}
