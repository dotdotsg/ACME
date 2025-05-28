package com.core.acme.service;

import com.core.acme.DTO.QuestionDTO;
import com.core.acme.domain.question.Question;

import java.util.List;

public interface QuestionService {

    Question saveQuestion(Question question) ;
    Question getQuestionById(String id);
    Question getQuestionByQuestionId(String id);
    Question updateQuestion(String id, Question question);


    List<Question> getAllQuestions();
    List<Question> searchQuestionsByTags(List<String> tags);

    void deleteQuestion(String qid);
    void deleteAllQuestions();

    QuestionDTO convertQuestionToDTO(Question question);



}
