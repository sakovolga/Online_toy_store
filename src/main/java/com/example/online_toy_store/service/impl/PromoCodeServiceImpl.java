package com.example.online_toy_store.service.impl;

import com.example.online_toy_store.entity.PromoCode;
import com.example.online_toy_store.exception.ListOfPromoCodesIsEmptyException;
import com.example.online_toy_store.exception.PromoCodeAlreadyExistsException;
import com.example.online_toy_store.exception.PromoCodeDoesNotExistException;
import com.example.online_toy_store.exception.errorMessage.ErrorMessage;
import com.example.online_toy_store.repository.PromoCodeRepository;
import com.example.online_toy_store.service.interf.PromoCodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    @Transactional
    public PromoCode createPromoCode(PromoCode promoCode) {
        PromoCode checkPromoCode = promoCodeRepository.findPromoCodeByPromoName(promoCode.getPromoName());
        if (checkPromoCode != null) throw new PromoCodeAlreadyExistsException(ErrorMessage.THE_PROMO_CODE_ALREADY_EXIST);
        return promoCodeRepository.saveAndFlush(promoCode);
    }

    @Override
    @Transactional
    public List<PromoCode> showAllPromoCodes() {
        List<PromoCode> promoCodeList = promoCodeRepository.findAll();
        if (promoCodeList.isEmpty()) throw new ListOfPromoCodesIsEmptyException(ErrorMessage.THE_LIST_OF_PROMO_CODES_IS_EMPTY);
        return promoCodeList;
    }

    @Override
    @Transactional
    public String deletePromoCodeByName(String name) {
        PromoCode checkPromoCode = promoCodeRepository.findPromoCodeByPromoName(name);
        if (checkPromoCode == null) throw new PromoCodeDoesNotExistException(name + " promo code not found");
        promoCodeRepository.deletePromoCodeByPromoName(name);
        return name + " promo code SUCCESSFULLY removed";
    }

    @Override
    public List<PromoCode> showAllPromoCodesByDiscount(double discount) {
        List<PromoCode> promoCodeList = promoCodeRepository.findAllByDiscountAmount(discount);
        if (promoCodeList.isEmpty())
            throw new ListOfPromoCodesIsEmptyException(ErrorMessage.THE_LIST_OF_PROMO_CODES_IS_EMPTY);
        return promoCodeList;
    }
}
