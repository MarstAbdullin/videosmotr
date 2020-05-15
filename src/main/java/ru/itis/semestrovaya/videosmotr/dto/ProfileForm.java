package ru.itis.semestrovaya.videosmotr.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
public class ProfileForm {
    @NotEmpty(message = "{errors.email.empty}")
    @Email(message = "{errors.email.email}")
    private String email;

    @NotEmpty(message = "{errors.username.empty}")
    private String username;
}

