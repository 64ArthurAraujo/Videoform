package org.videoform.api.controller.insert;

import static org.videoform.api.configuration.Settings.REQUEST_PATH_INSERT;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(path = REQUEST_PATH_INSERT)
public class VideoInsert {

    @RequestMapping(method = RequestMethod.POST, path = "/videos")
    public String insertVideo(@RequestParam("video") MultipartFile video) {
        System.out.println(video);

        return video.getName();
    }
}
