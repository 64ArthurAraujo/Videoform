package org.videoform.database.entity.intermediary;

public class IntermediaryVideo {
    private String title;
    private String description;
    private String ownerToken;
    private Long likes;
    private Long dislikes;
    private Long vizualizations;
    private Long categoryId;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOwnerToken() {
        return ownerToken;
    }

    public void setOwnerToken(String ownerToken) {
        this.ownerToken = ownerToken;
    }

    public Long getLikes() {
        return likes;
    }

    public void setLikes(Long likes) {
        this.likes = likes;
    }

    public Long getDislikes() {
        return dislikes;
    }

    public void setDislikes(Long dislikes) {
        this.dislikes = dislikes;
    }

    public void setVizualizations(Long vizualizations) {
        this.vizualizations = vizualizations;
    }

    public Long getVizualizations() {
        return vizualizations;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
