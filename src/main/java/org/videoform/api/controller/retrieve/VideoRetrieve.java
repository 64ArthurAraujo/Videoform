package org.videoform.api.controller.retrieve;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.videoform.api.service.interf.IVideoService;
import org.videoform.database.entity.Video;

import javax.validation.constraints.NotNull;

import static org.videoform.api.configuration.Settings.REQUEST_PATH_RETRIEVE;

@RestController
@RequestMapping(path = REQUEST_PATH_RETRIEVE)
public class VideoRetrieve {
    @Autowired
    private IVideoService videoService;

    @RequestMapping(method = RequestMethod.GET, path = "/videos/{id}")
    public ResponseEntity<Video> getVideosByUser(@PathVariable("id") @NotNull Long id) {

        return new ResponseEntity<>(videoService.getById(id), HttpStatus.OK);
    }
}
