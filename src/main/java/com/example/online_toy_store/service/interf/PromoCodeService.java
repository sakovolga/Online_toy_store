package com.example.online_toy_store.service.interf;

import com.example.online_toy_store.entity.PromoCode;

import java.util.List;
import java.util.Set;

public interface PromoCodeService {

    PromoCode showByName(String name);

    PromoCode createPromoCode(PromoCode promoCode);

    List<PromoCode> showAllPromoCodes();

    String deletePromoCodeByName(String name);

    List<PromoCode> showAllPromoCodesByDiscount(double discount);
}
