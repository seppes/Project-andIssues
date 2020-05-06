package com.example.demo;
import com.example.demo.model.Knuffel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class WebshopHomeController {
    private Knuffel[] knuffels = {
            new Knuffel(0, "De Egel", "€10"),
            new Knuffel(1, "De Kangoeroe", "€10"),
            new Knuffel(2, "De Mol", "€10"),
    };

    @GetMapping("/")
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
}
