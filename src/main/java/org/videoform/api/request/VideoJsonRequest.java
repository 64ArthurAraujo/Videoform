package org.videoform.api.request;

import org.videoform.api.json.JsonRequest;
import org.videoform.database.entity.Video;
import org.videoform.database.entity.intermediary.IntermediaryVideo;

public class VideoJsonRequest implements JsonRequest<IntermediaryVideo> {

    public String title;
    public String description;
    public String ownerToken;
    public Long categoryId;

    @Override
    public IntermediaryVideo convertJsonToEntity() {
        IntermediaryVideo videoEntity = new IntermediaryVideo();

        videoEntity.setTitle(title);
        videoEntity.setDescription(description);
        videoEntity.setOwnerToken(ownerToken);
        videoEntity.setCategoryId(categoryId);

        return videoEntity;
    }
}
