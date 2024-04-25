package com.example.online_toy_store.annotation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
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
@RequestMapping(method = RequestMethod.DELETE)
@Operation(
        summary = "Delete promo code by name",
        description = "Delete an existing order by its unique name",
        tags = {"PROMO_CODE"},
        parameters = {
                @Parameter(
                        name = "name",
                        description = "The unique promo code name",
                        required = true,
                        in = ParameterIn.PATH,
                        schema = @Schema(type = "string", format = "String"),
                        examples = {
                                @ExampleObject(name = "Good request",
                                        value = "Smile"),
                                @ExampleObject(name = "Request with non-exist Id",
                                        value = "Smiles"),
                                @ExampleObject(name = "Request with associated promo code",
                                        value = "Spring Surprise")
                        }
                )
        },
        responses = {
                @ApiResponse(
                        responseCode = "200",
                        description = "The promo code deleted"
                ),
                @ApiResponse(
                        responseCode = "404",
                        description = "The promo code does not exist"
                ),
                @ApiResponse(
                        responseCode = "400",
                        description = "The promo code cannot be deleted because other objects reference it"
                ),
        },
        security = {
                @SecurityRequirement(name = "safety requirements")
        }
)
public @interface DeletePromoCodeByName {
    @AliasFor(annotation = RequestMapping.class, attribute = "path")
    String[] path() default {};
}
