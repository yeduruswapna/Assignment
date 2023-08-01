package com.example.SunbaseDataAssignment.Exceptions;

import org.apache.catalina.User;

public class UsernameNotFoundException extends RuntimeException{
    public UsernameNotFoundException(String message){
        super(message);
    }
}
