package com.example.online_toy_store.exception;

public class ASupplierWithTheSameNameAlreadyExistsException extends TheObjectAlreadyExistsException {
    public ASupplierWithTheSameNameAlreadyExistsException(String message) {
        super(message);
    }
}
