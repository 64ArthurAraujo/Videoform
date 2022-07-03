package org.videoform.api.controller.insert;

import static org.videoform.api.configuration.Settings.REQUEST_PATH_INSERT;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.videoform.api.request.VideoJsonRequest;
import org.videoform.api.response.UserJsonResponse;

import java.util.Objects;

@RestController
@RequestMapping(path = REQUEST_PATH_INSERT)
public class VideoInsert {

    @RequestMapping(method = RequestMethod.POST, path = "/videos")
    public ResponseEntity<String> uploadVideo
    (
            @RequestBody VideoJsonRequest jsonRequest,
            @RequestParam("video") MultipartFile video
    )
    {
        if (video.getSize() <= 0) {
            return new ResponseEntity<>("The sent file is empty.", HttpStatus.BAD_REQUEST);
        }

        if (!Objects.equals(video.getContentType(), "video/mp4")) {
            return new ResponseEntity<>("Invalid file format", HttpStatus.BAD_REQUEST);
        }

        System.out.println(jsonRequest.title);

        return new ResponseEntity<>(video.getOriginalFilename(), HttpStatus.CREATED);
    }
}
