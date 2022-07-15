package org.videoform.api.response;

import org.videoform.database.entity.User;

public class UserPrivateJsonResponse {

    private Long id;
    private String username;

    public UserPrivateJsonResponse(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
