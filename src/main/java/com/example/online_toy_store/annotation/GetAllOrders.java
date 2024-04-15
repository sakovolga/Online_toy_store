package com.example.online_toy_store.annotation;

import com.example.online_toy_store.entity.Order;
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
        summary = "Show all orders",
        description = "Get a list of all existing orders in all statuses",
        tags = {"ORDER"},
        responses = {
                @ApiResponse(
                        responseCode = "200",
                        description = "All orders received",
                        content = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = Order.class)
                        )
                ),
                @ApiResponse(
                        responseCode = "204",
                        description = "No orders found"
                )
        },
        security = {
                @SecurityRequirement(name = "safety requirements")
        }
)
public @interface GetAllOrders {
    @AliasFor(annotation = RequestMapping.class, attribute = "path")
    String[] path() default {};
}
