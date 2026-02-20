package com.klu.courseapi.controller; 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.klu.courseapi.model.Course;
import com.klu.courseapi.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    // ✅ Add Course
    @PostMapping
    public ResponseEntity<?> addCourse(@RequestBody Course course) {
        if (course.getCourseId() == null || course.getTitle() == null) {
            return new ResponseEntity<>("Invalid course data", HttpStatus.BAD_REQUEST);
        }

        Course saved = courseService.addCourse(course);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // ✅ Get All Courses
    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> courses = courseService.getAllCourses();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    // ✅ Get Course By ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getCourseById(@PathVariable Long id) {
        Course course = courseService.getCourseById(id);

        if (course == null) {
            return new ResponseEntity<>("Course not found", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    // ✅ Update Course
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable Long id, @RequestBody Course course) {
        Course updated = courseService.updateCourse(id, course);

        if (updated == null) {
            return new ResponseEntity<>("Course not found", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    // ✅ Delete Course
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable Long id) {
        String message = courseService.deleteCourse(id);

        if (message.equals("Course not found")) {
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    // ✅ Search by Title
    @GetMapping("/search/{title}")
    public ResponseEntity<List<Course>> searchByTitle(@PathVariable String title) {
        List<Course> courses = courseService.searchByTitle(title);

        if (courses.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(courses, HttpStatus.OK);
    }
}