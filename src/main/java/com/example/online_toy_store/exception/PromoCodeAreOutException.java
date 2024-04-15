package com.example.online_toy_store.exception;

public class PromoCodeAreOutException extends BadRequestException{
    public PromoCodeAreOutException(String message) {
        super(message);
    }
}
