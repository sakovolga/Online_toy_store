package com.example.online_toy_store.annotation;

import com.example.online_toy_store.controller.handler.ErrorExtension;
import com.example.online_toy_store.dto.UserInfoRolesResponse;
import com.example.online_toy_store.entity.UserInfo;
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
@RequestMapping(method = RequestMethod.PUT)
@Operation(
        summary = "Update user roles by admin",
        description = "The request includes the UUID of the path variable and a request body with following " +
                "boolean fields: isCustomer, isManager, isSuper_manager, isAdmin. " +
                "The controller updates the data and return this user with his roles and authorities.",
        tags = {"USER_INFO_DTO"},
        parameters = {
                @Parameter(
                        name = "id",
                        description = "The unique identifier of the userInfo",
                        required = true,
                        in = ParameterIn.PATH,
                        schema = @Schema(format = "uuid"),
                        examples = {
                                @ExampleObject(
                                        name = "Good Id",
                                        value = "08ae72f7-4d3b-4fb1-bb0b-1aaae6b4a8ed"
                                ),
                                @ExampleObject(
                                        name = "Non-exist Id",
                                        value = "08ae72f7-4d3b-4fb1-bb0b-1aaae6b4a8e1"
                                )
                        }

                )
        },
        requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                description = "Boolean fields: isCustomer, isManager, isSuper_manager, isAdmin",
                required = true,
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = UpdateUserInfoRoles.class),
                        examples = {
                                @ExampleObject(name = "Good request",
                                        value = "{\n" +
                                                "    \"isCustomer\" : true,\n" +
                                                "    \"isManager\" : true,\n" +
                                                "    \"isSuper_manager\" : true,\n" +
                                                "    \"isAdmin\" : false\n" +
                                                "}"
                                )
                        }
                )
        ),
        responses = {
                @ApiResponse(
                        responseCode = "200",
                        description = "Response to be created",
                        content = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = UserInfoRolesResponse.class)
                        )
                ),
                @ApiResponse(
                        responseCode = "404",
                        description = "User does not exist",
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
public @interface UpdateUserInfoRoles {
    @AliasFor(annotation = RequestMapping.class, attribute = "path")
    String[] path() default {};
}
