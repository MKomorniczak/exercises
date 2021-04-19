package com.example.exercises.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Home {
    List<String> strings = new ArrayList<>();

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @PostMapping("/contact")
    public String contact(@RequestParam String email) {
        System.out.println("email is: " + email);
        strings.add(email);
        return "redirect:/contact";
    }

    @GetMapping("/contactList")
    public String contactList(Model model) {
        model.addAttribute("strings", strings);
        return "contactList";
    }
}
