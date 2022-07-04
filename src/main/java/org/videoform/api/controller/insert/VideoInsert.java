package org.videoform.api.controller.insert;

import static org.videoform.api.configuration.Settings.REQUEST_PATH_INSERT;

import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

@RestController
@RequestMapping(path = REQUEST_PATH_INSERT)
public class VideoInsert {

    @RequestMapping(
            method = RequestMethod.POST,
            path = "/videos",
            consumes = {"multipart/form-data"}
    )
    public ResponseEntity<String> uploadVideo(
            @NotNull @RequestParam("title") String title,
            @NotNull @RequestParam("description") String description,
            @NotNull @RequestParam("ownerToken") String ownerToken,
            @NotNull @RequestParam("categoryId") String categoryId,
            @NotNull @RequestParam("video") MultipartFile video
    )
    {
        if (video.getSize() <= 0) {
            return new ResponseEntity<>("The sent file is empty.", HttpStatus.BAD_REQUEST);
        }

        if (!Objects.equals(video.getContentType(), "video/mp4")) {
            return new ResponseEntity<>("Invalid file format", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(video.getOriginalFilename(), HttpStatus.CREATED);
    }
}
