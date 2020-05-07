package com.example.demo;

import com.example.demo.model.Knuffel;
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
            new Knuffel(0, "De Egel", "€10"),
            new Knuffel(1, "De Kangoeroe", "€10"),
            new Knuffel(2, "De Mol", "€10"),
    };

    @GetMapping("/")
    public String VideoPaginaMol(Model model) {
        model.addAttribute("videos", videos);
        return "htmlVideoGames/VideoPaginaMol";
    }

    @GetMapping("/VideoEgel")
    public String VideoPaginaEgel(Model model) {
        model.addAttribute("videos", videos);
        return "htmlVideoGames/VideoPaginaEgel";
    }

    @GetMapping("/VideoKangerou")
    public String VideoPaginaKangerou(Model model) {
        model.addAttribute("videos", videos);
        return "htmlVideoGames/VideoPaginaKangerou";
    }

    @GetMapping("/webshop")
    public String index(Model model) {
        model.addAttribute("knuffels", knuffels);
        return "htmlWebshop/index";
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
