package com.example.online_toy_store.annotation;

import com.example.online_toy_store.entity.Review;
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
        summary = "Show review by ID",
        description = "Retrieve an review by its unique identifier",
        tags = {"REVIEW"},
        parameters = {
                @Parameter(
                        name = "id",
                        description = "The unique identifier of the review",
                        required = true,
                        in = ParameterIn.PATH,
                        schema = @Schema(type = "string", format = "uuid")
                )
        },
        responses = {
                @ApiResponse(
                        responseCode = "200",
                        description = "Review found and returned",
                        content = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = Review.class)
                        )
                ),
                @ApiResponse(
                        responseCode = "404",
                        description = "Review not found"
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
public @interface CustomShowReviewById {
    @AliasFor(annotation = RequestMapping.class, attribute = "path")
    String[] path() default {};
}
