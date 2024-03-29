package com.example.online_toy_store.entity;

import com.example.online_toy_store.generator.UuidTimeSequenceGenerator;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
@Entity
@Table(name = "promo_codes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PromoCode {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", type = UuidTimeSequenceGenerator.class)
    @Column(name = "pc_id")
    private UUID pcId;

    @Column(name = "promo_name")
    private String promoName;

    @Column(name = "discount_amount")
    private double discountAmount;

    @Column(name = "start_promo_date")
    private LocalDate startPromoDate;

    @Column(name = "end_promo_date")
    private LocalDate endPromoDateDate;

    @Column(name = "amount_of_users")
    private int amountOfUsers;

    @Column(name = "unused_quantity")
    private int unusedQuantity;

    @JsonBackReference
    @OneToMany(mappedBy = "promoCode", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
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
