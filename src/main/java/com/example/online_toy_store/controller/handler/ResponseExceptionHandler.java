package com.example.online_toy_store.controller.handler;

import com.example.online_toy_store.exception.OrderDoesNotExistException;
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

//    @ExceptionHandler(UserDoesNotExistException.class)
//    public ResponseEntity<ErrorExtension> HandleUserDoesNotExistException() {
//        ErrorExtension body = new ErrorExtension(
//                ErrorMessage.USER_DOES_NOT_EXIST,
//                "User does not exist");
//        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
//    }

//    @ExceptionHandler(UserDoesNotExistException.class)
//    protected ResponseEntity<Object> handleUserDoesNotExistException(
//            UserDoesNotExistException ex, WebRequest request) {
//        String bodyOfResponse = "User does not exist";
//        return handleExceptionInternal(ex, bodyOfResponse,
//                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
//    }

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

}
