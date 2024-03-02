package com.example.online_toy_store.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
@Getter
@Setter
@ToString
public class PromoCode {
    private UUID pcId;
    private String promoName;
    private double discountAmount;
    private LocalDate startPromoDate;
    private LocalDate endPromoDateDate;
    private int amountOfUsers;
    private int unusedQuantity;
    private Set<Order> promoOrders;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PromoCode promoCode = (PromoCode) o;
        return Objects.equals(pcId, promoCode.pcId) && Objects.equals(promoName, promoCode.promoName) && Objects.equals(startPromoDate, promoCode.startPromoDate) && Objects.equals(endPromoDateDate, promoCode.endPromoDateDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pcId, promoName, startPromoDate, endPromoDateDate);
    }
}
