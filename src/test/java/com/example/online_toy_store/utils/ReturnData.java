package com.example.online_toy_store.utils;

import com.example.online_toy_store.entity.Product;
import com.example.online_toy_store.entity.Review;
import com.example.online_toy_store.entity.Supplier;
import com.example.online_toy_store.entity.enums.City;
import com.example.online_toy_store.entity.enums.Country;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class ReturnData {

    public static Product returnProduct(){
        Product product = new Product();
        product.setPId(UUID.fromString("3b287f30-6c1c-4e71-b7bf-881e2d7b3cb4"));
        product.setName("1:24 Toyota Yaris GR 2021 Alloy Car Diecasts Toy Vehicles Car Kid");
        product.setDescription("Scale: 1/24, material: metal, feature: diecast, package includes: 1pc Alloy Car Model");
        return product;
    }

    public static Set<Product> returnAllProducts(){
        Product product1 = returnProduct();
        Product product2 = new Product();
        product2.setPId(UUID.fromString("9ac0037b-2a2d-4c26-9b8c-15e720f0f8db"));
        product2.setName("CAT Little Machines 5pcs Construction Toy Vehicles Playset for Kids Ages 3");
        product2.setDescription("Bring The Whole Construction Site To Even The Smallest Of Spaces With The Cat Little Machines 5 Pack.");

        Product product3 = new Product();
        product3.setPId(UUID.fromString("ac5c8867-676f-4737-931f-052cbb9b4a94"));
        product3.setName("Toy Farm Animals Set Playset Collection of Domestic Animals Pets Flask for Kids");
        product3.setDescription("Every child has their own playtime preferences  some enjoy playing war games and building with construction sets, others play house with dolls.");

        Product product4 = new Product();
        product4.setPId(UUID.fromString("d10bb10e-ae56-4d3a-91bc-1961f2a29830"));
        product4.setName("Barbie Cutie Series Dolls Lot Of 4 Loose Articulated Poseable Toy Dolls");
        product4.setDescription("All Dolls are in very good condition, will come exactly as pictured no other accessories.");

        return Set.of(product1, product2, product3, product4);
    }

    public static Supplier returnSupplier(){
        Supplier supplier = new Supplier();
        supplier.setSupplierName("Johnson Enterprises Ltd.");
        supplier.setPhone("+33 1 23 45 67 89");
        supplier.setEmail("je@nterprises.com");
        supplier.setAddress("14 Rue de la Republique");
        supplier.setCity(City.LYON);
        supplier.setPostalCode("45678");
        supplier.setCountry(Country.FRANCE);
        supplier.setSId(UUID.fromString("c3dbdb90-d1e8-495f-b8bb-812fffa48512"));
        return supplier;
    }

    public static Set<Review> returnReviewSet(){
        Review review = new Review();
        review.setRvId(UUID.fromString("dd25f121-d167-4b96-8d09-12528c53a50f"));
        review.setReviewTitle("I was not happy with the purchase");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse("2024-02-05 13:11:34", formatter);
        review.setReviewDate(dateTime);
        return Set.of(review);
    }
}
