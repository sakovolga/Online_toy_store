package com.example.online_toy_store.controller;

import com.example.online_toy_store.annotation.ShowReviewById;
import com.example.online_toy_store.entity.Review;
import com.example.online_toy_store.service.interf.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/review")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @ShowReviewById(path = "/showReview/{id}")
    public Review showReviewById(@PathVariable(name = "id") String id){
        return reviewService.showReview(id);
    }
}
