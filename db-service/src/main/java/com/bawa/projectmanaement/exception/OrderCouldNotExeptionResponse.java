package com.bawa.projectmanaement.exception;

public class OrderCouldNotExeptionResponse {
    private String message;

    public OrderCouldNotExeptionResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
