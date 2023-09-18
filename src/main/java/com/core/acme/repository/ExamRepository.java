package com.core.acme.repository;
import com.core.acme.domain.Exam;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExamRepository extends MongoRepository<Exam, String> {
    Exam findByExamId(String examId);

    void deleteByExamId(String examId);
}
