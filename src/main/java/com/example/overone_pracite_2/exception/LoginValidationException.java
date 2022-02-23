package com.example.overone_pracite_2.exception;

public class LoginValidationException extends RuntimeException{
    public LoginValidationException() {
    }

    public LoginValidationException(String message) {
        super(message);
    }

    public LoginValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginValidationException(Throwable cause) {
        super(cause);
    }

    public LoginValidationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
