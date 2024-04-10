package com.example.online_toy_store.controller.handler;

import com.example.online_toy_store.exception.*;
import com.example.online_toy_store.exception.ObjectDoesNotExistException;
import com.example.online_toy_store.exception.errorMessage.ErrorMessage;
import jakarta.validation.ConstraintViolationException;
import org.springframework.context.annotation.Description;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class ResponseExceptionHandler {

    @ExceptionHandler(ObjectDoesNotExistException.class)
    public ResponseEntity<ErrorExtension> handleObjectDoesNotExistException(ObjectDoesNotExistException ex) {
        ErrorExtension body = new ErrorExtension(
                ex.getMessage(),
                HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ObjectAlreadyExistsException.class)
    public ResponseEntity<ErrorExtension> handleObjectAlreadyExistsException(ObjectAlreadyExistsException ex) {
        ErrorExtension body = new ErrorExtension(
                ex.getMessage(),
                HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ListIsEmptyException.class)
    public ResponseEntity<ErrorExtension> handleListIsEmptyException(ListIsEmptyException ex) {
        ErrorExtension body = new ErrorExtension(
                ex.getMessage(),
                HttpStatus.OK.value());
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    @Description(value = "Отлавливание невалидного UUID с помощью ConstraintViolationException.class")
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorExtension> handleConstraintViolationException(ConstraintViolationException ex) {
        String errorMessage = ex.getMessage();
        int index = errorMessage.indexOf(":") + 1;
        errorMessage = errorMessage.substring(index).trim();
        ErrorExtension body = new ErrorExtension(errorMessage, HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @Description(value = "Отлавливание невалидного UUID с помощью Spring")
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorExtension> handleIllegalArgumentException(IllegalArgumentException ex) {
        ErrorExtension body = new ErrorExtension(
                ex.getMessage(),
                HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @Description(value = "Отлавливание исключения, когда невозможно удалить объект, на который ссылаются другие объекты")
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorExtension> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        ErrorExtension body = new ErrorExtension(
                ex.getMessage(),
                HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
}
