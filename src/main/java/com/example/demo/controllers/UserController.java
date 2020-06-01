package com.example.demo.controllers;


import com.example.demo.model.Game;
import com.example.demo.model.Knuffel;
import com.example.demo.model.User;
import com.example.demo.model.Video;
import com.example.demo.repositories.GameRepository;
import com.example.demo.repositories.KnuffelRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.repositories.VideoRepository;
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
    private String applicationName = "Knùs";
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private VideoRepository videoRepository;

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private KnuffelRepository knuffelRepository;

    @GetMapping("/register")
    public String register(Principal principal, Model model) {
        if (principal != null) return "redirect:/user/payment";//na het registreren


        return "WebAppLogIn/RegisterPagina";
    }

    @PostMapping("/register")// Om gegevens van de klant op te slaan in de database
    public String registerPost(@RequestParam String userName,
                               @RequestParam String email,
                               @RequestParam String adress,
                               Principal principal, Model model) {
        User newUser = new User();
        newUser.setUsername(userName);
        newUser.setRole("USER");
        newUser.setEmail(email);
        newUser.setAdress(adress);
        userRepository.save(newUser);
        return "redirect:/user/payment";
    }


    @GetMapping({"/register/{knuffelId}"})// om de juiste knuffelid in de url te teke
    public String register(@PathVariable int knuffelId, Model model) {
        Optional<Knuffel> optionalKnuffelFromDb = knuffelRepository.findById(knuffelId);
        Knuffel knuffel = optionalKnuffelFromDb.get();
        User newUser = new User();
        newUser.setKnuffel(knuffel);
        userRepository.save(newUser);
        model.addAttribute("knuffel", knuffel);
        return "WebAppLogIn/RegisterPagina";
    }


    //Login form
    @RequestMapping("/login")
    public String login(Principal principal, Model model) {
        if (principal != null) return "redirect:/user/appHome";
        return "WebAppLogIn/InlogPagina";
    }

    // Logout form
    @RequestMapping("/logout")
    public String logout(Model model) {
        return "WebAppLogIn/LogoutPagina";
    }


    @GetMapping("/appHome")
    public String appHome(Principal principal, Model model) {
        Optional<User> optionalUserFromDb = userRepository.findByUsername(principal.getName());//Zoek de username op in de database
        Iterable<Knuffel> knuffelsFromDb = knuffelRepository.findAll();
        model.addAttribute("knuffels", knuffelsFromDb);
        model.addAttribute("appName", applicationName);
        if (optionalUserFromDb.isEmpty()) {//Als username niet in de database.
            model.addAttribute("user", new User[]{});
        } else {
            User user = optionalUserFromDb.get();//Als username in de database is dan pak die de user.
            model.addAttribute("user", user);//Zet de user die gepakt is in de model.

        }
        return "htmlHome/appHome";//Gaat naar de appHome.
    }

    @RequestMapping("/payment")
    public String payment(Model model) {
        return "WebAppLogIn/Payment";
    }

    @GetMapping({"/VideoPage/{knuffelId}"})
    public String VideoPagina(@PathVariable int knuffelId, Model model) {
        Optional<Knuffel> optionalKnuffelFromDb = knuffelRepository.findById(knuffelId);

        if (optionalKnuffelFromDb.isEmpty()) {
            model.addAttribute("video", new Video[]{});
        } else {
            Knuffel knuffel = optionalKnuffelFromDb.get();
            model.addAttribute("knuffel", knuffel);
            model.addAttribute("video", videoRepository.findVideosByKnuffel(knuffel));

        }
        return "htmlVideoGames/VideoPage";
    }

    @GetMapping({"/GamePage/{knuffelId}"})
    public String GamePagina(@PathVariable int knuffelId, Model model) {
        Optional<Knuffel> optionalKnuffelFromDb = knuffelRepository.findById(knuffelId);
        if (optionalKnuffelFromDb.isEmpty()) {
            model.addAttribute("game", new Game[]{});
        } else {
            Knuffel knuffel = optionalKnuffelFromDb.get();
            model.addAttribute("knuffel", knuffel);
            model.addAttribute("game", gameRepository.findGameByKnuffel(knuffel));

        }
        return "htmlVideoGames/GamePage";
    }

}