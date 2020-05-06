package com.example.demo;

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
    private Game[] games= {

            new Game(0, "Uno"),
            new Game(1, "Deltarune"),
            new Game(2, "Shrek 3")
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

//    @GetMapping ("/VideoPagina")
//    public String VideoPagina(Model model){
//        model.addAttribute("videos", videoRepository.findAll());
//        return "VideoPagina";
//    }

    @GetMapping("/Game/Mol")
    public String SpelDemol(Model model) {
        model.addAttribute("games", games);
        return "htmlVideoGames/SpelDemol";
    }

    @GetMapping("/Game/Egel")
    public String SpelDeegel(Model model) {
        model.addAttribute("games", games);
        return "htmlVideoGames/SpelDeegel";
    }

    @GetMapping("/Game/Kangoeroe")
    public String SpelDekangoeroe(Model model) {
        model.addAttribute("games", games);
        return "htmlVideoGames/SpelDekangerou";
    }
}
