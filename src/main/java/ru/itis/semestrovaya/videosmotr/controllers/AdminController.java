package ru.itis.semestrovaya.videosmotr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.itis.semestrovaya.videosmotr.services.storage.StorageFileNotFoundException;
import ru.itis.semestrovaya.videosmotr.services.storage.StorageService;

import java.io.IOException;
import java.util.stream.Collectors;

@Controller
public class AdminController {

    @Autowired
    private StorageService storageService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/adminka")
    public String listUploadedFiles() throws IOException {
        return "adminka";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/adminka")
    public String handleFileUpload(@RequestParam("video") MultipartFile video) {

        storageService.store(video);

        return "redirect:/adminka";
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }
}
