package org.videoform.api.service.interf;

import org.videoform.database.entity.Video;

public interface IVideoService extends IService<Video, Video> {
    public Iterable<Video> getVideosByOwner(Long ownerId);
}
