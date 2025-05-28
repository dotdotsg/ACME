/* (C)2025 */
package com.core.acme.service;

import com.core.acme.DTO.QuestionDTO;
import com.core.acme.domain.exam.Exam;
import java.util.List;

public interface ExamService {

    Exam createExam(Exam exam);

    String startExam(String examId); // this will return the examId to the user

    Exam getExamById(String examId);

    List<Exam> getExamList();

    void updateExam(String examId, String studentAns);

    public void setExamStatusCompleted(String examId);

    QuestionDTO getFirstQuestion(String examId);

    // checkAnswer method initially enlisted here has now been shifted to examUpdate Method
    // int updateScore(boolean isCorrect);  // this function will be used inside the update Exam
    // method
    QuestionDTO getNextQuestion(String examId);

    Exam getExamByExamId(String id);

    void deleteAllExam();

    void deleteByExamId(String examId);

    void resetExam(String examId);

    void endExam(String examId);

    boolean examEnded(String examId);
}
