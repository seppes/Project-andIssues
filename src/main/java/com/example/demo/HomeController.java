package com.example.demo;

import com.example.demo.model.Knuffel;
import com.example.demo.model.Video;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


//    @Autowired
//    private VideoRepository videoRepository;

    private Video[] videos= {

            new Video(0,"Waarom spuitje"),
            new Video(1,"Waarom wenen"),
            new Video(2,"Waarom spelendd"),

    };
    private Knuffel[] knuffels = {
            new Knuffel(0, "De Egel", "€10", "knuffel_egel.jpg", "de egel heeft naalden"),
            new Knuffel(1, "De Kangoeroe", "€10", "knuffel_egel.jpg", "de kangoeroe springt"),
            new Knuffel(2, "De Mol", "€10", "knuffel_egel.jpg", "de mol graaft"),
    };

    @GetMapping("/appHome")
    public String VideoPaginaMol(Model model) {
        model.addAttribute("videos", videos);
        return "htmlHome/DeegelHome";
    }

    @GetMapping("/VideoPage")
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

//    @GetMapping("/VideoPagina")
//    public String VideoPagina(Model model){
//        model.addAttribute("videos", videoRepository.findAll());
//        return "VideoPagina";
//    }

//    @GetMapping("/Game/Mol")
//        public String GamePagina(Model model){
//        model.addAttribute("games", games);
//        return "SpelDemol";
//    }


}
