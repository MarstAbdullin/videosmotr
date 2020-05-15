package ru.itis.semestrovaya.videosmotr.repositories;

import ru.itis.semestrovaya.videosmotr.models.Message;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message, Long> {
    List<Message> findAll();
}
