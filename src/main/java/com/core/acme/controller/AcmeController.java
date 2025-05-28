/* (C)2025 */
package com.core.acme.controller;

import com.core.acme.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/acme")
@CrossOrigin(origins = "*")
public class AcmeController {
    @Autowired private final QuestionService questionService;

    public AcmeController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("")
    public String AppIsLive() {
        return "The APPLICATION is LIVE ";
    }

    @GetMapping("/home")
    public String Home() {
        return "<h1>Hello Welcome to the Acme Test Platform</h1>";
    }
}
