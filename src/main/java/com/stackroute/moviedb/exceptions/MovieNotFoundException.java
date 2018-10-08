package com.stackroute.moviedb.exceptions;

public class MovieNotFoundException extends Exception {
    private String message;

    public MovieNotFoundException() {
    }

    public MovieNotFoundException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
