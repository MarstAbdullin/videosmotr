package ru.itis.semestrovaya.videosmotr.services;

import ru.itis.semestrovaya.videosmotr.models.Video;

import java.util.List;

public interface VideoService {
    List<Video> getAllVideos();
    List<Video> getUserAllVideos(String email);
    Video getCurrentVideo(Long id);
}
