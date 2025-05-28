/* (C)2025 */
package com.core.acme.controller;

import com.core.acme.domain.question.Question;
import com.core.acme.service.QuestionService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/question")
@CrossOrigin(origins = "*")
@Slf4j
public class QuestionController {
    private final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/question-list")
    public List<Question> getAllQuestion() {
        return questionService.getAllQuestions();
    }

    @GetMapping("/{questionId}")
    public Question getQuestionByQuestionId(@PathVariable String questionId) {
        log.info("[QUESTION][CONTROLLER] Get Question By questionId : {} ", questionId);
        return questionService.getQuestionByQuestionId(questionId);
    }

    @PostMapping("/search-by-tags")
    public ResponseEntity<List<Question>> getQuestionByTags(@RequestBody List<String> tags) {
        log.info("[QUESTION][CONTROLLER] Get Question By tags : {} ", tags);
        return ResponseEntity.ok(questionService.searchQuestionsByTags(tags));
    }

    @PostMapping("/create-question")
    public ResponseEntity<Question> createQuestion(@RequestBody Question question) {
        Question savedQuestion = questionService.saveQuestion(question);
        log.info("[QUESTION][CONTROLLER] Create Question with question details : {} ", question);
        return ResponseEntity.ok(savedQuestion);
    }

    @PostMapping("/create-question-from-form")
    public ResponseEntity<Question> createQuestionFromForm(Question question) {
        Question savedQuestion = questionService.saveQuestion(question);
        log.info(
                "[QUESTION][CONTROLLER] Create Question with question details via form : {} ",
                question);
        return ResponseEntity.ok(savedQuestion);
    }
}
