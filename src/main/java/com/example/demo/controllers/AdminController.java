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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @PostMapping({"/new-Knuffel"})
    public String newKnuffelPost(@RequestParam String NameKnuffel,
                                 @RequestParam String PriceKnuffel,
                                 @RequestParam String PicKnuffel,
                                 @RequestParam String KnuffelDescription,
                                 Model model) {
        logger.info(String.format("newKnuffelPost ANIMAL_NAME=%s, ANIMAL_PRICE=%s, ANIMAL_PIC=%s, ANIMAL_DESCRIPTION=%s\n", NameKnuffel, PriceKnuffel, PicKnuffel, KnuffelDescription));

//        Optional<Knuffel> knuffelFromDb = knuffelRepository.findKnuffelByName(knuffelName);

        Knuffel knuffel = new Knuffel();
        knuffel.setAnimalName(NameKnuffel);
        knuffel.setAnimalPrice(PriceKnuffel);
        knuffel.setAnimalPic(PicKnuffel);
        knuffel.setAnimalDescription(KnuffelDescription);


        knuffelRepository.save(knuffel);
        return "redirect:/admins/new-Knuffel";
    }



//    @PostMapping({"/edit-party/{partyId}"})
//    public String editPartyPost(@PathVariable(required = false) int partyId,
//                                @RequestParam String partyName,
//                                @RequestParam String partyDate,
//                                @RequestParam String partyVenue,
//                                @RequestParam String[] partyArtists,
//                                Model model) {
//        logger.info(String.format("editParty %d -- name=%s, date=%s, venue=%s, artists=%s\n", partyId, partyName, partyDate, partyVenue, Arrays.toString(partyArtists)));
//
//        Optional<Party> partyFromDb = partyRepository.findById(partyId);
//        if (partyFromDb.isPresent() && !partyName.isBlank()) {
//            Party party = partyFromDb.get();
//            party.setName(partyName);
//            party.setDateFromString(partyDate);
//            if (!party.getVenue().getVenueName().equals(partyVenue)) {
//                Optional<Venue> venueFromDb = venueRepository.findVenueByVenueName(partyVenue);
//                if (venueFromDb.isPresent()) {
//                    party.setVenue(venueFromDb.get());
//                }
//            }
//            ArrayList<Artist> artistList = new ArrayList<>();
//            for (String artistNameString : partyArtists) {
//                Optional<Artist> artistFromDb = artistRepository.findArtistByName(artistNameString);
//                if (artistFromDb.isPresent())
//                    artistList.add(artistFromDb.get());
//            }
//            party.setArtists(artistList);
//            partyRepository.save(party);
//        }
//        return "redirect:/party/" + partyId;
//    }

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


