package org.videoform.api.response;

public class ErrorJsonResponse {
    private String error;

    public ErrorJsonResponse(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
