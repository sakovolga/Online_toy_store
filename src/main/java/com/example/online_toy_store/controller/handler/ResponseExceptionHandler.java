package com.example.online_toy_store.controller.handler;

import com.example.online_toy_store.exception.BadRequestException;
import com.example.online_toy_store.exception.ListIsEmptyException;
import com.example.online_toy_store.exception.ObjectAlreadyExistsException;
import com.example.online_toy_store.exception.ObjectDoesNotExistException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.context.annotation.Description;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.DateTimeException;

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
        if (ex.getMessage().contains("For input string:")){
            body = new ErrorExtension(
                    "Please enter correct period",
                    HttpStatus.BAD_REQUEST.value());
        }

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

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
        if (ex.getMessage().contains("for key 'users_info.user_name")) {
            body = new ErrorExtension(
                    "A user with the same name already exists",
                    HttpStatus.BAD_REQUEST.value());
        }
        if (ex.getMessage().contains("for key 'users_info.email")) {
            body = new ErrorExtension(
                    "A user with the same email already exists",
                    HttpStatus.BAD_REQUEST.value());
        }
        if (ex.getMessage().contains("cannot be null")) {
            body = new ErrorExtension(
                    "Please fill in all fields",
                    HttpStatus.BAD_REQUEST.value());
        }
        if (ex.getMessage().contains("Cannot delete or update a parent row: " +
                "a foreign key constraint fails (`online_toy_store`.`orders`, CONSTRAINT `orders_ibfk_2` " +
                "FOREIGN KEY (`promo_code_id`) REFERENCES `promo_codes` (`pc_id`))")) {
            body = new ErrorExtension(
                    "The promo code cannot be deleted because other objects reference it",
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

    @ExceptionHandler(DateTimeException.class)
    public ResponseEntity<ErrorExtension> handleDateTimeException(DateTimeException ex) {
        ErrorExtension body = new ErrorExtension(
                ex.getMessage(),
                HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorExtension> handleNullPointerException(NullPointerException ex) {
        ErrorExtension body = new ErrorExtension(
                ex.getMessage(),
                HttpStatus.BAD_REQUEST.value());
        if (ex.getMessage().contains("is null")) {
            body = new ErrorExtension(
                    "Please fill in all fields",
                    HttpStatus.BAD_REQUEST.value());
        }
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }


}
