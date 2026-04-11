package com.klu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.model.Student;
import com.klu.repo.StudentRepo;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepo repo;

    // GET all
    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    // POST
    public Student saveStudent(Student s) {
        return repo.save(s);
    }

    // PUT
    public Student updateStudent(int id, Student s) {
        s.setId(id);
        return repo.save(s);
    }

    // DELETE
    public void deleteStudent(int id) {
        repo.deleteById(id);
    }
}