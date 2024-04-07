package com.example.online_toy_store.exception;

import jakarta.persistence.NoResultException;

public class ProductDoesNotExistException extends TheObjectDoesNotExistException {
    public ProductDoesNotExistException(String message) {
        super(message);
    }
}
