package com.example.online_toy_store.exception;

public class NoProductsFoundException extends TheListIsEmptyException {
    public NoProductsFoundException(String message) {
        super(message);
    }
}
