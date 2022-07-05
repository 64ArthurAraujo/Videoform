package org.videoform.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.videoform.api.repository.UserRepository;
import org.videoform.api.repository.VideoRepository;
import org.videoform.api.service.interf.IVideoService;
import org.videoform.database.entity.User;
import org.videoform.database.entity.Video;
import org.videoform.logic.AuthToken;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

@Service
public class VideoService implements IVideoService {
    @Autowired
    private VideoRepository repository;

    @Autowired
    private UserRepository userRepository;

    public VideoService(VideoRepository repository) {
        this.repository = repository;
    }

    public Video getById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Video insert(Video entity) {
        // Saves only the information about the video, should not be used.
        return repository.save(entity);
    }

    @Override
    public Video insert(Video entity, MultipartFile videoFile, String authorToken) {
        String videoToken = new AuthToken(12).getValue();

        User videoUploader = userRepository.findByAuthToken(authorToken);

        saveToDisk(videoFile, videoToken);

        entity.setOwnerId(videoUploader.getId());
        entity.setVideoToken(videoToken);

        return repository.save(entity);
    }

    private void saveToDisk(MultipartFile videoFile, String videoToken) {
        String pathToSave = System.getProperty("user.dir") + "/static/videos/" + videoToken;
        File savedVideoFile = new File(pathToSave);

        try {
            savedVideoFile.createNewFile();
            videoFile.transferTo(savedVideoFile);

            System.out.println(savedVideoFile.getAbsolutePath());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Video> getVideosByOwner(Long ownerId) {
        return repository.findByOwnerId(ownerId);
    }
}
