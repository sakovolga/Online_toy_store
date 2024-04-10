package com.example.online_toy_store.repository;

import com.example.online_toy_store.entity.Order;
import jakarta.annotation.Nonnull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNullApi;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {

    Optional<Order> findById(@Nonnull UUID id);


    Order saveAndFlush(@Nonnull Order order);

    void deleteById(@Nonnull UUID id);
}
