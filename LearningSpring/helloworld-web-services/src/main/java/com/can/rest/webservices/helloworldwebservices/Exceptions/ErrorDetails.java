package com.can.rest.webservices.helloworldwebservices.Exceptions;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ErrorDetails {
    //Timestamp
    private LocalDateTime timeStamp;
    //message
    private String message;
    //details
    private String details;

    public ErrorDetails(LocalDateTime timeStamp, String message, String details) {
        this.timeStamp = timeStamp;
        this.message = message;
        this.details = details;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
