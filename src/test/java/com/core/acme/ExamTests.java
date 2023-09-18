package com.core.acme;

import com.core.acme.domain.Exam;
import com.core.acme.domain.Student;
import com.core.acme.service.ExamService;
import com.core.acme.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.mongodb.assertions.Assertions.assertNotNull;
@SpringBootTest
public class ExamTests {

    @Autowired
    private ExamService examService;

    @Test
    void contextLoads() {
    }

    @Test
    void startExam(){
        examService.startNewExam(Exam.builder().testId("6503f1aae717076b746be45e").score(0).studentId("6503f1abe717076b746be465").currentQuestionIndex(0).currentSubQuestionIndex(0).build() );

        //assertNotNull(newExam);
    }
}
