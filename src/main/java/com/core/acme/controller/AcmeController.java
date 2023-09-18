package com.core.acme.controller;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.core.acme.domain.Question;
import com.core.acme.service.AcmeService;

import java.util.List;

@RestController
@RequestMapping("/acme")
public class AcmeController {
    @Autowired
    private final AcmeService acmeService;

    public AcmeController(AcmeService acmeService) {
        this.acmeService = acmeService;
    }
    @GetMapping("/home")
    public String Home() {
        return "<h1>Hello Welcome to the Acme Test Platform</h1>";
    }

    // Get Question by ID
    @GetMapping("/{id}")
    public Question getQuestionById(@PathVariable String id) {
        System.out.println("Controller checking id recieved | "+id );
        return acmeService.getQuestionById(id);
    }
    @GetMapping("/byQid/{questionId}")
    public Question getQuestionByQuestionId(@PathVariable String questionId) {
        System.out.println("Controller checking id recieved | "+questionId );
        return acmeService.getQuestionByQuestionId(questionId);
    }
    @GetMapping("/byTags")
    public List<Question> getQuestionTags(@RequestParam(name="tags") List<String> tags) {
        System.out.println("Controller checking id recieved | "+tags );
        return acmeService.searchQuestionsByTag(tags);
    }
    @PostMapping("/create_question")
    public ResponseEntity<Question> saveQuestion(@RequestBody Question question)
    {
        Question savedQuestion = acmeService.saveQuestion(question);
        return ResponseEntity.ok().body(savedQuestion);
    }


    // other services need to be implmented here on
}