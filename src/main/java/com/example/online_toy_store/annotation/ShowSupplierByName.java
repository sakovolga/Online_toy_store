package com.example.online_toy_store.annotation;

import com.example.online_toy_store.controller.handler.ErrorExtension;
import com.example.online_toy_store.entity.Supplier;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
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
@RequestMapping(method = RequestMethod.GET)
@Operation(
        summary = "Show supplier by name",
        description = "Retrieve a supplier by its unique name",
        tags = {"SUPPLIER"},
        parameters = {
                @Parameter(
                        name = "name",
                        description = "The supplier name",
                        required = true,
                        in = ParameterIn.PATH,
                        schema = @Schema(type = "string", format = "String"),
                        examples = {
                                @ExampleObject(
                                        name = "Request with correct supplier name",
                                        value = "Johnson Enterprises Ltd."
                                ),
                                @ExampleObject(
                                        name = "Request with non-exist supplier name",
                                        value = "Johnson Enterprises"
                                )
                        }
                )
        },
        responses = {
                @ApiResponse(
                        responseCode = "200",
                        description = "Supplier found and returned",
                        content = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = Supplier.class)
                        )
                ),
                @ApiResponse(
                        responseCode = "404",
                        description = "Supplier not found",
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
public @interface ShowSupplierByName {
    @AliasFor(annotation = RequestMapping.class, attribute = "path")
    String[] path() default {};
}
