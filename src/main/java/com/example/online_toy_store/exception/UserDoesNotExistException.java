package com.example.online_toy_store.exception;

import jakarta.persistence.NoResultException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserDoesNotExistException extends TheObjectDoesNotExistException {

    public UserDoesNotExistException(String message) {
        super(message);
    }
}
