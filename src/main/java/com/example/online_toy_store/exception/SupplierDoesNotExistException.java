package com.example.online_toy_store.exception;

public class SupplierDoesNotExistException extends ObjectDoesNotExistException {
    public SupplierDoesNotExistException(String message) {
        super(message);
    }
}
