package com.core.acme.service.impl;

import com.core.acme.domain.student.Student;
import com.core.acme.repository.StudentRepository;
import com.core.acme.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    MongoTemplate mongoTemplate;
    
    @Override
    public Student saveStudent(Student student) {
        student.setStudentId(student.getStudentName()+student.getRollNo());
        return studentRepository.save(student);
    }  // Done

    @Override
    public List<Student> retreiveStudent(String studentName) { // List
        Query query = new Query();
        query.addCriteria(Criteria.where("studentName").is(studentName));
        List<Student> students = mongoTemplate.find(query, Student.class);

        return students;
    }         // Done

    @Override
    public Student getStudentById(String id) {
        return studentRepository.findById(id).get();
    } // Done

    @Override
    public Student updateStudent(String id, Student student) {
        Optional<Student> studentOptionalObject = studentRepository.findById(id);
        if(studentOptionalObject.isPresent()){
            Student savedStudent = studentOptionalObject.get();
            savedStudent.setStudentName(student.getStudentName());
            savedStudent.setEmail(student.getEmail());
            savedStudent.setRollNo(student.getRollNo());
            //savedStudent.setAdministeredTest(student.getAdministeredTest()); //
            return studentRepository.save(savedStudent);
        }
        return null;
    }  // Done

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    } // Done

    @Override
    public void deleteAllStudents() {
        studentRepository.deleteAll();
    }  // Done

    @Override
    public void deleteByStudentId(String studentId) {
        studentRepository.deleteByStudentId(studentId);
    }  // Done
}
