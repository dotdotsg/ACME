package com.core.acme.service.impl;

import com.core.acme.domain.Exam;
import com.core.acme.domain.Question;
import com.core.acme.domain.Test;
import com.core.acme.repository.ExamRepository;
import com.core.acme.service.AcmeService;
import com.core.acme.service.ExamService;
import com.core.acme.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamServiceImpl implements ExamService {
    @Autowired
    private ExamRepository examRepository;
    @Autowired
    private AcmeService acmeService;
    @Autowired
    private ExamService examService;
    @Autowired
    private TestService testService;

    @Override
    public Exam createExam(Exam exam) {
        return examRepository.save(exam);
    }

    @Override
    public String startNewExam(Exam exam) {       // starts new exam by returning the exam id
        //examService.getFirstQuestion(exam.getExamId());
        return null;
    }

    @Override
    public Exam getExamById(String id) {
        return examRepository.findById(id).get();
    } // by database id

    public Exam getExamByExamId(String examId){
        return examRepository.findByExamId(examId);
    }

    @Override
    public void deleteAllExam() {
        examRepository.deleteAll();
    }

    @Override
    public void deleteByExamId(String examId) {
        examRepository.deleteByExamId(examId);
    }

    @Override                                               // Sequence 1
    public void updateExam(String examId, String studentAns){              // updates everytime student sends an answer......
        // to update exam variables and update scores.  the index of current questions are updated by the checkAnswer Function.
        Exam exam = examRepository.findByExamId(examId);
        if(checkAnswer(examId,studentAns)) {
            exam.setScore(exam.getScore() + 4);
            System.out.println("correct Ans | "+exam.getScore());
        }
        else {
            //noIncrement but if negative marking is implemented that logic comes here
            exam.setScore(exam.getScore()-1);
            System.out.println("Incorrect Ans | "+exam.getScore());
        }

    } // do it  with only exam ID

    @Override                                               // Sequence 2
    public boolean checkAnswer(String examId, String studentAns) {
        Exam exam = examRepository.findByExamId(examId);
        Test test = testService.getTestByTestId(exam.getTestId());
        Question currentQuestion = acmeService.getQuestionByQuestionId(test.getQuestionsInTest().get(exam.getCurrentQuestionIndex()).get(exam.getCurrentSubQuestionIndex()));
        if (currentQuestion.getCorrectOpt() == studentAns) {
            if (test.getQuestionsInTest().get(exam.getCurrentQuestionIndex()).listIterator().hasNext()) { // if [next subQuestion exists]
                exam.setCurrentSubQuestionIndex(exam.getCurrentSubQuestionIndex() + 1);
                System.out.println("Q:"+exam.getCurrentQuestionIndex()+"subQ:"+exam.getCurrentSubQuestionIndex());

            } else if (test.getQuestionsInTest().listIterator().hasNext()) {    // if [next Question exists]
                exam.setCurrentSubQuestionIndex(0);
                exam.setCurrentQuestionIndex(exam.getCurrentQuestionIndex() + 1);
                System.out.println("Q:"+exam.getCurrentQuestionIndex()+"subQ:"+exam.getCurrentSubQuestionIndex());
            } else {
                // We are on last subQuestion of last Question
                // End Exam and Display Results.
                displayResults(examId);
            }
            System.out.println(examRepository.save(exam));
            return true;
        }
        else if (test.getQuestionsInTest().listIterator().hasNext()) {  // incorrect answer given , go to next question skipping all current sub-question of Question of [next Question exists]
            exam.setCurrentSubQuestionIndex(0);
            exam.setCurrentQuestionIndex(exam.getCurrentQuestionIndex() + 1);
            System.out.println("Q:"+exam.getCurrentQuestionIndex()+"subQ:"+exam.getCurrentSubQuestionIndex());
            System.out.println(examRepository.save(exam));
        }
        else {
            // We are on last Question no more questions exist, and we have given incorrect answer.
            // End Exam and Display Results.
            displayResults(examId);
        }
            return false;
    }
    public String displayResults(String examId){                       // Auto-sequence 3
        Exam exam = examRepository.findById(examId).get();
        System.out.println("The Exam Has Ended , You Have scored : "+exam.getScore());
        return "The Exam Has Ended , You Have scored : "+exam.getScore();
    }


    @Override
    public Question getFirstQuestion(String examId){
        Exam exam = examService.getExamByExamId(examId);
        String testId = exam.getTestId();
        Test test = testService.getTestByTestId(testId);
        String firstQuestionId = test.getQuestionsInTest().get(exam.getCurrentQuestionIndex()).get(exam.getCurrentSubQuestionIndex());
        System.out.println("first question : "+firstQuestionId);
        Question firstQuestion = acmeService.getQuestionByQuestionId(firstQuestionId);
        return firstQuestion;
    }

    @Override
    public Question getNextQuestion(String examId){
        //if(isCorrect) correct and incorrect logic has been stated in the check answer and next question index has been decided in checkAnswer method
        // we just have to return the next question using the exam.currentQuestionIndex and currentSubQuestionIndex
        Exam exam = examRepository.findByExamId(examId);
        String testId = exam.getTestId();
        Test test = testService.getTestByTestId(testId);
        String nextQuestionId = test.getQuestionsInTest().get(exam.getCurrentQuestionIndex()).get(exam.getCurrentSubQuestionIndex());
        System.out.println("Next Question called : "+nextQuestionId);
        Question nextQuestion = acmeService.getQuestionByQuestionId(nextQuestionId);
        return nextQuestion;
    }
}

/*
* getFirstQuestion:
*       CheckAnswer :
*           UpdateScore & ReturnNextQuestion Accordingly:
*                   CheckAnswer...............
* */
