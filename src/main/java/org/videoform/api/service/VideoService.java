package org.videoform.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.videoform.api.repository.VideoRepository;
import org.videoform.api.service.interf.IVideoService;
import org.videoform.database.entity.Video;
import java.util.List;

@Service
public class VideoService implements IVideoService {
    @Autowired
    private VideoRepository repository;

    public VideoService(VideoRepository repository) {
        this.repository = repository;
    }

    public Video getById(Long id) {
        return repository.findById(id).get();
    }

    public Video insert(Video entity) {
        return repository.save(entity);
    }

    public List<Video> getVideosByOwner(Long ownerId) {
        return repository.findByOwnerId(ownerId);
    }
}
