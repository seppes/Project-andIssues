package com.example.demo.controllers;

import com.example.demo.model.Game;
import com.example.demo.model.Knuffel;
import com.example.demo.model.User;
import com.example.demo.model.Video;
import com.example.demo.repositories.GameRepository;
import com.example.demo.repositories.KnuffelRepository;
import com.example.demo.repositories.UserRepository;
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
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
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

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/Orders")
    public String appHome(Principal principal, Model model) {
        Optional<User> optionalUserFromDb = userRepository.findByUsername(principal.getName());
        if (optionalUserFromDb.isEmpty()) {
            model.addAttribute("user", "Geen bestellingen");
        } else {
            User user = optionalUserFromDb.get();
            model.addAttribute("user", user);
        }
        return "admins/AdminOrders";
    }

    @GetMapping({"/new-Video"})
    public String newVideo(Model model) {
        model.addAttribute("video", videoRepository.findAll());
        model.addAttribute("knuffel", knuffelRepository.findAll());
        return "admins/new-Video";
    }

    @GetMapping({"/new-knuffel"})
    public String newKnuffel(Model model) {
        model.addAttribute("knuffel", knuffelRepository.findAll());
        return "admins/new-knuffel";
    }

    @GetMapping({"/new-Game"})
    public String newGame(Model model) {
        model.addAttribute("game", gameRepository.findAll());
        model.addAttribute("knuffel", knuffelRepository.findAll());
        return "admins/new-Game";
    }

    @GetMapping({"/edit-knuffel", "/edit-knuffel/{id}"})
    public String editKnuffel(@PathVariable(required = false) int id, Model model) {
        Optional<Knuffel> optionalKnuffelFromDb = knuffelRepository.findById(id);
        Knuffel knuffel = (optionalKnuffelFromDb.isPresent()) ? optionalKnuffelFromDb.get() : null;
        model.addAttribute("knuffel", knuffel);
        model.addAttribute("knuffel", knuffelRepository.findAll());
        model.addAttribute("appName", applicationName);
        return "admins/edit-knuffel";
    }

    @GetMapping({"/edit-Video", "/edit-Video/{id}"})
    public String editVideo(@PathVariable(required = false) int id, Model model) {
        Optional<Video> optionalVideoFromDb = videoRepository.findById(id);
        Video video = (optionalVideoFromDb.isPresent()) ? optionalVideoFromDb.get() : null;
        model.addAttribute("video", video);
        model.addAttribute("video", videoRepository.findAll());

        return "admins/edit-Video";
    }





    @GetMapping({"/overzicht-knuffels"})
    public String overzichtKnuffels(Model model) {
        Iterable<Knuffel> knuffelsFromDb = knuffelRepository.findAll();
        model.addAttribute("knuffels", knuffelsFromDb);
        model.addAttribute("appName", applicationName);
        return "admins/overzicht-knuffels";
    }

    @GetMapping({"/overviewVideo"})
    public String overviewVideos(Model model) {
        Iterable<Video> videosFromDb = videoRepository.findAll();
        model.addAttribute("videos", videosFromDb);
        return "admins/overviewVideo";
    }



    @GetMapping("/")
    public String index(Model model) {
        Iterable<Knuffel> knuffelsFromDb = knuffelRepository.findAll();
        model.addAttribute("knuffels", knuffelsFromDb);
        model.addAttribute("appName", applicationName);
        return "htmlWebshop/index";
    }




    @PostMapping({"/new-knuffel"})
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
        return "redirect:/admins/new-knuffel";
    }


    @PostMapping({"/edit-knuffel", "/edit-knuffel/{knuffelId}"})
    public String editKnuffelPost(@PathVariable(required = false) int knuffelId,
                                  @RequestParam String NameKnuffel,
                                  @RequestParam String PriceKnuffel,
                                  @RequestParam String PicKnuffel,
                                  @RequestParam String KnuffelDescription,
                                  Model model) {
        logger.info(String.format("editKnuffelPost %d -- ANIMAL_NAME=%s, ANIMAL_PRICE=%s, ANIMAL_PIC=%s, ANIMAL_DESCRIPTION=%s\n", knuffelId, NameKnuffel, PriceKnuffel, PicKnuffel, KnuffelDescription));

        Optional<Knuffel> knuffelFromDb = knuffelRepository.findById(knuffelId);

        if (knuffelFromDb.isPresent()) {
            Knuffel knuffel = knuffelFromDb.get();
            knuffel.setAnimalName(NameKnuffel);
            knuffel.setAnimalPrice(PriceKnuffel);
            knuffel.setAnimalPic(PicKnuffel);
            knuffel.setAnimalDescription(KnuffelDescription);
            knuffelRepository.save(knuffel);
        }
        return "redirect:/admins/edit-knuffel/" + knuffelId;
    }


    @PostMapping({"/edit-Video", "/edit-Video/{videoId}"})
    public String editVideoPost(@PathVariable(required = false) int videoId,
                                @RequestParam String videoTitleEdit,
                                @RequestParam String videoUrlEdit,
                                @RequestParam Knuffel knuffelIDEdit,
                                Model model) {
        logger.info(String.format("editVideoPost %d -- TITEL=%s, VIDEO_FILE_NAME=%s, KNUFFEL_ID=%s\n", videoId, videoTitleEdit, videoUrlEdit, knuffelIDEdit));
        Optional<Video> videoFromDb = videoRepository.findById(videoId);

        if (videoFromDb.isPresent()) {
            Video video = videoFromDb.get();
            video.setTitel(videoTitleEdit);
            video.setVideoFileName(videoUrlEdit);
            video.setKnuffel(knuffelIDEdit);

            videoRepository.save(video);
        }
        return "redirect:/admins/edit-Video/" + videoId;
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
                              @RequestParam Knuffel knuffelIDgame,
                              Model model) {
        logger.info(String.format("newGamePost PICTURE_GAME=%s, TITEL_GAME=%s, KNUFFEL_ID=%s\n", gamePicture, gameTitle, knuffelIDgame));
        Game game = new Game();
        game.setPictureGame(gamePicture);
        game.setTitelGame(gameTitle);
        game.setKnuffel(knuffelIDgame);

        gameRepository.save(game);
        return "redirect:/admins/new-Game";

    }


    @GetMapping("/addUser")
    public String addUser(Principal principal, Model model) {
        if (principal != null) return "redirect:/user/appHome";//na het registreren


        return "admins/AdminAddUser";
    }

    @PostMapping("/addUser")
    public String addUser(@RequestParam String userName,
                          @RequestParam String password,
                          @RequestParam Knuffel knuffel,
                          Principal principal, Model model) {
        if (principal == null && !userName.isBlank()) {
            Optional<User> userWithUserName = userRepository.findByUsername(userName);
            if (!userWithUserName.isPresent()) {
                User newUser = new User();
                newUser.setUsername(userName);
                newUser.setRole("USER");
                newUser.setPassword(password);
                newUser.setKnuffel(knuffel);
                userRepository.save(newUser);
            }
        }
        return "admins/AdminAddUser";
    }
}
