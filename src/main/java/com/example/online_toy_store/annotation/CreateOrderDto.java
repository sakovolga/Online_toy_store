package com.example.online_toy_store.annotation;

import com.example.online_toy_store.dto.OrderDtoAfter;
import com.example.online_toy_store.dto.OrderDtoBefore;
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
@RequestMapping(method = RequestMethod.POST)
@Operation(
        summary = "Create order in the shop",
        description = "The controller is used to create an order. " +
                "The body of the request contains the user ID, the name of the promo code, " +
                "and a set of order details. The order details contain the product ID, quantity and comment." +
                " The response contains a message about the successful completion of the order indicating the username. " +
                "And also the following fields: order date (current date), order status " +
                "(processing is automatically assigned), order details (product name, quantity, price, comment), " +
                "the total cost of the order is calculated, the discount is indicated, the price with a discount. " +
                "After executing the query in the database, the number of units of the remaining product is reduced, " +
                "the field isAvalible is changed, and the number of remaining units of the promotional code is reduced." +
                " The validity date of the promotional code is also checked.",
        tags = {"ORDER_DTO"},
        requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                description = "The order and it's order details to be created",
                required = true,
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = OrderDtoBefore.class)
                )
        ),
        responses = {
                @ApiResponse(
                        responseCode = "200",
                        description = "The order created",
                        content = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = OrderDtoAfter.class)
                        )
                ),
                @ApiResponse(
                        responseCode = "400",
                        description = "Possible answers:" +
                                "<br> - Less than {quantity} items left: {productName}" +
                                "<br> - All available units of promo code {PromoName} have been used" +
                                "<br> - Invalid promotional code expiration date" +
                                "<br> - User is not found! Please login" +
                                "<br> - There is no such product! Please refresh the page",
                        content = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = OrderDtoAfter.class)
                        )
                ),
                @ApiResponse(
                        responseCode = "404",
                        description = "There is no promotional code with this name",
                        content = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = OrderDtoAfter.class)
                        )
                ),
        },
        security = {
                @SecurityRequirement(name = "safety requirements")
        }
)
public @interface CreateOrderDto {
    @AliasFor(annotation = RequestMapping.class, attribute = "path")
    String[] path() default {};
}
