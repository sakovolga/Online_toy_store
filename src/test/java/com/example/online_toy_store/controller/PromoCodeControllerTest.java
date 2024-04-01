package com.example.online_toy_store.controller;

import com.example.online_toy_store.entity.PromoCode;
import com.example.online_toy_store.utils.ExpectedData;
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

import static org.junit.jupiter.api.Assertions.*;
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
                .andExpect(content().string("Non-existent name promo code not found"));
    }

}