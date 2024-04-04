package com.example.online_toy_store.exception;

public class TheOrderAlreadyExistsException extends TheObjectAlreadyExistsException {
    public TheOrderAlreadyExistsException(String message) {
        super(message);
    }
}
