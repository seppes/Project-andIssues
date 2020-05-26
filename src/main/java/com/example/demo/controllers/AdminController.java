package com.example.demo.controllers;

import ch.qos.logback.classic.util.LogbackMDCAdapter;
import com.example.demo.model.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.Optional;

@Controller
@RequestMapping("/admins")
public class AdminController {
    @Autowired
    private UserRepository userRepository;


    @GetMapping("/Orders")
    public String appHome(Principal principal, Model model) {
        Optional<User> optionalUserFromDb = userRepository.findByUsername(principal.getName());
        if (optionalUserFromDb.isEmpty()) {
            model.addAttribute("user", "Geen bestellingen");
        } else {
            User user = optionalUserFromDb.get();
            model.addAttribute("user", user);

        }
        return "admins/AdminOrders";
    }

}