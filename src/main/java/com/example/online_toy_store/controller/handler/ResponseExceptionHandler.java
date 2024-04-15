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

    @Description(value = "Отлавливание невалидного UUID с помощью Spring," +
            " а также значений, которых нет в Enum")
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorExtension> handleIllegalArgumentException(IllegalArgumentException ex) {
        ErrorExtension body = new ErrorExtension(ex.getMessage(),
                HttpStatus.BAD_REQUEST.value());
        if (ex.getMessage().contains("No enum constant com.example.online_toy_store.entity.enums.City")){
            body = new ErrorExtension(
                    "The city does not exist!!! Please enter an existing city",
                    HttpStatus.BAD_REQUEST.value());
        }
        if (ex.getMessage().contains("No enum constant com.example.online_toy_store.entity.enums.Country")){
            body = new ErrorExtension(
                    "The country does not exist!!! Please enter an existing country",
                    HttpStatus.BAD_REQUEST.value());
        }
        if (ex.getMessage().contains("No enum constant com.example.online_toy_store.entity.enums.Category")){
            body = new ErrorExtension(
                    "The category does not exist!!! Please enter an existing category",
                    HttpStatus.BAD_REQUEST.value());
        }
        if (ex.getMessage().contains("No enum constant com.example.online_toy_store.entity.enums.OrderStatus")){
            body = new ErrorExtension(
                    "The order status does not exist!!! Please enter an existing order status",
                    HttpStatus.BAD_REQUEST.value());
        }
        if (ex.getMessage().contains("No enum constant com.example.online_toy_store.entity.enums.Rating")){
            body = new ErrorExtension(
                    "The rating does not exist!!! Please enter an existing rating",
                    HttpStatus.BAD_REQUEST.value());
        }

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @Description(value = "Отлавливание исключения, когда невозможно удалить объект, на который ссылаются другие объекты")
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorExtension> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        ErrorExtension body = new ErrorExtension(
                ex.getMessage(),
                HttpStatus.BAD_REQUEST.value());
        if (ex.getMessage().contains("(`online_toy_store`.`orders`, CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`user_id`)")){
            body = new ErrorExtension(
                    "User is not found! Please login",
                    HttpStatus.BAD_REQUEST.value());
        }
        if (ex.getMessage().contains("(`online_toy_store`.`order_details`, CONSTRAINT `order_details_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `products` (`p_id`))")){
            body = new ErrorExtension(
                    "There is no such product! Please refresh the page",
                    HttpStatus.BAD_REQUEST.value());
        }
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorExtension> handleBadRequestException(BadRequestException ex) {
        ErrorExtension body = new ErrorExtension(
                ex.getMessage(),
                HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
}
