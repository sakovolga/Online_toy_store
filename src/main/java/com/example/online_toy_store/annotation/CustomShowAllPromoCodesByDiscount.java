package com.example.online_toy_store.annotation;

import com.example.online_toy_store.entity.PromoCode;
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
        summary = "Show all promo codes by discount amount",
        description = "Get a list of promo codes with particular discount amount",
        tags = {"PROMO_CODE"},
        responses = {
                @ApiResponse(
                        responseCode = "200",
                        description = "Required promo codes received",
                        content = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = PromoCode.class)
                        )
                ),
                @ApiResponse(
                        responseCode = "200",
                        description = "No promo codes found"
                )
        },
        security = {
                @SecurityRequirement(name = "safety requirements")
        }
)
public @interface CustomShowAllPromoCodesByDiscount {
    @AliasFor(annotation = RequestMapping.class, attribute = "path")
    String[] path() default {};
}
