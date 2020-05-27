package ru.itis.semestrovaya.videosmotr.controllers;

import bell.oauth.discord.main.OAuthBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.semestrovaya.videosmotr.dto.RegisterForm;
import ru.itis.semestrovaya.videosmotr.models.User;
import ru.itis.semestrovaya.videosmotr.security.UserDetailsImpl;
import ru.itis.semestrovaya.videosmotr.services.RegisterService;
import ru.itis.semestrovaya.videosmotr.services.UserService;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@Controller
public class DiscordController {

    @Autowired
    OAuthBuilder builder;

    @Autowired
    UserService userService;

    @Autowired
    RegisterService registerService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @GetMapping("/discord/{type}")
    public ModelAndView getDiscordAuth(@RequestParam("code") String code, @PathVariable("type") String type) throws IOException {
        builder.setRedirectURI("http://localhost:8080/discord/" + type);
        builder.exchange(code);

        if (type.equals("register")) {
            builder.setRedirectURI("http://localhost:8080/discord/register");
            builder.exchange(code);
            bell.oauth.discord.domain.User user = builder.getUser();
            String password = UUID.randomUUID().toString();

            if (!userService.getUserByEmail(user.getEmail()).isPresent()) {
                RegisterForm registerForm = RegisterForm.builder()
                        .email(user.getEmail())
                        .password(passwordEncoder.encode(password))
                        .username(user.getUsername()).build();

                registerService.register(registerForm);
            }
        }

        Optional<User> user = userService.getUserByEmail(builder.getUser().getEmail());
        if (user.isPresent()) {
            UserDetailsImpl userDetails = new UserDetailsImpl(user.get());
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetails, user.get().getHash(), userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(token);
            return new ModelAndView("redirect:/chatik");
        }

        return new ModelAndView("redirect:/login");
    }
}
