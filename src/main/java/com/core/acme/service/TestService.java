package com.core.acme.service;

import com.core.acme.domain.Test;

import java.util.List;

public interface TestService {
    Test saveTest(Test test);
    Test getTestById(String id);
    Test getTestByTestId(String testId);
    List<Test> getAllTests();
    void deleteAllTests();
    Test getTestByName(String testName);
}
