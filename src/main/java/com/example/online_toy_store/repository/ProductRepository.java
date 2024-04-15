package com.example.online_toy_store.repository;

import com.example.online_toy_store.entity.Product;
import jakarta.annotation.Nonnull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    @Nonnull
    Optional<Product> findById(@Nonnull UUID id);
}
