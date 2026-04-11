package com.klu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.model.Student;
import com.klu.repo.StudentRepo;

@Service
public class StudentService {

    @Autowired
    private StudentRepo repo;

    // CREATE
    public Student save(Student s) {
        return repo.save(s);
    }

    // READ ALL
    public List<Student> getAll() {
        return repo.findAll();
    }

    // READ BY ID
    public Student getById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
    }

    // UPDATE
    public Student update(Long id, Student s) {
        Student existing = getById(id);
        existing.setName(s.getName());
        existing.setEmail(s.getEmail());
        existing.setCourse(s.getCourse());
        return repo.save(existing);
    }

    // DELETE
    public void delete(Long id) {
        repo.deleteById(id);
    }
}