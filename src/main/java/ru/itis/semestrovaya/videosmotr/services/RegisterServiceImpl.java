package ru.itis.semestrovaya.videosmotr.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;
import ru.itis.semestrovaya.videosmotr.dto.RegisterForm;
import ru.itis.semestrovaya.videosmotr.models.User;
import ru.itis.semestrovaya.videosmotr.models.UserInfo;
import ru.itis.semestrovaya.videosmotr.repositories.UserInfoRepository;


@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @RequestScope
    public void register(RegisterForm form) {
        User user = User.builder()
                .email(form.getEmail())
                .hash(passwordEncoder.encode(form.getPassword()))
                .role("USER")
                .build();

        UserInfo userInfo = UserInfo.builder()
                .user(user)
                .username(form.getUsername())
                .build();
        userInfoRepository.save(userInfo);
    }
}

