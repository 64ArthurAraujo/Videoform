package org.videoform.database.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "video")
public class Video implements Serializable {

	private static final long serialVersionUID = -2106445072775367194L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "video_token")
	private String videoToken;

	@Column(name = "title")
	private String title;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "owner_id")
	private Long ownerId;
	
	@Column(name = "likes")
	private Long likes;
	
	@Column(name = "dislikes")
	private Long dislikes;
	
	@Column(name = "vizualizations")
	private Long vizualizations;
	
	@Column(name = "category_id")
	private Long categoryId;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
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

	public Long getVizualizations() {
		return vizualizations;
	}

	public void setVizualizations(Long vizualizations) {
		this.vizualizations = vizualizations;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getVideoToken() {
		return videoToken;
	}

	public void setVideoToken(String videoToken) {
		this.videoToken = videoToken;
	}
}
