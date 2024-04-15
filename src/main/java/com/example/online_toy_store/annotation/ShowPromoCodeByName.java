package com.example.online_toy_store.annotation;

import com.example.online_toy_store.entity.PromoCode;
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
@RequestMapping(method = RequestMethod.GET)
@Operation(
        summary = "Show promo code by name",
        description = "Retrieve a promo code by its unique name",
        tags = {"PROMO_CODE"},
        parameters = {
                @Parameter(
                        name = "name",
                        description = "The promo code name",
                        required = true,
                        in = ParameterIn.PATH,
                        schema = @Schema(type = "string", format = "String")
                )
        },
        responses = {
                @ApiResponse(
                        responseCode = "200",
                        description = "Promo code found and returned",
                        content = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = PromoCode.class)
                        )
                ),
                @ApiResponse(
                        responseCode = "404",
                        description = "Promo code not found"
                ),
                @ApiResponse(
                        responseCode = "400",
                        description = "Invalid ID" //Спросить почему не показывает в браузере
                )
        },
        security = {
                @SecurityRequirement(name = "safety requirements")
        },
        hidden = false
)
public @interface ShowPromoCodeByName {
    @AliasFor(annotation = RequestMapping.class, attribute = "path")
    String[] path() default {};
}
