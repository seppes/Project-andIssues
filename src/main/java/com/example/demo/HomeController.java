package com.example.demo;

import com.example.demo.controllers.AdminController;
import com.example.demo.model.Knuffel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class HomeController {
    private Logger logger = LoggerFactory.getLogger(AdminController.class);

//    @Autowired
//    private VideoRepository videoRepository;

    private Video[] videos= {

            new Video(0,"Waarom spuitje"),
            new Video(1,"Waarom wenen"),
            new Video(2,"Waarom spelendd"),

    };
    private Knuffel[] knuffels = {
            new Knuffel(0, "De Egel", "€10"),
            new Knuffel(1, "De Kangoeroe", "€10"),
            new Knuffel(2, "De Mol", "€10"),
    };

    @GetMapping("/appHome")
    public String VideoPaginaMol(Model model) {
        model.addAttribute("videos", videos);
        return "htmlHome/Deegel";
    }

    @GetMapping("/VideoEgel")
    public String VideoPaginaEgel(Model model) {
        model.addAttribute("videos", videos);
        return "htmlVideoGames/VideoPage";
    }

    @GetMapping("/GamePage")
    public String VideoPaginaKangerou(Model model) {
        model.addAttribute("videos", videos);
        return "htmlVideoGames/GamePage";
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("knuffels", knuffels);
        return "htmlWebshop/index";
    }

    @GetMapping({"/login", "/Deegel"})
    public String login(Principal principal, Model model) {
        String loggedInName = principal!=null ? principal.getName() : "nobody";
        logger.info("logged in: " + loggedInName);
        return "htmlHome/Deegel";
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


//    @GetMapping ("/VideoPagina")
//    public String VideoPagina(Model model){
//        model.addAttribute("videos", videoRepository.findAll());
//        return "VideoPagina";
//    }



}
