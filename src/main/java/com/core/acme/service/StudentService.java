/* (C)2025 */
package com.core.acme.service;

import com.core.acme.domain.student.Student;
import java.util.List;

public interface StudentService {

    Student saveStudent(Student student);

    List<Student> retreiveStudent(String studentName);

    Student getStudentById(String id);

    Student updateStudent(String id, Student student);

    List<Student> getAllStudents(); // get all students

    void deleteAllStudents();

    void deleteByStudentId(String id);
}
