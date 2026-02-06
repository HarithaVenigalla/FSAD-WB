package com.klu.spring;

import org.springframework.stereotype.Component;

@Component
public class Certification {

    private int id;
    private String name;
    private String dateOfCompletion;

    public Certification() {
        this.id = 501;
        this.name = "Java Full Stack";
        this.dateOfCompletion = "Jan 2026";
    }

    public void display() {
        System.out.println("Certification ID   : " + id);
        System.out.println("Certification Name : " + name);
        System.out.println("Completed On       : " + dateOfCompletion);
    }
}
