package com.example.demo.controllers;


import com.example.demo.model.Knuffel;
import com.example.demo.model.User;
import com.example.demo.model.Video;
import com.example.demo.repositories.KnuffelRepository;
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
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {
    private Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private KnuffelRepository knuffelRepository;

    @GetMapping("/register")
    public String register(Principal principal, Model model) {
        if (principal != null) return "redirect:/user/appHome/0";//na het registreren


        return "WebAppLogIn/RegisterPagina";
    }

    @PostMapping("/register")
    public String registerPost(@RequestParam String userName,
                               @RequestParam String password,
                               @RequestParam String email,
                               Principal principal, Model model) {
        if (principal == null && !userName.isBlank()) {
            Optional<User> userWithUserName = userRepository.findByUsername(userName);
            if (!userWithUserName.isPresent()) {
                User newUser = new User();
                newUser.setUsername(userName);
                String encode = passwordEncoder.encode(password);
                logger.info(String.format("password %s\n", encode));
                newUser.setPassword(encode);
                newUser.setRole("USER");
                newUser.setEmail(email);
                userRepository.save(newUser);
                autologin(userName, password);
            }
        }
        return "redirect:/user/appHome/0";
    }

    private void autologin(String userName, String password) {
        UsernamePasswordAuthenticationToken token
                = new UsernamePasswordAuthenticationToken(userName, password);

        try {
            Authentication auth = authenticationManager.authenticate(token);
            logger.info("authentication done - result is " + auth.isAuthenticated());
            SecurityContext sc = SecurityContextHolder.getContext();
            sc.setAuthentication(auth);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
    }


    //Login form
    @RequestMapping("/login")
    public String login(Principal principal, Model model) {
        if (principal != null) return "redirect:/user/appHome/0";
        return "WebAppLogIn/InlogPagina";
    }

    // Logout form
    @RequestMapping("/logout")
    public String logout(Model model) {
        return "WebAppLogIn/LogoutPagina";
    }

    @RequestMapping("/register")
    public String register(Model model) {
        return "WebAppLogIn/RegisterPagina";
    }


//
//    @GetMapping("/appHome")
//    public String appHome(Model model) {
//        return "htmlHome/appHome";
//    }

    @GetMapping({"/appHome/{knuffelId}"})
    public String appHome(@PathVariable int knuffelId, Model model) {
        Optional<Knuffel> optionalKnuffelFromDb = knuffelRepository.findById(knuffelId);
        if (optionalKnuffelFromDb.isEmpty()) {
            model.addAttribute("user", new User[]{});
        } else {
            Knuffel knuffel = optionalKnuffelFromDb.get();
            model.addAttribute("knuffel", knuffel);
            model.addAttribute("user", userRepository.findUsersByKnuffel(knuffel));

        }
        return "htmlHome/appHome";
    }

}