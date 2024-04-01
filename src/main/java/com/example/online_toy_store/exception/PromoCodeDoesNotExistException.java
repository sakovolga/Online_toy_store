package com.example.online_toy_store.exception;

public class PromoCodeDoesNotExistException extends RuntimeException {
    public PromoCodeDoesNotExistException(String message) {
        super(message);
    }
}
