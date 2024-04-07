package com.example.online_toy_store.controller;

import com.example.online_toy_store.entity.Review;
import com.example.online_toy_store.service.interf.ReviewService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/review")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

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
    @GetMapping("/showReview/{id}")
    public Review showReviewById(@PathVariable(name = "id") String id){
        return reviewService.showReview(id);
    }
}
