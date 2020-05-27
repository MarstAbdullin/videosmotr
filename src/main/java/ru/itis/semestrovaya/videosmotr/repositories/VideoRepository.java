package ru.itis.semestrovaya.videosmotr.repositories;

import ru.itis.semestrovaya.videosmotr.models.Video;

import java.util.List;
import java.util.Optional;

public interface VideoRepository extends CrudRepository<Video, Long> {
    Optional<List<Video>> getAllVideos();
    Optional<List<Video>> getUserAllVideos(String username);
}
