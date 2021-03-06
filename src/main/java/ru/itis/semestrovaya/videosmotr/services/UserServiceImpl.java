package ru.itis.semestrovaya.videosmotr.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ru.itis.semestrovaya.videosmotr.dto.UserDto;
import ru.itis.semestrovaya.videosmotr.models.User;
import ru.itis.semestrovaya.videosmotr.repositories.UserRepository;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDto> getAllUsers() {
        return UserDto.from(userRepository.findAll());
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.delete(userId);
    }

    @Override
    public Optional<UserDto> getUserDtoByEmail(String email) {
        User user = userRepository.findByName(email).get();
        UserDto userDto = UserDto.builder().email(user.getEmail()).id(user.getId()).build();
        return Optional.ofNullable(userDto);
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByName(email);
    }
}
