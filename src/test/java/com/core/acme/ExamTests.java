package com.core.acme;

import com.core.acme.service.ExamService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@AutoConfiguration
@SpringBootTest
public class ExamTests {

    @Autowired
    private ExamService examService;

    @Test
    void contextLoads() {
    }
    @Test
    void chechCreateExam(){
    }
    @Test
    void checkExamEnded(){

    }

    @Test
    void startExam(){
        //assertNotNull(newExam);
    }
}
