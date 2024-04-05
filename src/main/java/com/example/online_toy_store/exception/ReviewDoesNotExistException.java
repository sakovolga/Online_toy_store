package com.example.online_toy_store.exception;

public class ReviewDoesNotExistException extends OrderDoesNotExistException{

        public ReviewDoesNotExistException(String message) {
            super(message);
        }

}
