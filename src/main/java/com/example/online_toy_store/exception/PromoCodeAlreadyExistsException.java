package com.example.online_toy_store.exception;

public class PromoCodeAlreadyExistsException extends ObjectAlreadyExistsException {
    public PromoCodeAlreadyExistsException(String message) {
        super(message);
    }
}
