package com.core.acme.service;

import com.core.acme.domain.Question;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

public interface AcmeService {

    Question saveQuestion(Question question) ;
    Question getQuestionById(String id);
    Question getQuestionByQuestionId(String id);
    Question updateQuestion(String id, Question question);


    List<Question> getAllQuestions();
    List<Question> searchQuestionsByTag(List<String> tags);

    void deleteQuestion(String qid);
    void deleteAllQuestions();





}
