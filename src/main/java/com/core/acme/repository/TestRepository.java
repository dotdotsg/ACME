/* (C)2025 */
package com.core.acme.repository;

import com.core.acme.domain.test.Test;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin(origins = "*")
public interface TestRepository extends MongoRepository<Test, String> {
    Test findByTestId(String testId);

    Test findByTestName(String testName);

    void deleteByTestId(String testId);
}
