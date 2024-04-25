package com.example.online_toy_store.utils;

import com.example.online_toy_store.dto.UserBeforeCreatingDto;
import com.example.online_toy_store.dto.UserDto;
import com.example.online_toy_store.entity.*;
import com.example.online_toy_store.entity.enums.City;
import com.example.online_toy_store.entity.enums.Country;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class ExpectedData {

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

//    public static Set<Review> returnReviewSet(){
//        Review review = new Review();
//        review.setRvId(UUID.fromString("dd25f121-d167-4b96-8d09-12528c53a50f"));
//        review.setReviewTitle("I was not happy with the purchase");
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        LocalDateTime dateTime = LocalDateTime.parse("2024-02-05 13:11:34", formatter);
//        review.setReviewDate(dateTime);
//        return Set.of(review);
//    }

    public static Order returnOrder(){
        Order order = new Order();
        order.setOId(UUID.fromString("4eab43a7-0385-48f3-bfd3-4529a2bcfd51"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse("2024-02-26 07:11:49", formatter);
        order.setOrderDate(dateTime);
        return order;
    }

    public static Set<Order> returnAllOrders(){
        Order order1 = returnOrder();

        Order order2 = new Order();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        order2.setOId(UUID.fromString("6b4e8a7c-0f64-4fd8-a37f-5c0a072d14a2"));
        LocalDateTime dateTime2 = LocalDateTime.parse("2024-02-10 17:11:49", formatter);
        order2.setOrderDate(dateTime2);

        Order order3 = new Order();
        order3.setOId(UUID.fromString("97bea184-3e06-4f63-9c94-ec65f00c823d"));
        LocalDateTime dateTime3 = LocalDateTime.parse("2024-02-02 16:10:49", formatter);
        order3.setOrderDate(dateTime3);

        Order order4 = new Order();
        order4.setOId(UUID.fromString("b0e6d30d-0e4d-4694-b7f3-3d40c788b2b1"));
        LocalDateTime dateTime4 = LocalDateTime.parse("2023-11-21 13:20:49", formatter);
        order4.setOrderDate(dateTime4);

        Order order5 = new Order();
        order5.setOId(UUID.fromString("ed0285f4-4524-40f8-bcf5-6cb23b7f81dc"));
        LocalDateTime dateTime5 = LocalDateTime.parse("2024-03-05 07:11:49", formatter);
        order5.setOrderDate(dateTime5);

        Order order6 = new Order();
        order6.setOId(UUID.fromString("ed0285f4-4524-40f8-bcf5-6cb23b712345"));
        LocalDateTime dateTime6 = LocalDateTime.parse("2024-02-05 07:11:49", formatter);
        order6.setOrderDate(dateTime6);

        Order order7 = new Order();
        order7.setOId(UUID.fromString("ed0285f4-4524-40f8-bcf5-6cb23b712346"));
        LocalDateTime dateTime7 = LocalDateTime.parse("2024-02-05 07:11:49", formatter);
        order7.setOrderDate(dateTime7);

        Order order8 = new Order();
        order8.setOId(UUID.fromString("ed0285f4-4524-40f8-bcf5-6cb23b712347"));
        LocalDateTime dateTime8 = LocalDateTime.parse("2024-02-05 07:11:49", formatter);
        order8.setOrderDate(dateTime8);

        Order order9 = new Order();
        order9.setOId(UUID.fromString("ed0285f4-4524-40f8-bcf5-6cb23b712348"));
        LocalDateTime dateTime9 = LocalDateTime.parse("2024-02-09 07:11:49", formatter);
        order9.setOrderDate(dateTime9);

        return Set.of(order1, order2, order3, order4, order5, order6, order7, order8, order9);
    }

    public static User returnUser(){
        User user = new User();
        user.setUID(UUID.fromString("1b4a432d-1ec9-4141-ace1-1d6ed2e3de0f"));
        user.setFirstName("Julija");
        user.setLastName("Klimenko");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse("2024-01-07 12:20:49", formatter);
        user.setCreatedAt(dateTime);
        user.setCountry(Country.GERMANY);

        UserInfo userInfo = new UserInfo();
        userInfo.setUID(UUID.fromString("c9fb87a6-b0ff-457b-a646-6b4a2a107396"));
        userInfo.setUserName("julija_klimenko");
        userInfo.setAddress("Rosenweg 7");
        userInfo.setCity(City.DRESDEN);
        userInfo.setPostalCode("32546");
        userInfo.setEmail("klim@gmail.com");
        userInfo.setPassword("765000!fdbvytr");
        userInfo.setCardNumber("3463 8895 2271 479");
        user.setUserInfo(userInfo);

        Role role1 = new Role();
        role1.setRId(UUID.fromString("e8e47c95-84bb-4262-819f-7eace92d5b7b"));
        role1.setRoleName("customer");
        Set<Role> roleSet = Set.of(role1);
        userInfo.setRoles(roleSet);

        Authority authority1 = new Authority();
        authority1.setAId(UUID.fromString("1a10d548-3cf1-4c7c-9823-5e30cf273ad4"));
        authority1.setAuthorityName("Update customer profile");

        Authority authority2 = new Authority();
        authority2.setAId(UUID.fromString("a6d7c833-0fbf-4bdc-b07c-b3bbd3d8d708"));
        authority2.setAuthorityName("Place order");

        Authority authority3 = new Authority();
        authority3.setAId(UUID.fromString("b30fdaec-15f4-4df4-a2d4-cd4907f94a9a"));
        authority3.setAuthorityName("Create customer profile");

        Authority authority4 = new Authority();
        authority4.setAId(UUID.fromString("ff6b1bc1-1d0c-4f0f-b3e7-8be9ae76b986"));
        authority4.setAuthorityName("View own orders");

        Set<Authority> authoritySet = Set.of(authority1, authority2, authority3, authority4);
        role1.setAuthorities(authoritySet);

        return user;
    }

    public static PromoCode returnPromo(){
        PromoCode promoCode = new PromoCode();
        promoCode.setPcId(UUID.fromString("62ae2a48-8c85-4f2e-b7d8-91b374c94585"));
        promoCode.setPromoName("Spring Surprise");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        promoCode.setStartPromoDate(LocalDateTime.parse("2023-03-01 00:00:00", formatter));
        promoCode.setEndPromoDate(LocalDateTime.parse("2025-03-31 23:59:59", formatter));
        return promoCode;
    }

    public static Set<PromoCode> returnAllPromoCodes(){
        PromoCode promoCode = returnPromo();
        PromoCode promoCode2 = new PromoCode();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        promoCode2.setPcId(UUID.fromString("f83d13cc-4203-4a08-a03d-30a971d87e19"));
        promoCode2.setPromoName("Black Friday");
        promoCode2.setStartPromoDate(LocalDateTime.parse("2023-11-15 00:00:00", formatter));
        promoCode2.setEndPromoDate(LocalDateTime.parse("2023-11-30 23:59:59", formatter));
        PromoCode promoCode3 = new PromoCode();
        promoCode3.setPcId(UUID.fromString("62ae2a48-8c85-4f2e-b7d8-91b374c94555"));
        promoCode3.setPromoName("Smile");
        promoCode3.setStartPromoDate(LocalDateTime.parse("2024-03-01 00:00:00", formatter));
        promoCode3.setEndPromoDate(LocalDateTime.parse("2025-05-31 23:59:59", formatter));
        return Set.of(promoCode, promoCode2, promoCode3);
    }

    public static Review returnReview(){
        Review review = new Review();
        review.setRvId(UUID.fromString("a1d891b2-d78d-4bb5-907b-ecf6437e40af"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        review.setReviewDate(LocalDateTime.parse("2023-11-25 17:11:49", formatter));
        review.setReviewTitle("Good choice for a child");
        return review;
    }

    public static List<UserDto> returnReport(){
        UserDto userDto1 = new UserDto();
        userDto1.setUserId("37e91890-cf71-4376-9bc9-8b4d94b11254");
        userDto1.setFirstName("Tatiana");
        userDto1.setLastName("Kurilenko");
        userDto1.setSum("49.79");

        UserDto userDto2 = new UserDto();
        userDto2.setUserId("1b4a432d-1ec9-4141-ace1-1d6ed2e3de0f");
        userDto2.setFirstName("Julija");
        userDto2.setLastName("Klimenko");
        userDto2.setSum("22.70");

        UserDto userDto3 = new UserDto();
        userDto3.setUserId("b3cf89da-79d2-42f8-8f4d-fcb22aa43f96");
        userDto3.setFirstName("Ivan");
        userDto3.setLastName("Ivanov");
        userDto3.setSum("22.40");

        return List.of(userDto1, userDto2, userDto3);
    }

    public static UserBeforeCreatingDto returnUserBeforeCreatingDto(){
        UserBeforeCreatingDto userBeforeCreatingDto = new UserBeforeCreatingDto();
        userBeforeCreatingDto.setAddress("Main Street, 35");
        userBeforeCreatingDto.setCity("LYON");
        userBeforeCreatingDto.setEmail("vasvas@gmail.com");
        userBeforeCreatingDto.setCardNumber("12345677788990009888");
        userBeforeCreatingDto.setCountry("FRANCE");
        userBeforeCreatingDto.setPassword("7654");
        userBeforeCreatingDto.setFirstName("Vasiliy");
        userBeforeCreatingDto.setUserName("Vasia");
        userBeforeCreatingDto.setLastName("Vasiliev");
        userBeforeCreatingDto.setPostalCode("12344");
        return userBeforeCreatingDto;
    }
}
