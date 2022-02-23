package com.example.overone_pracite_2.exception;

public class RegistrationValidationException extends RuntimeException{
    public RegistrationValidationException() {
    }

    public RegistrationValidationException(String message) {
        super(message);
    }

    public RegistrationValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public RegistrationValidationException(Throwable cause) {
        super(cause);
    }

    public RegistrationValidationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
