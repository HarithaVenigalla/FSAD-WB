package com.klu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.klu.model.Student;
import com.klu.service.StudentService;

import java.util.List;

@RestController
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping("/students")
    public ResponseEntity<Student> addStudent(@RequestBody Student s) {
        return ResponseEntity.ok(service.saveStudent(s));
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudents() {
        return ResponseEntity.ok(service.getAllStudents());
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<Student> update(@PathVariable int id, @RequestBody Student s) {
        return ResponseEntity.ok(service.updateStudent(id, s));
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        service.deleteStudent(id);
        return ResponseEntity.ok("Deleted");
    }
}