package com.example.online_toy_store.annotation;

import com.example.online_toy_store.entity.Product;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
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
@Operation(summary = "Show product by ID", description = "Retrieve a product by its unique identifier", tags = {"PRODUCT"},
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
                        description = "Product not found"
                ),
                @ApiResponse(
                        responseCode = "400",
                        description = "Invalid ID"
                )
        })
public @interface GetProductMappingAndDocumentation {
    @AliasFor(annotation = RequestMapping.class, attribute = "path")
    String[] path() default {};
}
