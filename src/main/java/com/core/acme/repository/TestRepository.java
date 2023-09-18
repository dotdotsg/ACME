package com.core.acme.repository;

import com.core.acme.domain.Test;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends MongoRepository<Test, String> {
    Test findByTestId(String testId);
    Test findByTestName(String testName);
}
