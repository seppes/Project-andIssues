package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admins")
public class AdminController {

    @RequestMapping("/Orders")
    public String admin(Model model) {
        return "admins/AdminOrders";
    }

}