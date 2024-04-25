package com.example.online_toy_store.annotation;

import com.example.online_toy_store.controller.handler.ErrorExtension;
import com.example.online_toy_store.dto.ProductAfterCreatingDto;
import com.example.online_toy_store.dto.ProductBeforeCreatingDto;
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
                        schema = @Schema(implementation = ProductBeforeCreatingDto.class),
                        examples = {
                                @ExampleObject(name = "Product with existing supplier",
                                        value = """
                                                {
                                                    "name" : "Small doll",
                                                    "description" : "description",
                                                    "price" : "56.9",
                                                    "availableQuantity" : "10",
                                                    "category" : "DOLLS",
                                                    "supplierName" : "Johnson Enterprises Ltd."
                                                }"""
                                ),
                                @ExampleObject(name = "Product with non-exist supplier",
                                        value = """
                                                {
                                                    "name" : "Small doll",
                                                    "description" : "description",
                                                    "price" : "56.9",
                                                    "availableQuantity" : "10",
                                                    "category" : "DOLLS",
                                                    "supplierName" : "New supplier Name",
                                                    "isAvailable" : "true",
                                                    "address" : "14 Rue de la Republic",
                                                    "city" : "LYON",
                                                    "country" : "FRANCE",
                                                    "email" : "je@nterprises.com",
                                                    "phone" : "+33 1 23 45 67 89",
                                                    "postal_code" : "12384"
                                                }"""
                                ),
                                @ExampleObject(name = "Product with incorrect data",
                                        value = """
                                                {
                                                    "name" : "Small doll",
                                                    "description" : "description",
                                                    "price" : "56.9",
                                                    "availableQuantity" : "10",
                                                    "category" : "DOLL",
                                                    "supplierName" : "New supplier Name",
                                                    "isAvailable" : "true",
                                                    "address" : "14 Rue de la Republic",
                                                    "city" : "LYON",
                                                    "country" : "FRANC",
                                                    "email" : "je@nterprises.com",
                                                    "phone" : "+33 1 23 45 67 89",
                                                    "postal_code" : "12384"
                                                }""")
                                        }
                )
        ),
        responses = {
                @ApiResponse(
                        responseCode = "200",
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
                                schema = @Schema(implementation = ErrorExtension.class)
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
