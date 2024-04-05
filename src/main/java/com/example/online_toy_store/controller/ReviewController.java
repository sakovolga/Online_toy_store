package com.example.online_toy_store.controller;

import com.example.online_toy_store.service.interf.OrderService;
import com.example.online_toy_store.service.interf.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/review")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;


}
