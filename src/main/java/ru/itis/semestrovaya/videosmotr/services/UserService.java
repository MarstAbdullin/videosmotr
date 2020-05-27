package ru.itis.semestrovaya.videosmotr.services;

import ru.itis.semestrovaya.videosmotr.dto.UserDto;
import ru.itis.semestrovaya.videosmotr.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserDto> getAllUsers();

    void deleteUser(Long userId);

    Optional<UserDto> getUserDtoByEmail(String email);

    Optional<User> getUserByEmail(String email);
}
