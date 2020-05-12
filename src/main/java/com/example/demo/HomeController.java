package com.example.demo;

import com.example.demo.model.Knuffel;
import com.example.demo.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class HomeController {


    @Autowired
   private VideoRepository videoRepository;


    private Knuffel[] knuffels = {
            new Knuffel(0, "De Egel", "€10"),
            new Knuffel(1, "De Kangoeroe", "€10"),
            new Knuffel(2, "De Mol", "€10"),
    };


    @GetMapping("VideoMol")
    public String VideoPaginaMol(Model model){

    Optional<Video> videos = videoRepository.findById(0);
    model.addAttribute("video", videos);
    return "htmlVideoGames/VideoPage";

    }

    @GetMapping("VideoKangerou")
    public String VideoPaginaKangerou(Model model){

        Optional<Video> videos = videoRepository.findById(1);
        model.addAttribute("video", videos);
        return "htmlVideoGames/VideoPage";

    }

    @GetMapping("VideoMol")
    public String VideoPaginaEgel(Model model){

        Optional<Video> videos = videoRepository.findById(2);
        model.addAttribute("video", videos);
        return "htmlVideoGames/VideoPage";

    }



//    @GetMapping("/Video/{videoId}")
//    public String VideoPaginaEgel(@PathVariable int videoId, Model model) {
//        Optional<Video> optionalVideoFromDb = videoRepository.findById(videoId);
//        addVideoInModel(videoId, model, optionalVideoFromDb);
//        return "htmlVideoGames/VideoPage";
//    }
//
//    private void addVideoInModel(@PathVariable int videoId, Model model, Optional<Video> optionalVideoFromDb) {
//        if (optionalVideoFromDb.isPresent()) {
//            long nrOfVideo = videoRepository.count();
//            model.addAttribute("Video", optionalVideoFromDb.get());
//        } else {
//            model.addAttribute("Video", null);
//        }
//    }






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
