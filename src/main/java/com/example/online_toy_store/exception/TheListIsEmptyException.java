package com.example.online_toy_store.exception;

public class TheListIsEmptyException extends RuntimeException {
    public TheListIsEmptyException(String message) {
        super(message);
    }
}
