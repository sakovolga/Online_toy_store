package com.example.online_toy_store.exception;

//@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserDoesNotExistException extends ObjectDoesNotExistException {

    public UserDoesNotExistException(String message) {
        super(message);
    }
}
