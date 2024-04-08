package com.example.online_toy_store.controller;

import com.example.online_toy_store.annotation.*;
import com.example.online_toy_store.entity.PromoCode;
import com.example.online_toy_store.service.interf.PromoCodeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/promo")
@RequiredArgsConstructor
public class PromoCodeController {

    private final PromoCodeService promoCodeService;

    @CustomShowPromoCodeByName(path = "/showByName/{name}")
    public PromoCode showPromoCodeByName(@PathVariable(name = "name") String name) {
        return promoCodeService.showByName(name);
    }

    @CustomCreatePromoCode(path = "/new")
    public PromoCode createPromoCode(@RequestBody PromoCode promoCode){
        return promoCodeService.createPromoCode(promoCode);
    }

    @CustomShowAllPromoCodes(path = "/showAll")
    public List<PromoCode> showAllPromoCodes(){
        return promoCodeService.showAllPromoCodes();
    }

    @CustomShowAllPromoCodesByDiscount(path = "/showAllByDiscount/{discount}")
    public List<PromoCode> showAllPromoCodesByDiscount(@PathVariable(name = "discount") double discount){
        return promoCodeService.showAllPromoCodesByDiscount(discount);
    }

    @CustomDeletePromoCodeByName(path = "/delete/{name}")
    public String deletePromoCodeByName(@PathVariable(name = "name") String name){
        return promoCodeService.deletePromoCodeByName(name);
    }
}
