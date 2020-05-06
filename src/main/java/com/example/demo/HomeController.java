package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


    @Autowired
    private VideoRepository videoRepository;

    private Video[] videos = {

            new Video(0,"Waarom spuitje"),
            new Video(1,"Waarom wenen"),
            new Video(2,"Waarom spelen"),

    };


    @GetMapping("/")
    public String VideoPagina(Model model) {
        model.addAttribute("videos", videos);
        return "VideoPagina";
    }






//    @GetMapping("/VideoPagina")
//    public String VideoPagina(Model model){
//        model.addAttribute("videos", videoRepository.findAll());
//        return "VideoPagina";
//    }



}
