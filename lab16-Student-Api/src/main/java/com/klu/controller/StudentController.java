package com.klu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klu.model.Student;
import com.klu.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    // CREATE
    @PostMapping
    public Student addStudent(@RequestBody Student s) {
        return service.save(s);
    }

    // READ ALL
    @GetMapping
    public List<Student> getAllStudents() {
        return service.getAll();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Long id) {
        return service.getById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student s) {
        return service.update(id, s);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        service.delete(id);
        return "Student Deleted Successfully";
    }
}