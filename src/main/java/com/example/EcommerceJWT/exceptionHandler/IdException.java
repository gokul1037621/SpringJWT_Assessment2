package com.example.EcommerceJWT.exceptionHandler;

public class IdException extends Exception{

    private String errorMessage;

    public IdException(){
        super();
    }

    public IdException(String message, String errorMessage) {
        super(message);
        this.errorMessage = errorMessage;
    }
}
