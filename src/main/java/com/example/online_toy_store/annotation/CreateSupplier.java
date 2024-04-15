package com.example.online_toy_store.annotation;

import com.example.online_toy_store.entity.Supplier;
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
@RequestMapping(method = RequestMethod.POST)
@Operation(
        summary = "Create new supplier",
        description = "Create new supplier and return him",
        tags = {"SUPPLIER"},
        requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                description = "The supplier to be created",
                required = true,
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = Supplier.class)
                )
        ),
        responses = {
                @ApiResponse(
                        responseCode = "201",
                        description = "The supplier created",
                        content = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = Supplier.class)
                        )
                ),
                @ApiResponse(
                        responseCode = "400",
                        description = "The supplier already exist",
                        content = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = Supplier.class)
                        )
                )
        },
        security = {
                @SecurityRequirement(name = "safety requirements")
        }
)
public @interface CreateSupplier {
    @AliasFor(annotation = RequestMapping.class, attribute = "path")
    String[] path() default {};
}
