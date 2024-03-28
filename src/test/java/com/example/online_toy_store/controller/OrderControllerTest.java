package com.example.online_toy_store.controller;

import com.example.online_toy_store.entity.Order;
import com.example.online_toy_store.entity.Product;
import com.example.online_toy_store.entity.enums.OrderStatus;
import com.example.online_toy_store.utils.ReturnData;
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

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
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
    void showAllOrdersTest () throws Exception{

        Set<Order> expectedOrderSet = ReturnData.returnAllOrders();

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

        MvcResult createAuthorResult = mockMvc
                .perform(MockMvcRequestBuilders.post("/order/new")
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

    Set<Order> showAll() throws Exception {
        MvcResult showAllOrdersBefore =
                mockMvc
                        .perform(MockMvcRequestBuilders.get("/order/showAllOrders"))
                        .andExpect(status().isOk())
                        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                        .andReturn();

        String ordersResultJSON = showAllOrdersBefore.getResponse().getContentAsString();
        return objectMapper.readValue(ordersResultJSON, new TypeReference<Set<Order>>() {});
    }
}