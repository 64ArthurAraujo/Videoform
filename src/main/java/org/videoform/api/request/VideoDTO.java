package org.videoform.api.request;

import org.videoform.api.json.JsonRequest;
import org.videoform.database.entity.Video;

public class VideoDTO implements JsonRequest<Video> {
    public String title;
    public String description;
    public String authorToken;
    public Long categoryId;

    public VideoDTO(String title, String description, String authorToken, Long categoryId) {
        this.title = title;
        this.description = description;
        this.authorToken = authorToken;
        this.categoryId = categoryId;
    }

    @Override
    public Video convertJsonToEntity() {
        Video video = new Video();

        video.setTitle(this.title);
        video.setDescription(this.description);
        video.setCategoryId(this.categoryId);

        video.setDislikes((long) 0);
        video.setLikes((long) 0);
        video.setVizualizations((long) 0);

        return video;
    }
}
