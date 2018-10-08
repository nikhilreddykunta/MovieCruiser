package com.stackroute.moviedb.exceptions;

public class MovieAlreadyExistsException extends Exception {

    private String message;

    public MovieAlreadyExistsException() {
    }

    public MovieAlreadyExistsException(String message) {
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
