package com.example.online_toy_store.repository;

import com.example.online_toy_store.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ReviewRepository extends JpaRepository<Review, UUID> {

    @Override
    Optional<Review> findById(UUID id);
}
