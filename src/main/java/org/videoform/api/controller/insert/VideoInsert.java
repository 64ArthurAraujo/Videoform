package org.videoform.api.controller.insert;

import static org.videoform.api.configuration.Settings.REQUEST_PATH_INSERT;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.videoform.api.request.VideoDTO;
import org.videoform.api.service.interf.IVideoService;

import java.util.Objects;

@RestController
@RequestMapping(path = REQUEST_PATH_INSERT)
public class VideoInsert {

    @Autowired
    private IVideoService videoService;

    @RequestMapping(
            method = RequestMethod.POST,
            path = "/videos",
            consumes = {"multipart/form-data"}
    )
    public ResponseEntity<String> uploadVideo(
            @NotNull @RequestParam("title") String title,
            @NotNull @RequestParam("description") String description,
            @NotNull @RequestParam("userToken") String userToken,
            @NotNull @RequestParam("categoryId") Long categoryId,
            @NotNull @RequestParam("video") MultipartFile video
    )
    {
        if (video.getSize() <= 0) {
            return new ResponseEntity<>("The sent file is empty.", HttpStatus.BAD_REQUEST);
        }

        if (!Objects.equals(video.getContentType(), "video/mp4")) {
            return new ResponseEntity<>("Invalid file format", HttpStatus.BAD_REQUEST);
        }

        VideoDTO newVideo = new VideoDTO(title, description, userToken, categoryId);

        videoService.insert(newVideo.convertJsonToEntity(), video, userToken);

        return new ResponseEntity<>("Video created", HttpStatus.CREATED);
    }
}
