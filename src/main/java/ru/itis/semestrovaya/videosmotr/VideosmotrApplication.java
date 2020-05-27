package ru.itis.semestrovaya.videosmotr;


import bell.oauth.discord.main.OAuthBuilder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.context.annotation.ApplicationScope;
import ru.itis.semestrovaya.videosmotr.services.storage.StorageProperties;
import ru.itis.semestrovaya.videosmotr.services.storage.StorageService;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableConfigurationProperties(StorageProperties.class)
public class VideosmotrApplication {

    @Bean
    public OAuthBuilder oAuthBuilder() {
        OAuthBuilder builder = new OAuthBuilder("714485164281167895", "nZ1qHBR3f_4y92BT4mQjarQmxFsQ3g3_")
                .setScopes(new String[]{"connections", "guilds", "email"})
                .setRedirectURI("https://discord.com/api/oauth2/authorize?client_id=714485164281167895&redirect_uri=http%3A%2F%2Flocalhost%3A8080%2Fdiscord&response_type=code&scope=identify%20email%20connections%20guilds");
        return builder;
    }

    @Bean
    CommandLineRunner init(StorageService storageService) {
        return (args) -> {
            storageService.deleteAll();
            storageService.init();
        };
    }

    @ApplicationScope
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public static void main(String[] args) {
        SpringApplication.run(VideosmotrApplication.class, args);
    }

}
