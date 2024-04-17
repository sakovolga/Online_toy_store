package com.example.online_toy_store.annotation;

import com.example.online_toy_store.controller.handler.ErrorExtension;
import com.example.online_toy_store.entity.Order;
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
@RequestMapping(method = RequestMethod.DELETE)
@Operation(
        summary = "Delete order by ID",
        description = "Delete an existing order by its unique identifier",
        tags = {"ORDER"},
        parameters = {
                @Parameter(
                        name = "id",
                        description = "The unique identifier of the order",
                        required = true,
                        in = ParameterIn.PATH,
                        schema = @Schema(type = "string", format = "uuid"),
                        examples = {
                                @ExampleObject(
                                        name = "Example Id",
                                        value = "ed0285f4-4524-40f8-bcf5-6cb23b712347"
                                )
                        }
                )
        },
        responses = {
                @ApiResponse(
                        responseCode = "200",
                        description = "The order deleted",
                        content = @Content(
                                mediaType = "text/plain",
                                schema = @Schema(type = "string")
                        )
                ),
                @ApiResponse(
                        responseCode = "404",
                        description = "The order does not exist",
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
public @interface DeleteOrder {
    @AliasFor(annotation = RequestMapping.class, attribute = "path")
    String[] path() default {};
}
