package com.example.online_toy_store.controller.handler;

import com.example.online_toy_store.exception.ASupplierWithTheSameNameAlreadyExistsException;
import com.example.online_toy_store.exception.OrderDoesNotExistException;
import com.example.online_toy_store.exception.SupplierDoesNotExistException;
import com.example.online_toy_store.exception.UserDoesNotExistException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ResponseExceptionHandler {

    @ExceptionHandler(UserDoesNotExistException.class)
    public ResponseEntity<String> handleUserNotFoundException(UserDoesNotExistException ex) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .headers(headers)
                .body(ex.getMessage());
    }

    @ExceptionHandler(OrderDoesNotExistException.class)
    public ResponseEntity<String> handleUserNotFoundException(OrderDoesNotExistException ex) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .headers(headers)
                .body(ex.getMessage());
    }

    @ExceptionHandler(SupplierDoesNotExistException.class)
    public ResponseEntity<String> handleUserNotFoundException(SupplierDoesNotExistException ex) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .headers(headers)
                .body(ex.getMessage());
    }

    @ExceptionHandler(ASupplierWithTheSameNameAlreadyExistsException.class)
    public ResponseEntity<String> handleUserNotFoundException(ASupplierWithTheSameNameAlreadyExistsException ex) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .headers(headers)
                .body(ex.getMessage());
    }



}
