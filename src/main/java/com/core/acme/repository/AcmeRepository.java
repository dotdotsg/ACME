package com.core.acme.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.core.acme.domain.Question;

@Repository
public interface AcmeRepository extends MongoRepository<Question, String>{
    Question findByQuestionId(String questionId);
}
