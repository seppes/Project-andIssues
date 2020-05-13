package com.example.demo;

import com.example.demo.model.Knuffel;
import com.example.demo.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


    @Autowired
   private VideoRepository videoRepository;


    private Knuffel[] knuffels = {
            new Knuffel(0, "De Egel", "€10"),
            new Knuffel(1, "De Kangoeroe", "€10"),
            new Knuffel(2, "De Mol", "€10"),
    };



//    @GetMapping({"/video/{knuffelId}"})
//    public String VideoPagina(@PathVariable int knuffelId, Model model) {
//        Optional<Knuffel> optionalKnuffelFromDb = videoRepository.findById(knuffelId);
//        if (optionalKnuffelFromDb.isEmpty()) {
//            model.addAttribute("videos", new Video[]{});
//        } else {
//            Knuffel knuffel = optionalKnuffelFromDb.get();
//            model.addAttribute("knuffel", knuffel);
//            model.addAttribute("videos", videoRepository.findVideosByKnuffel(knuffel));
//        }
//        return "htmlVideoGames/VideoPage";
//    }
//













//    @GetMapping("/appHome")
//    public String VideoPaginaMol(Model model) {
//        model.addAttribute("videos", videos);
//        return "htmlHome/Deegel";
//    }
//
//
//    @GetMapping("/GamePage")
//    public String VideoPaginaKangerou(Model model) {
//        model.addAttribute("videos", knuffels);
//        return "htmlVideoGames/GamePage";
//    }


    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("knuffels", knuffels);
        return "htmlWebshop/index";
    }

    @GetMapping("/shoppingcart")
    public String shoppingcart(Model model) {
        model.addAttribute("knuffels", knuffels);
        return "htmlWebshop/shoppingcart";
    }

    @GetMapping("/about")
    public String about(Model model) {

        return "htmlWebshop/about";
    }

    @GetMapping("/contact")
    public String contact(Model model) {

        return "htmlWebshop/contact";
    }



}
