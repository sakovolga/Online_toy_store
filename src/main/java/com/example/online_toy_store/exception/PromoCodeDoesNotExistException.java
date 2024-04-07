package com.example.online_toy_store.exception;

import jakarta.persistence.NoResultException;

public class PromoCodeDoesNotExistException extends TheObjectDoesNotExistException {
    public PromoCodeDoesNotExistException(String message) {
        super(message);
    }
}
