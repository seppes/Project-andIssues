package com.example.demo.controllers;

import com.example.demo.repositories.GameRepository;
import com.example.demo.repositories.KnuffelRepository;
import com.example.demo.repositories.VideoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admins")
public class AdminController {

    private Logger logger = LoggerFactory.getLogger(AdminController.class);



    @Autowired
    private VideoRepository videoRepository;

    @Autowired
    private KnuffelRepository knuffelRepository;

    @Autowired
    private GameRepository gameRepository;

    @GetMapping({"/new-Video"})
    public String newVideo(Model model) {
        model.addAttribute("video", videoRepository.findAll());
        model.addAttribute("knuffel", knuffelRepository.findAll());
        return "admins/new-Video";
    }

//    @PostMapping({"/new-Video"})
//    public String newVideoPost(@RequestParam String videoTitle,
//                                  @RequestParam String videoUrl,
//                                  Model model) {
//        logger.info(String.format("newVideo videoTitle=%s, videoUrl=%s", videoTitle, videoUrl));
//
//
//        return "redirect:/htmlVideoGames/VideoPage";
//
//    }
}

