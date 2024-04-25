package com.example.online_toy_store.controller.handler;

import lombok.Value;

@Value
public class ErrorExtension {
    String message;
    int statusCode;
    public ErrorExtension(String message, int statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }
}
