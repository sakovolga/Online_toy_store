package com.example.online_toy_store.exception;

public class ASupplierWithTheSameNameAlreadyExistsException extends RuntimeException {
    public ASupplierWithTheSameNameAlreadyExistsException(String message) {
        super(message);
    }
}
