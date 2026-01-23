package com.klu.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class StudentAppAnnotation {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);

        Student student = context.getBean(Student.class);
        student.display();
    }
}
