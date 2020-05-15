package ru.itis.semestrovaya.videosmotr.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ChatikController {

    @GetMapping("/chatik")
    public String chatik() {
        return "chatik";
    }
}
