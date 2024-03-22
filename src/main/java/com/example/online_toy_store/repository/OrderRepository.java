package com.example.online_toy_store.repository;

import com.example.online_toy_store.entity.Order;
import com.example.online_toy_store.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {

    Optional<Order> findById(UUID id);
}
