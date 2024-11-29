package com.jbk.dto;

import java.sql.Timestamp;

public class ExceptionResponse {
    private String message;
    private String path;
    private Timestamp timestamp;

    public ExceptionResponse (Timestamp timestamp, String path, String message) {
        this.timestamp = timestamp;
        this.path = path;
        this.message = message;
    }

    public ExceptionResponse () {
    }

    public String getMessage () {
        return message;
    }

    public void setMessage (String message) {
        this.message = message;
    }

    public String getPath () {
        return path;
    }

    public void setPath (String path) {
        this.path = path;
    }

    public Timestamp getTimestamp () {
        return timestamp;
    }

    public void setTimestamp (Timestamp timestamp) {
        this.timestamp = timestamp;
    }


}
