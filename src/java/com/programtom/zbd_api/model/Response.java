package com.programtom.zbd_api.model;

import lombok.Data;

@Data
public class Response<T> {
    private boolean success;
    private T data;
    private String message;
    private transient Exception exception;

    public Response(Exception e) {
        this.exception = e;
        success = false;
        message = e.getMessage();
    }
}
