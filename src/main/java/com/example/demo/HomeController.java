package com.example.demo;

import com.example.demo.controllers.AdminController;
import com.example.demo.model.Knuffel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.demo.model.Video;
import com.example.demo.repositories.KnuffelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class HomeController {
    private Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
   private VideoRepository videoRepository;

    @Autowired
    private KnuffelRepository knuffelRepository;

    private Video[] videoss= {

            new Video(0,"Waarom spuitje"),
            new Video(1,"Waarom wenen"),
            new Video(2,"Waarom spelendd"),

    };




    @GetMapping({"/video/{knuffelId}"})
   public String VideoPagina(@PathVariable int knuffelId, Model model) {
       Optional<Knuffel> optionalKnuffelFromDb = knuffelRepository.findById(knuffelId);
     if (optionalKnuffelFromDb.isEmpty()) {
       model.addAttribute("videos", new Video[]{});
   } else {
       Knuffel knuffel = optionalKnuffelFromDb.get();
         model.addAttribute("knuffel", knuffel);
         model.addAttribute("videos", videoRepository.findVideosByKnuffel(knuffel));
     }
        model.addAttribute("knuffel", knuffels[knuffelId]);
        model.addAttribute("videos", videoRepository.findVideosByKnuffel(knuffels[knuffelId]));
      return "htmlVideoGames/VideoPage";
   }


  @GetMapping("/appHome")
  public String VideoPaginaMol(Model model) {
      model.addAttribute("videos", videoss);
      return "htmlHome/Deegel";
  }


   @GetMapping("/GamePage")
   public String VideoPaginaKangerou(Model model) {
       model.addAttribute("videos", knuffels);
       return "htmlVideoGames/GamePage";
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
