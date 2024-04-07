package com.example.online_toy_store.controller;
import com.example.online_toy_store.entity.Review;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Sql("/drop-tables.sql")
@Sql("/create-tables.sql")
@Sql("/insert_test_data.sql")
public class ReviewControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void showReviewByIdPositiveTest() throws Exception {

        Review expectedReview = ExpectedData.returnReview();

        MvcResult mvcResult =
                mockMvc.perform(MockMvcRequestBuilders
                                .get("/review/showReview/a1d891b2-d78d-4bb5-907b-ecf6437e40af"))
                        .andExpect(status().isOk())
                        .andReturn();

        String actualReviewJSON = mvcResult.getResponse().getContentAsString();

        Review actualReview = objectMapper.readValue(actualReviewJSON, Review.class);

        Assertions.assertEquals(expectedReview, actualReview);
    }

    @Test
    void showReviewByIdTestWithException() throws Exception {

        String nonExistentID = "4eab43a7-0385-48f3-bfd3-4529a2bcfd52";

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/review/showReview/{orderId}", nonExistentID))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string("Review does not exist"));
    }
}
