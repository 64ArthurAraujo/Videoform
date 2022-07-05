package org.videoform.api.service.interf;

import org.springframework.web.multipart.MultipartFile;
import org.videoform.database.entity.Video;

import java.io.IOException;

public interface IVideoService extends IService<Video, Video> {
    public Video insert(Video entity, MultipartFile videoFile, String authorToken);

    public Iterable<Video> getVideosByOwner(Long ownerId);
}
