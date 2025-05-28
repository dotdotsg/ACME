/* (C)2025 */
package com.core.acme.repository;

import com.core.acme.domain.question.Question;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin(origins = "*")
public interface QuestionRepository extends MongoRepository<Question, String> {
    Question findByQuestionId(String questionId);
}
