package com.example.online_toy_store.controller.handler;

import com.example.online_toy_store.dto.ErrorExtension;
import com.example.online_toy_store.exception.*;
import jakarta.validation.ConstraintViolationException;
import jdk.jshell.Snippet;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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
    public ResponseEntity<String> handleOrderNotFoundException(OrderDoesNotExistException ex) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .headers(headers)
                .body(ex.getMessage());
    }

    @ExceptionHandler(SupplierDoesNotExistException.class)
    public ResponseEntity<String> handleSupplierNotFoundException(SupplierDoesNotExistException ex) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .headers(headers)
                .body(ex.getMessage());
    }

    @ExceptionHandler(ASupplierWithTheSameNameAlreadyExistsException.class)
    public ResponseEntity<String> handleSupplierAlreadyExistException(ASupplierWithTheSameNameAlreadyExistsException ex) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .headers(headers)
                .body(ex.getMessage());
    }

    @ExceptionHandler(ProductDoesNotExistException.class)
    public ResponseEntity<String> handleProductDoesNotExistException(ProductDoesNotExistException ex) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .headers(headers)
                .body(ex.getMessage());
    }

    @ExceptionHandler(PromoCodeDoesNotExistException.class)
    public ResponseEntity<String> handlePromoCodeDoesNotExistException(PromoCodeDoesNotExistException ex) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .headers(headers)
                .body(ex.getMessage());
    }

    @ExceptionHandler(ThePromoCodeAlreadyExistsException.class)
    public ResponseEntity<String> handleThePromoCodeAlreadyExistsException(ThePromoCodeAlreadyExistsException ex) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .headers(headers)
                .body(ex.getMessage());
    }

    @ExceptionHandler(TheListOfPromoCodesIsEmptyException.class)
    public ResponseEntity<String> handleTheListOfPromoCodesIsEmptyException(TheListOfPromoCodesIsEmptyException ex) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return ResponseEntity
                .status(HttpStatus.OK)
                .headers(headers)
                .body(ex.getMessage());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException ex) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .headers(headers)
                .body(ex.getMessage());
    }

}
