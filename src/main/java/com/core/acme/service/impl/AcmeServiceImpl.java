package com.core.acme.service.impl;

import com.core.acme.DTO.QuestionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import com.core.acme.domain.Question;
import com.core.acme.repository.AcmeRepository;
import com.core.acme.service.AcmeService;

import java.util.List;
import java.util.Optional;

@Service
public class AcmeServiceImpl implements AcmeService {
    
    @Autowired
    private AcmeRepository acmeRepository;
    @Autowired
    MongoTemplate mongoTemplate;


    @Override
    public Question saveQuestion(Question question) {
        return acmeRepository.save(question);
    }  // done

    @Override
    public Question getQuestionById(String id) {
        Optional<Question> questionOptionalObject =  acmeRepository.findById(id);
        System.out.println("called getQuestionById :"+id);
        return questionOptionalObject.orElse(null);
    } //done

    @Override
    public Question getQuestionByQuestionId(String questionId) {
        return acmeRepository.findByQuestionId(questionId);
    } // done
    @Override
    public Question updateQuestion(String qid, Question question) {
        Optional<Question> savedQuestion = acmeRepository.findById(qid);
        if(savedQuestion.isPresent()){
            Question existingQuestion = savedQuestion.get();
            existingQuestion.setQuestion(question.getQuestion());
            existingQuestion.setTags(question.getTags());
            existingQuestion.setOptions(question.getOptions());
            existingQuestion.setCorrectOpt(question.getCorrectOpt());
            // save the updated Question in the repository
            return acmeRepository.save(existingQuestion);
        }
        return null;
    }  // done

    @Override
    public void deleteQuestion(String qid) {
        acmeRepository.deleteById(qid);
    }  // done

    @Override
    public void deleteAllQuestions() {
        acmeRepository.deleteAll();
    }  // done

    @Override
    public QuestionDTO convertQuestionToDTO(Question question) {
        QuestionDTO questionDTO = new QuestionDTO();
        questionDTO.setId(question.getId());
        questionDTO.setQuestionId(questionDTO.getQuestionId());
        questionDTO.setTags(question.getTags());
        questionDTO.setQuestion(question.getQuestion());
        questionDTO.setDifficultyLevel(question.getDifficultyLevel());
        questionDTO.setOptions(question.getOptions());
        return questionDTO;
    }

    @Override
    public List<Question> getAllQuestions() {
        return acmeRepository.findAll();
    }  // done

    @Override
    public List<Question> searchQuestionsByTag(List<String> tags) {
        Query query = new Query();
        query.addCriteria(Criteria.where("tags").in(tags));
        return mongoTemplate.find(query, Question.class);
    }  //done using mongoTemplate query
    // show all Questions  [DONE]
    // Search questions by keywords
    // update / Edit questions  [DONE]
    // Delete Question by ID  [DONE]
    // search Question By ID [DONE]
    // search Question by level : Easy Medium Hard
    // search Question by Tags

}
