package com.example.demo.controllers;

import com.example.demo.model.Knuffel;
import com.example.demo.model.Video;
import com.example.demo.repositories.KnuffelRepository;
import com.example.demo.repositories.VideoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class HomeController {
    private Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
   private VideoRepository videoRepository;

    @Autowired
    private KnuffelRepository knuffelRepository;



    @GetMapping({"/video/{knuffelId}"})
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


   









    @GetMapping("/appHome")
  public String apphome(Model model) {

      return "htmlHome/DeegelHome";
  }


    @GetMapping("/")
    public String index(Model model) {
        Iterable<Knuffel> knuffelsFromDb = knuffelRepository.findAll();
        model.addAttribute("knuffels", knuffelsFromDb);
        return "htmlWebshop/index";
    }


    @GetMapping("/shoppingcart")
    public String shoppingcart(Model model) {
        Iterable<Knuffel> knuffelsFromDb = knuffelRepository.findAll();
        model.addAttribute("knuffels", knuffelsFromDb);
        return "htmlWebshop/shoppingcart";
    }

    @GetMapping("/about")
    public String about() {
        return "htmlWebshop/about";
    }


    @GetMapping("/contact")
    public String contact() {
        return "htmlWebshop/contact";
    }





}
