package com.example.online_toy_store.repository;

import com.example.online_toy_store.entity.Order;
import com.example.online_toy_store.entity.User;
import jakarta.annotation.Nonnull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {

    @Nonnull
    Optional<Order> findById(UUID id);

    @Nonnull
    Order saveAndFlush(@Nonnull Order order);

    void deleteById(@Nonnull UUID id);

//    List<Order> showAllOrders();
}
