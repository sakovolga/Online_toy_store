package com.example.online_toy_store.controller;

import com.example.online_toy_store.entity.Order;
import com.example.online_toy_store.entity.Product;
import com.example.online_toy_store.entity.enums.OrderStatus;
import com.example.online_toy_store.utils.ExpectedData;
import com.example.online_toy_store.utils.Utils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Sql("/drop-tables.sql")
@Sql("/create-tables.sql")
@Sql("/insert_test_data.sql")
class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void showOrderByIdPositiveTest() throws Exception {

        Order expectedOrder = ExpectedData.returnOrder();

        MvcResult mvcResult =
                mockMvc.perform(MockMvcRequestBuilders
                                .get("/order/showOrder/4eab43a7-0385-48f3-bfd3-4529a2bcfd51"))
                        .andExpect(status().isOk())
                        .andReturn();

        String actualOrderJSON = mvcResult.getResponse().getContentAsString();

        Order actualOrder = objectMapper.readValue(actualOrderJSON, Order.class);

        Assertions.assertEquals(expectedOrder, actualOrder);
    }

    @Test
    void showOrderByIdTestWithException() throws Exception {

        String nonExistentID = "4eab43a7-0385-48f3-bfd3-4529a2bcfd52";

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/order/showOrder/{orderId}", nonExistentID))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{\"message\":\"UNSUCCESSFULLY: order does not exist\",\"statusCode\":404}"));
    }

    @Test
    void showOrderByIdTestWithFailedValidation() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/order/showOrder/invalidID"))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content()
                        .json("{\"message\":\"!!! IT IS NOT [UUID] FORMAT\",\"statusCode\":400}"));
    }

    @Test
    void showAllOrdersTest() throws Exception {

        Set<Order> expectedOrderSet = ExpectedData.returnAllOrders();

        Set<Order> actualOrderSet = showAll();
        Assertions.assertEquals(expectedOrderSet, actualOrderSet);
    }

    @Test
    void createOrderTest() throws Exception {

        Order order = new Order();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse("2024-02-28 07:11:49", formatter);
        order.setOrderDate(dateTime);
        order.setOrderStatus(OrderStatus.DELIVERED);

        String json = objectMapper.writeValueAsString(order);

        Set<Order> orderSetBefore = showAll();

        mockMvc.perform(MockMvcRequestBuilders.post("/order/new")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andReturn();

        Set<Order> orderSetBAfter = showAll();

        Assertions.assertEquals(orderSetBefore.size() + 1, orderSetBAfter.size());
    }

    @Test
    void deleteOrderTestPositive() throws Exception {

        Set<Order> orderSetBefore = showAll();

        mockMvc.perform(MockMvcRequestBuilders.delete("/order/delete/6b4e8a7c-0f64-4fd8-a37f-5c0a072d14a2"));

        Set<Order> orderSetBAfter = showAll();

        Assertions.assertEquals(orderSetBefore.size() - 1, orderSetBAfter.size());

    }

    @Test
    void deleteOrderTestWithException() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.delete("/order/delete/6b4e8a7c-0f64-4fd8-a37f-5c0a072d14a3"))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{\"message\":\"UNSUCCESSFULLY: order does not exist\",\"statusCode\":404}"))
                .andReturn();
    }

    @Test
    void createOrderDtoPositiveTest() throws Exception {
        String json = "{\n" +
                "    \"userId\" : \"184bc3b1-6806-4924-924d-6a66b6bf91df\",\n" +
                "    \"promoName\" : \"Smile\",\n" +
                "    \"orderDetailsDto\" : [\n" +
                "        { \n" +
                "            \"productId\" : \"3b287f30-6c1c-4e71-b7bf-881e2d7b3cb4\",          \n" +
                "            \"quantity\" : \"2\",\n" +
                "            \"orderComment\" : \"I would like to get one pink car and one black car\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"productId\" : \"9ac0037b-2a2d-4c26-9b8c-15e720f0f8db\",            \n" +
                "            \"quantity\" : \"1\",\n" +
                "            \"orderComment\" : \"Please package it nicely because it is a gift\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";

        Set<Order> orderSetBefore = showAll();

        mockMvc.perform(MockMvcRequestBuilders.post("/order/dto/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json));

        Set<Order> orderSetAfter = showAll();

        Assertions.assertEquals(orderSetBefore.size(), orderSetAfter.size() - 1);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "testdata/orderIncorrectQuantityOfProduct.json",
            "testdata/orderInvalidProductId.json",
            "testdata/orderInvalidPromoDate.json",
            "testdata/orderInvalidUserId.json"
    })
    void createOrderDtoWithException400Test(String filePath) throws Exception{
        String json = Utils.loadJsonFromFile(filePath);

        mockMvc.perform(MockMvcRequestBuilders.post("/order/dto/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "testdata/orderInvalidPromoName.json"
    })
    void createOrderDtoWithException404Test(String filePath) throws Exception{
        String json = Utils.loadJsonFromFile(filePath);

        mockMvc.perform(MockMvcRequestBuilders.post("/order/dto/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    Set<Order> showAll() throws Exception {
        MvcResult showAllOrders =
                mockMvc
                        .perform(MockMvcRequestBuilders.get("/order/showAllOrders"))
                        .andExpect(status().isOk())
                        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                        .andReturn();

        String ordersResultJSON = showAllOrders.getResponse().getContentAsString();
        return objectMapper.readValue(ordersResultJSON, new TypeReference<Set<Order>>() {
        });
    }
}