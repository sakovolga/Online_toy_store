package com.example.online_toy_store.annotation;

import com.example.online_toy_store.controller.handler.ErrorExtension;
import com.example.online_toy_store.entity.Product;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@RequestMapping(method = RequestMethod.GET)
@Operation(summary = "Show product by ID",
        description = "Retrieve a product by its unique identifier",
        tags = {"PRODUCT"},
        parameters = {
        @Parameter(
                name = "id",
                description = "The unique identifier of the product",
                required = true,
                in = ParameterIn.PATH,
                schema = @Schema(type = "string", format = "uuid"),
                examples = {
                        @ExampleObject(
                                name = "Example request with correct Id",
                                value = "3b287f30-6c1c-4e71-b7bf-881e2d7b3cb4"
                        ),
                        @ExampleObject(
                                name = "Example request with non-exist Id",
                                value = "3b287f30-6c1c-4e71-b7bf-881e2d7b3cb1"
                        ),
                        @ExampleObject(
                                name = "Example request with invalid Id",
                                value = "invalidId"
                        )
                }
        )
},
        responses = {
                @ApiResponse(
                        responseCode = "200",
                        description = "Product found and returned",
                        content = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = Product.class)
                        )
                ),
                @ApiResponse(
                        responseCode = "404",
                        description = "Product not found",
                        content = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = ErrorExtension.class)
                        )
                ),
                @ApiResponse(
                        responseCode = "400",
                        description = "Invalid ID",
                        content = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = ErrorExtension.class)
                        )
                )
        })
public @interface GetProduct {
    @AliasFor(annotation = RequestMapping.class, attribute = "path")
    String[] path() default {};
}
