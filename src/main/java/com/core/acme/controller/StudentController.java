package com.core.acme.controller;

import com.core.acme.domain.Student;
import com.core.acme.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping("/home")
    public String Home() {
        return "<h1>Hello Welcome to the Student registration section</h1>";
    }
    @PostMapping("/create_student")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student)
    {                   // instead of using request body we can use json parser, type conversions
        return ResponseEntity.ok().body(studentService.saveStudent(student));
    }
    @PostMapping("/add-student-from-form")
    public ResponseEntity<Student> add_from_form(Student student)
    {
        return ResponseEntity.ok().body(studentService.saveStudent(student));
    }
    @GetMapping("/student-list")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable String id){
        return ResponseEntity.ok().body(studentService.getStudentById(id));
    }
    @GetMapping("/search-by-name")
    public ResponseEntity<List<Student>> findStudentByName(@RequestParam String studentName)
    {
        return ResponseEntity.ok().body(studentService.retreiveStudent(studentName));
    }
}
