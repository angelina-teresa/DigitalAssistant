package com.example.digitalAssistant.exception;

import org.springframework.http.HttpStatus;

public class InvalidInputException  extends Exception {
    HttpStatus httpStatus;

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public InvalidInputException (String message, HttpStatus httpStatus)
    {
        super(message);
        this.httpStatus=httpStatus;
    }
}
