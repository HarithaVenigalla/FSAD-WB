package com.klu.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @PostMapping("/add")
    public String add() {
        return "Admin added data";
    }

    @DeleteMapping("/delete")
    public String delete() {
        return "Admin deleted data";
    }
}