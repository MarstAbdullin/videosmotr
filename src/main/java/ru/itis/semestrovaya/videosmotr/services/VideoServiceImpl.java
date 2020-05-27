package ru.itis.semestrovaya.videosmotr.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.semestrovaya.videosmotr.models.Video;
import ru.itis.semestrovaya.videosmotr.repositories.VideoRepositoryJpaImpl;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService{

    @Autowired
    VideoRepositoryJpaImpl videoRepository;

    @Override
    public List<Video> getAllVideos() {
        return videoRepository.getAllVideos().get();
    }

    @Override
    public List<Video> getUserAllVideos(String email) {
        return videoRepository.getUserAllVideos(email).get();
    }

    @Override
    public Video getCurrentVideo(Long id) {
        return videoRepository.findById(id).get();
    }
}
