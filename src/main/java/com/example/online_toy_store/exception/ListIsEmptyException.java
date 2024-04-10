package com.example.online_toy_store.exception;

public class ListIsEmptyException extends RuntimeException {
    public ListIsEmptyException(String message) {
        super(message);
    }
}
