package com.example.online_toy_store.controller;

import com.example.online_toy_store.entity.Product;
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

import java.util.Set;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Sql("/drop-tables.sql")
@Sql("/create-tables.sql")
@Sql("/insert_test_data.sql")
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void showProductTestPositive() throws Exception{
        Product expectedProduct = ExpectedData.returnProduct();

        MvcResult showProductResult =
                mockMvc
                        .perform(MockMvcRequestBuilders
                                .get("/product/showProduct/3b287f30-6c1c-4e71-b7bf-881e2d7b3cb4"))
                        .andExpect(status().isOk())
                        .andReturn();

        String productResultJSON = showProductResult.getResponse().getContentAsString();
        Product actualProduct = objectMapper.readValue(productResultJSON, Product.class);

        Assertions.assertEquals(expectedProduct, actualProduct);
    }

    @Test
    void showProductWithExceptionTest() throws Exception{
        String nonExistentID = "4eab43a7-0385-48f3-bfd3-4529a2bcfd52";

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/product/showProduct/{id}", nonExistentID))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string("Product does not exist"));
    }

    @Test
    void showProductWithNotValidUUIDTest() throws Exception{
        String invalidUUID = "invalidUUID";

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/product/showProduct/{id}", invalidUUID))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string("Invalid UUID string: invalidUUID"));
    }

    @Test
    void showAllProductsTest () throws Exception{
        Set<Product> expectedProductSet = ExpectedData.returnAllProducts();

        MvcResult showAllProductsResult =
                mockMvc
                        .perform(MockMvcRequestBuilders.get("/product/showAllProducts"))
                        .andExpect(status().isOk())
                        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                        .andReturn();

        String productsResultJSON = showAllProductsResult.getResponse().getContentAsString();
        Set<Product> actualProductSet = objectMapper.readValue(productsResultJSON, new TypeReference<Set<Product>>() {});
        Assertions.assertEquals(actualProductSet, expectedProductSet);
    }
}
