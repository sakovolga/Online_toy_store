package com.example.online_toy_store.exception;

public class ProductDoesNotExistException extends ObjectDoesNotExistException {
    public ProductDoesNotExistException(String message) {
        super(message);
    }
}
