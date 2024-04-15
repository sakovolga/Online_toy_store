package com.example.online_toy_store.repository;

import com.example.online_toy_store.entity.PromoCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface PromoCodeRepository extends JpaRepository<PromoCode, UUID> {

    PromoCode findPromoCodeByPromoName(String name);

    @Override
    Optional<PromoCode> findById(UUID uuid);

    void deletePromoCodeByPromoName(String name);

    List<PromoCode> findAllByDiscountAmount(double discount);
}
