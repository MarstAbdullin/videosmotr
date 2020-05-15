package ru.itis.semestrovaya.videosmotr.repositories;

import ru.itis.semestrovaya.videosmotr.models.User;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findAll();
}
