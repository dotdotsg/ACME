package com.core.acme.controller;

import com.core.acme.DTO.QuestionDTO;
import com.core.acme.domain.Exam;
import com.core.acme.domain.Question;
import com.core.acme.domain.Student;
import com.core.acme.service.ExamService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<QuestionDTO> startExam(String examId){ // @PathVariable
        return ResponseEntity.ok().body(examService.getFirstQuestion(examId));
    }

    @GetMapping("/update-exam")
    public QuestionDTO updateExamAndGetNextQuestion( String examId, String studentAns){
        examService.updateExam(examId,studentAns);
        if(examService.examEnded()){
            examHasEnded(examId);
            return null;
        }
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
    @GetMapping("/exam-list")
    public List<Exam> getAllExams(){
        return examService.getExamList();
    }
    @GetMapping("/delete-all-exams")
    public void deleteAllExams(){
        examService.deleteAllExam();
    }
    @GetMapping("delete-by-exam-id")
    public void deleteByExamId(String examId){
        examService.deleteByExamId(examId);
    }

    @GetMapping("/exam-ended")
    public String examHasEnded(String examId){
        return ("Exam Has Ended......." +
                "You have Scored"+examService.getExamByExamId(examId).getScore());
    }
}
