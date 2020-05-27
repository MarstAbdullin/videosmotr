package ru.itis.semestrovaya.videosmotr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.semestrovaya.videosmotr.dto.RegisterForm;
import ru.itis.semestrovaya.videosmotr.services.RegisterService;

import javax.validation.Valid;


@Controller
public class RegisterController {
    @Autowired
    private RegisterService service;

    @GetMapping("/register")
    public ModelAndView getSignUpPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("registerForm", new RegisterForm());
        modelAndView.setViewName("register");
        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView signUp(@Valid RegisterForm registerForm, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println(bindingResult.getAllErrors());
        if (bindingResult.hasErrors()) {
            modelAndView.addObject("error", bindingResult.getAllErrors());
            modelAndView.addObject("registerForm", new RegisterForm());
            modelAndView.setViewName("register");
        } else {
            service.register(registerForm);
            modelAndView.setViewName("redirect:/login");
        }
        return modelAndView;
    }
}
