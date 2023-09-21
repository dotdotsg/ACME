package com.core.acme.controller;

import com.core.acme.domain.Exam;
import com.core.acme.domain.Question;
import com.core.acme.service.ExamService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exam")
public class ExamController {

   // @Autowired
    @Autowired
    public ExamService examService; // should not be used creating a loop

    @PostMapping("/create_exam")
    public Exam createExam(@RequestBody Exam exam){// @RequestBody
        return examService.createExam(exam);

    }
    @PostMapping("/create-exam-from-form")
    public Exam createExamFromForm( Exam exam){// @RequestBody
        return examService.createExam(exam);

    }
    // start new exam is a different function, it sends the first question and starts the process
    @GetMapping("/start-exam")
    public Question startExam(String examId){ // @PathVariable
        return examService.getFirstQuestion(examId);
    }

    @GetMapping("/update-exam")
    public Question updateExamAndGetNextQuestion( String examId, String studentAns){
        examService.updateExam(examId,studentAns);
        return examService.getNextQuestion(examId);
    }
    @GetMapping("/reset-exam")
    public Exam resetExam( String examId){
        examService.resetExam(examId);
        return examService.getExamByExamId(examId);
    }
    @GetMapping("/find-exam-by-exam-id")
    public Exam getExamByExamId( String examId){
        return examService.getExamByExamId(examId);//find by exam id - user given
    }
    @GetMapping("/find-exam/{id}")
    public Exam getExamById(@PathVariable String id){
        return examService.getExamById(id);// find by database id
    }
    @GetMapping("/serve_question/{id}") // not to be used
    public Question getQuestionOfTest(@PathVariable String id){
        return null;
    }

    @GetMapping("/delete-all-exams")
    public void deleteAllExams(){
        examService.deleteAllExam();
    }
    @GetMapping("delete-by-exam-id")
    public void deleteByExamId(String examId){
        examService.deleteByExamId(examId);
    }
}
