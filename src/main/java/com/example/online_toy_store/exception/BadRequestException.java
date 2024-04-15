package com.example.online_toy_store.exception;

public class BadRequestException  extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}
