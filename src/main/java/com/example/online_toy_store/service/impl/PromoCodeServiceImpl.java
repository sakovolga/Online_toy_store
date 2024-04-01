package com.example.online_toy_store.service.impl;

import com.example.online_toy_store.entity.PromoCode;
import com.example.online_toy_store.exception.PromoCodeDoesNotExistException;
import com.example.online_toy_store.repository.PromoCodeRepository;
import com.example.online_toy_store.service.interf.PromoCodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PromoCodeServiceImpl implements PromoCodeService {

    private final PromoCodeRepository promoCodeRepository;
    @Override
    @Transactional
    public PromoCode showByName(String name) {
        PromoCode promoCode = promoCodeRepository.findPromoCodeByPromoName(name);
        if (promoCode == null) throw new PromoCodeDoesNotExistException(name + " promo code not found");
        return promoCode;
    }
}
