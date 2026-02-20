package com.klu.courseapi.service; 

import java.util.List;

import com.klu.courseapi.model.Course;

public interface CourseService {

    Course addCourse(Course course);

    Course updateCourse(Long id, Course course);

    String deleteCourse(Long id);

    Course getCourseById(Long id);

    List<Course> getAllCourses();

    List<Course> searchByTitle(String title);
}