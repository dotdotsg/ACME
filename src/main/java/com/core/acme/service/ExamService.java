package com.core.acme.service;

import com.core.acme.domain.Exam;
import com.core.acme.domain.Question;

public interface ExamService{

    Exam createExam(Exam exam);
    String startNewExam(Exam exam);  // returns the exam id generated
    Exam getExamById(String examId);
    void updateExam(String examId,String studentAns);
    boolean checkAnswer(String questionId, String studentAns);
    Question getFirstQuestion(String examId);
    //   int updateScore(boolean isCorrect);  // this function will be used inside the update Exam method
    Question getNextQuestion(String examId);
    Exam getExamByExamId(String id);
    void deleteAllExam();
    void deleteByExamId(String examId);
    void resetExam(String examId);
}
