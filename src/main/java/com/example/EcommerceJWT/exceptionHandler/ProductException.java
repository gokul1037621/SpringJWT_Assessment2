package com.example.EcommerceJWT.exceptionHandler;

public class ProductException extends Exception{

    public static final int id = 1;
    private String errorMessage;

    public ProductException(){

    }

    public ProductException(String message, String errorMessage) {
        super(message);
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
