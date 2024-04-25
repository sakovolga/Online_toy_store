package com.example.online_toy_store.annotation;

import com.example.online_toy_store.controller.handler.ErrorExtension;
import com.example.online_toy_store.entity.PromoCode;
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
        summary = "Create new promo code",
        description = "Create new promo code and return it",
        tags = {"PROMO_CODE"},
        requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                description = "The promo code to be created",
                required = true,
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = PromoCode.class),
                        examples = {
                                @ExampleObject(name = "Good request",
                                        value = """
                                                {
                                                    "promoName" : "Hot summer discounts",
                                                    "discountAmount" : 15.5,
                                                    "startPromoDate" : "2024-08-20T00:00:00",
                                                    "endPromoDate" : "2024-08-31T00:00:00",
                                                    "amountOfUsers" : 50,
                                                    "unusedQuantity" : 50
                                                }"""),
                                @ExampleObject(name = "Request with existing promo code name",
                                        value = """
                                                {
                                                    "promoName" : "Spring Surprise",
                                                    "discountAmount" : 15.5,
                                                    "startPromoDate" : "2024-08-20T00:00:00",
                                                    "endPromoDate" : "2024-08-31T00:00:00",
                                                    "amountOfUsers" : 50,
                                                    "unusedQuantity" : 50
                                                }""")
                        }
                )
        ),
        responses = {
                @ApiResponse(
                        responseCode = "200",
                        description = "The promo code created",
                        content = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = PromoCode.class)
                        )
                ),
                @ApiResponse(
                        responseCode = "400",
                        description = "The promo code already exist",
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
public @interface CreatePromoCode {
    @AliasFor(annotation = RequestMapping.class, attribute = "path")
    String[] path() default {};
}
