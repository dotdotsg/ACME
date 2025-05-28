/* (C)2025 */
package com.core.acme.service.impl;

import com.core.acme.DTO.QuestionDTO;
import com.core.acme.domain.question.Question;
import com.core.acme.repository.QuestionRepository;
import com.core.acme.service.QuestionService;
import com.core.acme.utils.Constants;
import com.core.acme.utils.CustomIdUtil;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired private QuestionRepository questionRepository;
    @Autowired MongoTemplate mongoTemplate;

    public static String generateQuestionId() {
        return Constants.IdPrefix.QUESTION_ID_PREFIX + "-" + CustomIdUtil.getCustomID(8);
    }

    @Override
    public Question saveQuestion(Question question) {
        question.setQuestionId(generateQuestionId());
        return questionRepository.save(question);
    }

    @Override
    public Question getQuestionById(String id) {
        Optional<Question> questionOptionalObject = questionRepository.findById(id);
        System.out.println("called getQuestionById :" + id);
        return questionOptionalObject.orElse(null);
    }

    @Override
    public Question getQuestionByQuestionId(String questionId) {
        return questionRepository.findByQuestionId(questionId);
    }

    @Override
    public Question updateQuestion(String qid, Question question) {
        Optional<Question> savedQuestion = questionRepository.findById(qid);
        if (savedQuestion.isPresent()) {
            Question existingQuestion = savedQuestion.get();
            existingQuestion.setQuestion(question.getQuestion());
            existingQuestion.setTags(question.getTags());
            existingQuestion.setOptions(question.getOptions());
            existingQuestion.setCorrectOpt(question.getCorrectOpt());
            // save the updated Question in the repository
            return questionRepository.save(existingQuestion);
        }
        return null;
    }

    @Override
    public void deleteQuestion(String qid) {
        questionRepository.deleteById(qid);
    }

    @Override
    public void deleteAllQuestions() {
        questionRepository.deleteAll();
    }

    @Override
    public QuestionDTO convertQuestionToDTO(Question question) {
        QuestionDTO questionDTO = new QuestionDTO();
        questionDTO.setId(question.getId());
        questionDTO.setQuestionId(question.getQuestionId());
        questionDTO.setTags(question.getTags());
        questionDTO.setQuestion(question.getQuestion());
        questionDTO.setDifficultyLevel(question.getDifficultyLevel());
        questionDTO.setOptions(question.getOptions());
        return questionDTO;
    }

    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public List<Question> searchQuestionsByTags(List<String> tags) {
        Query query = new Query();
        query.addCriteria(Criteria.where("tags").in(tags));
        return mongoTemplate.find(query, Question.class);
    }
}
