package ru.itis.semestrovaya.videosmotr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import ru.itis.semestrovaya.videosmotr.services.VideoService;

@Controller
public class VideoController {

    @Autowired
    VideoService videoService;

    @GetMapping("/videos")
    public String getAllVideos(Model model) {
        model.addAttribute("videos", videoService.getAllVideos());
        model.addAttribute("videosType", "All videos");
        return "videos";
    }

    @GetMapping("/videos/{videoId}")
    public String getCurrentVideo(@PathVariable("videoId") Long videoId, Model model) {
        model.addAttribute("video", videoService.getCurrentVideo(videoId));
        return "video";
    }
}
