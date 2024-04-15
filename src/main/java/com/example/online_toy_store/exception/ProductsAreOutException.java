package com.example.online_toy_store.exception;

public class ProductsAreOutException extends BadRequestException {
    public ProductsAreOutException(String message) {
        super(message);
    }
}
