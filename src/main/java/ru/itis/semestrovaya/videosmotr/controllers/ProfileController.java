package ru.itis.semestrovaya.videosmotr.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.semestrovaya.videosmotr.dto.ProfileForm;
import ru.itis.semestrovaya.videosmotr.security.UserDetailsImpl;

import javax.validation.Valid;

@Controller
public class ProfileController {
    @GetMapping("/profile")
    public String getProfilePage(Authentication authentication, Model model) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        System.out.println(userDetails.getUser().getUserInfo().getUsername());
        model.addAttribute("profileForm", new ProfileForm());
        return "profile";
    }

    @PostMapping("/profile")
    public String updateProfile(Authentication authentication, @Valid ProfileForm form, BindingResult bindingResult, Model model) {
        System.out.println(form);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        model.addAttribute("user", userDetails.getUser());
        System.out.println(bindingResult.getAllErrors());
        model.addAttribute("profileForm", form);
        return "profile";
    }

}
