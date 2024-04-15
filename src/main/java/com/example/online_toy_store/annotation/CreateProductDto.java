package com.example.online_toy_store.annotation;

import com.example.online_toy_store.dto.ProductAfterCreatingDto;
import com.example.online_toy_store.dto.ProductBeforeCreatingDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
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
@RequestMapping(method = RequestMethod.POST)
@Operation(
        summary = "Create new product with supplier",
        description = "The controller is used to create a new product. " +
                "It takes the data of the product and the supplier of that product. " +
                "If this supplier is already in the database, " +
                "the product is saved in the database with the existing supplier ID. " +
                "If the supplier is not in the database, " +
                "it is created and the product is assigned the ID of the newly created supplier.",
        tags = {"PRODUCT_DTO"},
        requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                description = "The product and it's supplier to be created",
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
                ),
                @ApiResponse(
                        responseCode = "400",
                        description = "The values specified in the enums " +
                                "(city, country or category) " +
                                "were entered incorrectly",
                        content = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = ProductAfterCreatingDto.class)
                        )
                ),
        },
        security = {
                @SecurityRequirement(name = "safety requirements")
        }
)
public @interface CreateProductDto {
    @AliasFor(annotation = RequestMapping.class, attribute = "path")
    String[] path() default {};
}
