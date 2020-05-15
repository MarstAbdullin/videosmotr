package ru.itis.semestrovaya.videosmotr;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.context.annotation.ApplicationScope;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class VideosmotrApplication {

    @ApplicationScope
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public static void main(String[] args) {
        SpringApplication.run(VideosmotrApplication.class, args);
    }

}
