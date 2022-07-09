package org.videoform.api.request;
import org.videoform.api.json.JsonRequest;
import org.videoform.database.entity.User;
import org.videoform.logic.AuthToken;

public class LoginDTO {
    public String username;
    public String password;
}
