package com.example.online_toy_store.exception;

public class OrderDoesNotExistException extends ObjectDoesNotExistException {
    public OrderDoesNotExistException(String message) {
        super(message);
    }
}
