package com.example.demo.controllers;

import ch.qos.logback.classic.util.LogbackMDCAdapter;
import com.example.demo.model.Knuffel;
import com.example.demo.model.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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


    @GetMapping("/addUser")
    public String addUser(Principal principal, Model model) {
        if (principal != null) return "redirect:/user/appHome";//na het registreren


        return "admins/AdminAddUser";
    }

    @PostMapping("/addUser")
    public String addUser(@RequestParam String userName,
                          @RequestParam String password,
                          @RequestParam Knuffel knuffel,
                          Principal principal, Model model) {
        if (principal == null && !userName.isBlank()) {
            Optional<User> userWithUserName = userRepository.findByUsername(userName);
            if (!userWithUserName.isPresent()) {
                User newUser = new User();
                newUser.setUsername(userName);
                newUser.setRole("USER");
                newUser.setPassword(password);
                newUser.setKnuffel(knuffel);
                userRepository.save(newUser);
            }
        }
        return "admins/AdminAddUser";
    }

}