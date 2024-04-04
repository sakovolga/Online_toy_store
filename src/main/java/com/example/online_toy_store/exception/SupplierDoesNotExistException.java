package com.example.online_toy_store.exception;

import jakarta.persistence.NoResultException;

public class SupplierDoesNotExistException extends TheObjectDoesNotExistException {
    public SupplierDoesNotExistException(String message) {
        super(message);
    }
}
