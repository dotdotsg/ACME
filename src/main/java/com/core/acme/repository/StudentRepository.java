package com.core.acme.repository;

import com.core.acme.domain.student.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin(origins = "*")
public interface StudentRepository extends MongoRepository<Student, String> {
    Student findByStudentId(String studentId);
    void deleteByStudentId(String studentId);
}
