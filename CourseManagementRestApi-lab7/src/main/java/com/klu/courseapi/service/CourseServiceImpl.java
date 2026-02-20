package com.klu.courseapi.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.courseapi.model.Course;
import com.klu.courseapi.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    // Add Course
    @Override
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    // Update Course
    @Override
    public Course updateCourse(Long id, Course course) {
        Optional<Course> existing = courseRepository.findById(id);

        if (existing.isPresent()) {
            Course updatedCourse = existing.get();
            updatedCourse.setTitle(course.getTitle());
            updatedCourse.setDuration(course.getDuration());
            updatedCourse.setFee(course.getFee());
            return courseRepository.save(updatedCourse);
        }
        return null;
    }

    // Delete Course
    @Override
    public String deleteCourse(Long id) {
        if (courseRepository.existsById(id)) {
            courseRepository.deleteById(id);
            return "Course deleted successfully";
        }
        return "Course not found";
    }

    // Get Course By Id
    @Override
    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    // Get All Courses
    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    // Search by Title
    @Override
    public List<Course> searchByTitle(String title) {
        return courseRepository.findByTitleContainingIgnoreCase(title);
    }
}