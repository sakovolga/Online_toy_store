package com.example.online_toy_store.repository;

import com.example.online_toy_store.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, UUID> {

    Supplier findBySupplierName(String name);
}
