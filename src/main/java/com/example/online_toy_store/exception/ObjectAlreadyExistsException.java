package com.example.online_toy_store.exception;

public class ObjectAlreadyExistsException extends RuntimeException{
    public ObjectAlreadyExistsException(String message) {
        super(message);
    }
}

