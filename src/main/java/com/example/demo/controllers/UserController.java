package com.example.demo.controllers;


import com.example.demo.model.User;
import com.example.demo.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {
    private Logger logger = LoggerFactory.getLogger(AdminController.class);

    // Register form
    @RequestMapping("/register")
    public String register(Principal principal, Model model) {
        if (principal != null) return "redirect:/Deegel";
        return "WebAppLogIn/RegisterPagina";
    }

     //Login form
    @RequestMapping("/login")
    public String login(Principal principal, Model model) {
        if (principal != null) return "redirect:/Deegel";
        return "WebAppLogIn/InlogPagina";
    }

    // Logout form
    @RequestMapping("/logout")
    public String logout(Model model) {
        return "WebAppLogIn/LogoutPagina";
    }

}