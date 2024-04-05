package com.example.online_toy_store.service.impl;

import com.example.online_toy_store.entity.Product;
import com.example.online_toy_store.entity.Review;
import com.example.online_toy_store.exception.ProductDoesNotExistException;
import com.example.online_toy_store.exception.ReviewDoesNotExistException;
import com.example.online_toy_store.exception.errorMessage.ErrorMessage;
import com.example.online_toy_store.repository.ProductRepository;
import com.example.online_toy_store.repository.ReviewRepository;
import com.example.online_toy_store.service.interf.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    @Override
    @Transactional
    public Review showReview(String id) {
        return reviewRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new ReviewDoesNotExistException(ErrorMessage.REVIEW_DOES_NOT_EXIST));
    }


}
