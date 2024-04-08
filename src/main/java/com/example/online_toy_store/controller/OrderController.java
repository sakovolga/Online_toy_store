package com.example.online_toy_store.controller;

import com.example.online_toy_store.annotation.*;
import com.example.online_toy_store.entity.Order;
import com.example.online_toy_store.service.interf.OrderService;
import com.example.online_toy_store.validation.UuidChecker;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @CustomGetOrderByID(path = "/showOrder/{id}")
    public Order showOrderById(@PathVariable(name = "id") @UuidChecker String id) {
        return orderService.showOrder(id);
    }

    @CustomGetAllOrders(path = "/showAllOrders")
    public List<Order> showAllOrders() {
        return orderService.showAllOrders();
    }

    @CustomCreateOrder(path = "/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @CustomDeleteOrder(path = "/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteOrder(@PathVariable(name = "id") String id) {
        return orderService.deleteOrder(id);
    }
}
