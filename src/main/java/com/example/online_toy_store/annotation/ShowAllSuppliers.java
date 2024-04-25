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
@RequestMapping(method = RequestMethod.GET)
@Operation(
        summary = "Show all suppliers",
        description = "Get a list of all existing suppliers",
        tags = {"SUPPLIER"},
        responses = {
                @ApiResponse(
                        responseCode = "200",
                        description = "All suppliers received or no suppliers found",
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
public @interface ShowAllSuppliers {
    @AliasFor(annotation = RequestMapping.class, attribute = "path")
    String[] path() default {};
}
