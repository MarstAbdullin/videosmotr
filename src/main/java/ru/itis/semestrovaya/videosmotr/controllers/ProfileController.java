package ru.itis.semestrovaya.videosmotr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.semestrovaya.videosmotr.dto.ProfileForm;
import ru.itis.semestrovaya.videosmotr.security.UserDetailsImpl;
import ru.itis.semestrovaya.videosmotr.services.VideoService;

import javax.validation.Valid;

@Controller
public class ProfileController {

    @Autowired
    VideoService videoService;

    @GetMapping("/profile")
    public String getUserAllVideos(Authentication authentication, Model model) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        model.addAttribute("videos", videoService.getUserAllVideos(userDetails.getUser().getUserInfo().getUsername()));
        model.addAttribute("videosType", "Your liked videos");
        return "profile";
    }

}

