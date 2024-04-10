package com.example.online_toy_store.exception;

public class ObjectDoesNotExistException extends RuntimeException{
    public ObjectDoesNotExistException(String message) {
        super(message);
    }
}
