package com.example.springapp.exception;

public class PlanNotFoundException extends Exception {
    
    public PlanNotFoundException(String message){
        super(message);
    }

    public PlanNotFoundException(Throwable cause){
        super(cause);
    }

    public PlanNotFoundException(String message, Throwable cause){
        super(message, cause);
    }

    public PlanNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
