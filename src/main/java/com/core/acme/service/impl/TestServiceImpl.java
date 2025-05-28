package com.core.acme.service.impl;

import com.core.acme.domain.test.Test;
import com.core.acme.repository.TestRepository;
import com.core.acme.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestRepository testRepository;

    @Override
    public Test saveTest(Test test) {
        return testRepository.save(test);
    }

    @Override
    public List<Test> getAllTests()
    {
        return testRepository.findAll();
    }

    @Override
    public void deleteAllTests() {
        testRepository.deleteAll();
    }

    @Override
    public void deleteByTestId(String testId) {
        testRepository.deleteByTestId(testId);
    }

    @Override
    public Test getTestById(String id) {
        return testRepository.findById(id).get();
    }

    @Override
    public Test getTestByTestId(String testId) {
        return testRepository.findByTestId(testId);
    }

    @Override
    public Test getTestByName(String testName) {
        return testRepository.findByTestName(testName);
    }
}
