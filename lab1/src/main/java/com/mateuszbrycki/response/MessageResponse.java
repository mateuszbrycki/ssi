package com.mateuszbrycki.response;

/**
 * Created by Mateusz Brycki on 17.10.2016.
 */
public class MessageResponse {
    private String message;

    public MessageResponse() {
    }

    public MessageResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
