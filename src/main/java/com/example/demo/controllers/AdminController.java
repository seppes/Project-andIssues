package com.example.demo.controllers;

import com.example.demo.model.Game;
import com.example.demo.model.Knuffel;
import com.example.demo.model.Video;
import com.example.demo.repositories.GameRepository;
import com.example.demo.repositories.KnuffelRepository;
import com.example.demo.repositories.VideoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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


    @GetMapping({"/new-Game"})
    public String newGame(Model model) {
        model.addAttribute("game", gameRepository.findAll());
        model.addAttribute("knuffel", knuffelRepository.findAll());
        return "admins/new-Game";
    }


    @GetMapping({"/new-Knuffel"})
    public String newKnuffel(Model model) {
        model.addAttribute("knuffel", knuffelRepository.findAll());
        return "admins/new-Knuffel";
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


    @PostMapping({"/new-Video"})
    public String newVideoPost(@RequestParam String videoTitle,
                               @RequestParam String videoUrl,
                               @RequestParam Knuffel knuffelID,
                               Model model) {
        logger.info(String.format("newVideoPost TITEL=%s, VIDEO_FILE_NAME=%s, KNUFFEL_ID=%s\n", videoTitle, videoUrl, knuffelID));
        Video video = new Video();
        video.setTitel(videoTitle);
        video.setVideoFileName(videoUrl);
        video.setKnuffel(knuffelID);

        videoRepository.save(video);
        return "redirect:/admins/new-Video";

    }


    @PostMapping({"/new-Game"})
    public String newGamePost(@RequestParam String gamePicture,
                              @RequestParam String gameTitle,
                              Model model) {
        logger.info(String.format("newGamePost PICTURE_GAME=%s, TITEL_GAME=%s\n", gamePicture, gameTitle));
        Game game = new Game();
        game.setPictureGame(gamePicture);
        game.setTitelGame(gameTitle);

        gameRepository.save(game);
        return "redirect:/admins/new-Game";

    }
}









