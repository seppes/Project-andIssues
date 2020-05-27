package com.example.demo.controllers;

import com.example.demo.model.Knuffel;
import com.example.demo.repositories.GameRepository;
import com.example.demo.repositories.KnuffelRepository;
import com.example.demo.repositories.VideoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

@Controller
@RequestMapping("/admins")
public class AdminController {

    private Logger logger = LoggerFactory.getLogger(AdminController.class);

    private String applicationName = "Knùs";

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

    @GetMapping({"/new-Knuffel"})
    public String newKnuffel(Model model) {
        model.addAttribute("knuffel", knuffelRepository.findAll());
        return "admins/new-Knuffel";
    }

    @GetMapping({"/edit-Knuffel"})
    public String editKnuffel(Model model) {
        model.addAttribute("knuffel", knuffelRepository.findAll());
        return "admins/edit-Knuffel";
    }

    @PostMapping({"/new-Knuffel"})
    public String newKnuffelPost(@RequestParam String NameKnuffel,
                                 @RequestParam String PriceKnuffel,
                                 @RequestParam String PicKnuffel,
                                 @RequestParam String KnuffelDescription,
                                 Model model) {
        logger.info(String.format("newKnuffelPost ANIMAL_NAME=%s, ANIMAL_PRICE=%s, ANIMAL_PIC=%s, ANIMAL_DESCRIPTION=%s\n", NameKnuffel, PriceKnuffel, PicKnuffel, KnuffelDescription));


        Knuffel knuffel = new Knuffel();
        knuffel.setAnimalName(NameKnuffel);
        knuffel.setAnimalPrice(PriceKnuffel);
        knuffel.setAnimalPic(PicKnuffel);
        knuffel.setAnimalDescription(KnuffelDescription);


        knuffelRepository.save(knuffel);
        return "redirect:/admins/new-Knuffel";
    }



    @PostMapping({"/edit-knuffel", "/edit-knuffel/{id}"})
    public String editKnuffelPost(@PathVariable(required = false) int id,
                                  @RequestParam String NameKnuffel,
                                  @RequestParam String PriceKnuffel,
                                  @RequestParam String PicKnuffel,
                                  @RequestParam String KnuffelDescription,
                                Model model) {
        logger.info(String.format("editKnuffelPost %d -- ANIMAL_NAME=%s, ANIMAL_PRICE=%s, ANIMAL_PIC=%s, ANIMAL_DESCRIPTION=%s\n", id, NameKnuffel, PriceKnuffel, PicKnuffel, KnuffelDescription));

        Optional<Knuffel> knuffelFromDb = knuffelRepository.findById(id);

        if (knuffelFromDb.isPresent() && !NameKnuffel.isBlank()) {
            Knuffel knuffel = knuffelFromDb.get();
            knuffel.setAnimalName(NameKnuffel);
            knuffel.setAnimalPrice(PriceKnuffel);
            knuffel.setAnimalPic(PicKnuffel);
            knuffel.setAnimalDescription(KnuffelDescription);
            knuffelRepository.save(knuffel);
        }
        return "redirect:/admins/edit-Knuffel/"+id;
    }

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


