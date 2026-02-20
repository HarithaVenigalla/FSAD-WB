package com.klu.courseapi.repository;
 

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klu.courseapi.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    // Custom search method
    List<Course> findByTitleContainingIgnoreCase(String title);
}