package com.example.online_toy_store.controller;

import com.example.online_toy_store.entity.PromoCode;
import com.example.online_toy_store.utils.ExpectedData;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.List;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Sql("/drop-tables.sql")
@Sql("/create-tables.sql")
@Sql("/insert_test_data.sql")
class PromoCodeControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    void showPromoCodeByNamePositiveTest() throws Exception {
        PromoCode expectedPromoCode = ExpectedData.returnPromo();

        MvcResult mvcResult = mockMvc
                .perform(MockMvcRequestBuilders.get("/promo/showByName/Spring Surprise"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        String actualPromoCodeJSON = mvcResult.getResponse().getContentAsString();
        PromoCode actualPromoCode = objectMapper.readValue(actualPromoCodeJSON, PromoCode.class);

        Assertions.assertEquals(expectedPromoCode, actualPromoCode);
    }

    @Test
    void showPromoCodeByNameTestWithException() throws Exception{

        mockMvc.perform(MockMvcRequestBuilders.get("/promo/showByName/Non-existent name"))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{\"message\":\"Non-existent name promo code not found\",\"statusCode\":404}"));
    }

    @Test
    void createPromoCodePositiveTest() throws Exception{

        String promoCodeJSON = "{\n" +
                "    \"promoName\" : \"Hot summer discounts\",\n" +
                "    \"discountAmount\" : 15.5,\n" +
                "    \"startPromoDate\" : \"2024-08-20T00:00:00\",\n" +
                "    \"endPromoDate\" : \"2024-08-31T00:00:00\",\n" +
                "    \"amountOfUsers\" : 50,\n" +
                "    \"unusedQuantity\" : 50\n" +
                "}";

        List<PromoCode> promoCodeListBefore = showAll();

        mockMvc.perform(MockMvcRequestBuilders.post("/promo/new")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(promoCodeJSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        List<PromoCode> promoCodeListAfter = showAll();

        Assertions.assertEquals(promoCodeListBefore.size() + 1, promoCodeListAfter.size());
    }

    @Test
    void createPromoCodeTestWithException() throws Exception{
        String promoCodeJSON = "{\n" +
                "    \"promoName\" : \"Spring Surprise\",\n" +
                "    \"discountAmount\" : 15.5,\n" +
                "    \"startPromoDate\" : \"2024-08-20T00:00:00\",\n" +
                "    \"endPromoDate\" : \"2024-08-31T00:00:00\",\n" +
                "    \"amountOfUsers\" : 50,\n" +
                "    \"unusedQuantity\" : 50\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders.post("/promo/new")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(promoCodeJSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{\"message\":\"The promo code already exist\",\"statusCode\":400}"));;
    }

    @Test
    void showAllPromoCodesPositiveTest() throws Exception{

        List<PromoCode> expectedPromoCodeList = ExpectedData.returnAllPromoCodes();

        List<PromoCode> actualPromoCodeList = showAll();

        Assertions.assertTrue(expectedPromoCodeList.size() == actualPromoCodeList.size() &&
                expectedPromoCodeList.containsAll(actualPromoCodeList));
    }

    @Test
    void deletePromoCodeByNamePositiveTest() throws Exception{

        String promoCodeJSON = "{\n" +
                "    \"promoName\" : \"Hot summer discounts\",\n" +
                "    \"discountAmount\" : 15.5,\n" +
                "    \"startPromoDate\" : \"2024-08-20T00:00:00\",\n" +
                "    \"endPromoDate\" : \"2024-08-31T00:00:00\",\n" +
                "    \"amountOfUsers\" : 50,\n" +
                "    \"unusedQuantity\" : 50\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders.post("/promo/new")
                .contentType(MediaType.APPLICATION_JSON)
                .content(promoCodeJSON));

        List<PromoCode> promoCodeListBefore = showAll();

        mockMvc.perform(MockMvcRequestBuilders.delete("/promo/delete/Hot summer discounts"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hot summer discounts promo code SUCCESSFULLY removed"));

        List<PromoCode> promoCodeListAfter = showAll();

        Assertions.assertEquals(promoCodeListBefore.size() - 1, promoCodeListAfter.size());
    }


    //Нельзя удалить, потому что не существует
    @Test
    void deletePromoCodeByNameTestWithException() throws Exception{

        mockMvc.perform(MockMvcRequestBuilders.delete("/promo/delete/Non-existing promo code name"))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{\"message\":\"Non-existing promo code name promo code not found\",\"statusCode\":404}"));
    }

    //Нельзя удалить, потому что на него ссылается другой обект
    @Test
    void deletePromoCodeByNameTestWithDataIntegrityViolationException() throws Exception{

        mockMvc.perform(MockMvcRequestBuilders.delete("/promo/delete/Spring Surprise"))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(containsString("CONSTRAINT_8B7: PUBLIC.ORDERS FOREIGN KEY(PROMO_CODE_ID) REFERENCES")));
    }

    @Test
    void showAllPromoCodesByDiscountPositiveTest() throws Exception{

        List<PromoCode> expectedPromoCodeList = List.of(ExpectedData.returnPromo());

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/promo/showAllByDiscount/30"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        String promoCodeListJSON = mvcResult.getResponse().getContentAsString();
        List<PromoCode> actualPromoCodeList = objectMapper
                .readValue(promoCodeListJSON, new TypeReference<List<PromoCode>>() {});

        Assertions.assertTrue(expectedPromoCodeList.size() == actualPromoCodeList.size() &&
                expectedPromoCodeList.containsAll(actualPromoCodeList));
    }

    @Test
    void showAllPromoCodesByDiscountTestWithException() throws Exception{

        mockMvc.perform(MockMvcRequestBuilders.get("/promo/showAllByDiscount/40"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content()
                        .json("{\"message\":\"The list of promo codes is empty\",\"statusCode\":200}"));
    }

    List<PromoCode> showAll () throws Exception{

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/promo/showAll"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        String promoCodeListJSON = mvcResult.getResponse().getContentAsString();
        return objectMapper.readValue(promoCodeListJSON, new TypeReference<List<PromoCode>>() {});
    }
}