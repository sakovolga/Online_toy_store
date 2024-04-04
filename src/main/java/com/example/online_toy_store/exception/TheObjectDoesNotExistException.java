package com.example.online_toy_store.exception;

public class TheObjectDoesNotExistException extends RuntimeException{
    public TheObjectDoesNotExistException(String message) {
        super(message);
    }
}
