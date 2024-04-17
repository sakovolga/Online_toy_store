package com.example.online_toy_store.annotation;

import com.example.online_toy_store.controller.handler.ErrorExtension;
import com.example.online_toy_store.dto.OrderDtoAfter;
import com.example.online_toy_store.dto.OrderDtoBefore;
import com.example.online_toy_store.dto.UserReportDtoAfter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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
@RequestMapping(method = RequestMethod.GET)
@Operation(
        summary = "Get top 3 buyers",
        description = "The controller is used to generate a report of the top three customers. " +
                "The month, year and country of residence of the buyer are accepted at the entrance." +
                " The result is a list of the top three buyers for a given period of time from the selected country. " +
                "Customer data contains ID, first name, last name and purchase amount.",
        tags = {"USER_DTO"},
        parameters = {
                @Parameter(
                        name = "country",
                        description = "Country of residence",
                        required = true,
                        schema = @Schema(type = "string"),
                        examples = {
                                @ExampleObject(
                                        name = "Example country",
                                        value = "GERMANY"
                                )
                        }
                ),
                @Parameter(
                        name = "month",
                        description = "Month (MM format)",
                        required = true,
                        schema = @Schema(type = "string", format = "MM"),
                        examples = {
                                @ExampleObject(
                                        name = "Example month",
                                        value = "02"
                                )
                        }
                ),
                @Parameter(
                        name = "year",
                        description = "Year (YYYY format)",
                        required = true,
                        schema = @Schema(type = "string", format = "YYYY"),
                        examples = {
                                @ExampleObject(
                                        name = "Example year",
                                        value = "2024"
                                )
                        }
                )
        },
        responses = {
                @ApiResponse(
                        responseCode = "200",
                        description = "Possible answers: " +
                                "<br> - List of top 3 buyers" +
                                "<br> - No users were found for your request",
                        content = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = UserReportDtoAfter.class)
                        )
                ),
                @ApiResponse(
                        responseCode = "400",
                        description = "Possible answers:" +
                                "<br> - Invalid value for MonthOfYear (valid values 1 - 12)" +
                                "<br> - Please enter correct period" +
                                "<br> - The country does not exist!!! Please enter an existing country",
                        content = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = ErrorExtension.class)
                        )
                ),
        },
        security = {
                @SecurityRequirement(name = "safety requirements")
        }
)
public @interface GetTopUsers {
    @AliasFor(annotation = RequestMapping.class, attribute = "path")
    String[] path() default {};
}
