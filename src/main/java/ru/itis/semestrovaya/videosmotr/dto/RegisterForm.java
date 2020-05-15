package ru.itis.semestrovaya.videosmotr.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class RegisterForm {
    @NotEmpty(message = "{errors.email.empty}")
    @Email(message = "{errors.email.email}")
    private String email;

    @NotEmpty(message = "{errors.empty.password}")
    private String password;

    @NotEmpty(message = "{errors.name.empty}")
    @Size(min = 1, max = 45,message = "{errors.name.max}")
    private String username;
}
