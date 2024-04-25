package com.example.online_toy_store.annotation;

import com.example.online_toy_store.controller.handler.ErrorExtension;
import com.example.online_toy_store.dto.UserBeforeCreatingDto;
import com.example.online_toy_store.dto.UserCreatedDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@RequestMapping(method = RequestMethod.POST)
@Operation(
        summary = "Create new user",
        description = "The request to create a new user includes the following fields: " +
                "userName, password, firstName, lastName, country, address, city, postalCode, email, cardNumber. " +
                "The data is recorded in three tables. A user with minimal rights is created. " +
                "The password is written to the database in hashed form. Part of the data is returned as a response.",
        tags = {"USER_DTO"},
        requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                description = "The user to be created",
                required = true,
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = UserBeforeCreatingDto.class),
                        examples = {
                                @ExampleObject(name = "Good request",
                                        value = """
                                                {
                                                    "userName" : "Vasa",
                                                    "password" : "7654",
                                                    "firstName" : "Vasiliy",
                                                    "lastName" : "Vasiliev",
                                                    "country" : "FRANCE",
                                                    "address": "Main Street, 35",
                                                    "city" : "LYON",
                                                    "postalCode" : "12344",
                                                    "email" : "vasvas@gmail.com",
                                                    "cardNumber" : "12345677788990009888"
                                                }"""
                                ),
                                @ExampleObject(name = "Existing name",
                                        value = """
                                                {
                                                    "userName" : "anna_belova",
                                                    "password" : "7654",
                                                    "firstName" : "Vasiliy",
                                                    "lastName" : "Vasiliev",
                                                    "country" : "FRANCE",
                                                    "address": "Main Street, 35",
                                                    "city" : "LYON",
                                                    "postalCode" : "12344",
                                                    "email" : "vasvas@gmail.com",
                                                    "cardNumber" : "12345677788990009888"
                                                }"""
                                ),
                                @ExampleObject(name = "Existing email",
                                        value = """
                                                {
                                                    "userName" : "Vasilii",
                                                    "password" : "7654",
                                                    "firstName" : "Vasiliy",
                                                    "lastName" : "Vasiliev",
                                                    "country" : "FRANCE",
                                                    "address": "Main Street, 35",
                                                    "city" : "LYON",
                                                    "postalCode" : "12344",
                                                    "email" : "belova@gmail.com",
                                                    "cardNumber" : "12345677788990009888"
                                                }"""
                                ),
                                @ExampleObject(name = "Skipped fields",
                                        value = """
                                                {
                                                    "userName" : "Vasa",
                                                    "password" : "7654",
                                                    "firstName" : "Vasiliy",
                                                    "lastName" : "Vasiliev",
                                                    "country" : "FRANCE",
                                                    "address": "Main Street, 35",
                                                    "city" : "LYON",
                                                    "postalCode" : "12344",
                                                    "cardNumber" : "12345677788990009888"
                                                }"""
                                ),

                        }
                )
        ),
        responses = {
                @ApiResponse(
                        responseCode = "200",
                        description = "The user created",
                        content = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = UserCreatedDto.class)
                        )
                ),
                @ApiResponse(
                        responseCode = "400",
                        description = "Possible answers:" +
                                "<br> - A user with the same name already exists" +
                                "<br> - A user with the same email already exists" +
                                "<br> - Please fill in all fields",
                        content = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = ErrorExtension.class)
                        )
                )
        },
        security = {
                @SecurityRequirement(name = "safety requirements")
        }
)
public @interface CreateUserDto {
    @AliasFor(annotation = RequestMapping.class, attribute = "path")
    String[] path() default {};
}
