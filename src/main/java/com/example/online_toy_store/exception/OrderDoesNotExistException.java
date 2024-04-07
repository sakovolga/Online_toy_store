package com.example.online_toy_store.exception;

import jakarta.persistence.NoResultException;

public class OrderDoesNotExistException extends TheObjectDoesNotExistException {
    public OrderDoesNotExistException(String message) {
        super(message);
    }
}
