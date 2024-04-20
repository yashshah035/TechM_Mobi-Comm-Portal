package com.example.springapp.exception;

public class AddonNotFoundException extends Exception {
    
    public AddonNotFoundException(String message){
        super(message);
    }

    public AddonNotFoundException(Throwable cause){
        super(cause);
    }

    public AddonNotFoundException(String message, Throwable cause){
        super(message, cause);
    }

    public AddonNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}