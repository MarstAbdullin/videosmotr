package ru.itis.semestrovaya.videosmotr.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {

    @GetMapping("/")
    public String getRoot() {
        return "index";
    }
}
