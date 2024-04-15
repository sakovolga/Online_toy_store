package com.example.online_toy_store.annotation;

import com.example.online_toy_store.dto.ProductAfterCreatingDto;
import com.example.online_toy_store.dto.ProductBeforeCreatingDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
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
@RequestMapping(method = RequestMethod.GET)
@Operation(
        summary = "Get product by ID and return it's name and available quantity",
        description = "The controller serves as a product search. " +
                "It takes the product name and its quantity and returns it too",
        tags = {"PRODUCT_DTO"},
        requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                description = "The product to be shown",
                required = true,
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = ProductBeforeCreatingDto.class)
                )
        ),
        responses = {
                @ApiResponse(
                        responseCode = "201",
                        description = "The product created",
                        content = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = ProductAfterCreatingDto.class)
                        )
                )
        },
        security = {
                @SecurityRequirement(name = "safety requirements")
        }
)
public @interface ProductNameAndQuantityDto {
    @AliasFor(annotation = RequestMapping.class, attribute = "path")
    String[] path() default {};
    String description();
}
