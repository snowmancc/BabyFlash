package com.snow.server5.model;

import com.snow.server5.model.ModelCarrier;

public class MessageModel implements ModelCarrier {

    private String message;


    public MessageModel() {
    }

    public MessageModel(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
