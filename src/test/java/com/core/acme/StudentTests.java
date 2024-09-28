package com.core.acme;

import com.core.acme.domain.Student;
import com.core.acme.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.mongodb.assertions.Assertions.assertNotNull;

@SpringBootTest
public class StudentTests {
    @Autowired
    private StudentService studentService;

    @Test
    void contextLoads() {
    }

    @Test
    void findAllStudent(){
        List<Student> allStudents =  studentService.getAllStudents();
        // System.out.println("student List  :"+allStudents.size());
        // for(int i =0; i<allStudents.size();i++){
        //     System.out.println(allStudents.get(i).toString());
        // }
        assertNotNull(allStudents);
    }
    @Test
    void findStudentByName(){
        String studentName = "aaryan";
        List<Student> allStudentsWithName =  studentService.retreiveStudent(studentName);
        // System.out.println("student List  :"+allStudentsWithName.size());
        // for(int i =0; i<allStudentsWithName.size();i++){
        //     System.out.println(allStudentsWithName.get(i).toString());
        // }
        assertNotNull(allStudentsWithName);
    }
}
