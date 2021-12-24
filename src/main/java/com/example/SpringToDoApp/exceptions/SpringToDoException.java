package com.example.SpringToDoApp.exceptions;

public class SpringToDoException extends RuntimeException{
    public SpringToDoException(String exMessage){
        super(exMessage);
    }
}