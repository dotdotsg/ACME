package com.core.acme.controller;

import com.core.acme.domain.student.Student;
import com.core.acme.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "*")
@Slf4j
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/home")
    public String Home() {
        return "<h1>Hello Welcome to the Student registration section</h1>";
    }

    @PostMapping("/register")
    public ResponseEntity<Student> createStudent(@RequestBody Student student)
    {                   // instead of using request body we can use json parser, type conversions
        log.info("[STUDENT][CONTROLLER] Create Student : {} ", student);
        return ResponseEntity.ok().body(studentService.saveStudent(student));
    }

    @PostMapping("/add-student-from-form")
    public ResponseEntity<Student> addStudentFromForm(Student student)
    {
        log.info("[STUDENT][CONTROLLER] Add Student via form : {} ", student);
        return ResponseEntity.ok().body(studentService.saveStudent(student));
    }

    @GetMapping("/student-list")
    public List<Student> getAllStudents(){
        log.info("[STUDENT][CONTROLLER] Get All Students ");
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable String id){
        log.info("[STUDENT][CONTROLLER] Get Student By id : {} ", id);
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @GetMapping("/search-by-name")
    public ResponseEntity<List<Student>> findStudentByName(@RequestParam String studentName)
    {
        log.info("[STUDENT][CONTROLLER] Get Student By name : {} ", studentName);
        return ResponseEntity.ok(studentService.retreiveStudent(studentName));
    }

    @DeleteMapping("/delete-all-student")
    public void deleteAllStudent(){
        log.info("[STUDENT][CONTROLLER] Delete All Students ");
        studentService.deleteAllStudents();
    }

    @DeleteMapping("/delete-by-student-id")
    public void deleteStudentByStudentId(String studentId){
        log.info("[STUDENT][CONTROLLER] Delete Student By studentId : {} ", studentId);
        studentService.deleteByStudentId(studentId);
    }
}
