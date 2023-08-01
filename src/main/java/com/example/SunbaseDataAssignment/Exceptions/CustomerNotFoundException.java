package com.example.SunbaseDataAssignment.Exceptions;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(String message){
        super(message);
    }
}
