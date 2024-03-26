package com.example.online_toy_store.controller;

import com.example.online_toy_store.entity.Product;
import com.example.online_toy_store.entity.Review;
import com.example.online_toy_store.entity.Supplier;
import com.example.online_toy_store.entity.User;
import com.example.online_toy_store.utils.ReturnData;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
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

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Sql("/create-tables.sql")
@Sql("/insert_test_data.sql")
@Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:drop-tables.sql")
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void showProductTestPositive() throws Exception{
        Product expectedProduct = ReturnData.returnProduct();
        Supplier expectedSupplier = ReturnData.returnSupplier();
        Set<Review> expectedReviewSet = ReturnData.returnReviewSet();

        MvcResult showProductResult =
                mockMvc
                        .perform(MockMvcRequestBuilders.get("/product/showProduct/3b287f30-6c1c-4e71-b7bf-881e2d7b3cb4"))
                        .andExpect(status().isOk())
                        .andReturn();

        String productResultJSON = showProductResult.getResponse().getContentAsString();
        Product actualProduct = objectMapper.readValue(productResultJSON, Product.class);

        Assertions.assertEquals(expectedProduct, actualProduct);
        Assertions.assertEquals(expectedSupplier, actualProduct.getSupplier());
        Assertions.assertEquals(expectedReviewSet, actualProduct.getProductReviews());
    }

    @Test
    void showAllProductsPositiveTest () throws Exception{
        List<Product> expectedProductSet = ReturnData.returnAllProducts();

        MvcResult showAllProductsResult =
                mockMvc
                        .perform(MockMvcRequestBuilders.get("/product/showAllProducts"))
                        .andExpect(status().isOk())
                        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                        .andReturn();

        String productsResultJSON = showAllProductsResult.getResponse().getContentAsString();
        List<Product> actualProductSet = objectMapper.readValue(productsResultJSON, new TypeReference<List<Product>>() {});
        Assertions.assertTrue(expectedProductSet.size() == actualProductSet.size() && actualProductSet.containsAll(expectedProductSet));
    }

}
