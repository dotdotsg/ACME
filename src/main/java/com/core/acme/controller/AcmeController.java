package com.core.acme.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.core.acme.domain.Question;
import com.core.acme.service.AcmeService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/acme")
@CrossOrigin(origins = "*")
public class AcmeController {
    @Autowired
    private final AcmeService acmeService;

    public AcmeController(AcmeService acmeService) {
        this.acmeService = acmeService;
    }
    @GetMapping("/")
    public String AppIsLive(){
        return "The APPLICATION is LIVE ";
    }
    @GetMapping("/home")
    public String Home() {
        return "<h1>Hello Welcome to the Acme Test Platform</h1>";
    }

    // Get Question by ID
    @GetMapping("find-by-id/{id}")
    public Question getQuestionById(@PathVariable String id) {
        System.out.println("Controller checking id recieved | "+id );
        return acmeService.getQuestionById(id);
    }
    @GetMapping("/find-by-qid/{questionId}")
    public Question getQuestionByQuestionId(@PathVariable String questionId) {
        System.out.println("Controller checking id recieved | "+questionId );
        return acmeService.getQuestionByQuestionId(questionId);
    }
    @GetMapping("/question-list")
    public List<Question> getAllQuestion() {
        return acmeService.getAllQuestions();
    }
    @GetMapping("/search-by-tags")
    public List<Question> getQuestionByTags(@RequestBody List<String> tags) {
        return acmeService.searchQuestionsByTag(tags);
    }
    @PostMapping("/create_question")
    public ResponseEntity<Question> saveQuestion(@RequestBody Question question)
    {
        Question savedQuestion = acmeService.saveQuestion(question);
        return ResponseEntity.created(URI.create("http://127.0.0.1:8080/acme/create_question")).body(savedQuestion);
    }
    @PostMapping("/create-question-from-form")
    public ResponseEntity<Question> saveQuestionFromForm(Question question)
    {
        Question savedQuestion = acmeService.saveQuestion(question);
        return ResponseEntity.created(URI.create("http://127.0.0.1:8080/acme/create-question-from-form")).body(savedQuestion);
    }


    // other services need to be implmented here on
}