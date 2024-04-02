package com.example.online_toy_store.controller;

import com.example.online_toy_store.entity.PromoCode;
import com.example.online_toy_store.service.interf.PromoCodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/promo")
@RequiredArgsConstructor
public class PromoCodeController {

    private final PromoCodeService promoCodeService;

    @GetMapping("/showByName/{name}")
    public PromoCode showPromoCodeByName(@PathVariable(name = "name") String name) {
        return promoCodeService.showByName(name);
    }

    @PostMapping("/new")
    public PromoCode createPromoCode(@RequestBody PromoCode promoCode){
        return promoCodeService.createPromoCode(promoCode);
    }

    @GetMapping("/showAll")
    public List<PromoCode> showAllPromoCodes(){
        return promoCodeService.showAllPromoCodes();
    }

    @GetMapping("/showAllByDiscount/{discount}")
    public List<PromoCode> showAllPromoCodesByDiscount(@PathVariable(name = "discount") double discount){
        return promoCodeService.showAllPromoCodesByDiscount(discount);
    }

    @DeleteMapping("/delete/{name}")
    public String deletePromoCodeByName(@PathVariable(name = "name") String name){
        return promoCodeService.deletePromoCodeByName(name);
    }
}
