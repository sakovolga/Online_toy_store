package com.example.online_toy_store.controller;

import com.example.online_toy_store.annotation.*;
import com.example.online_toy_store.dto.OrderDtoAfter;
import com.example.online_toy_store.dto.OrderDtoBefore;
import com.example.online_toy_store.entity.Order;
import com.example.online_toy_store.service.interf.OrderService;
import com.example.online_toy_store.validation.UuidChecker;
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

    @GetOrderByID(path = "/showOrder/{id}")
    public Order showOrderById(@PathVariable(name = "id") @UuidChecker String id) {
        return orderService.showOrder(id);
    }

    @GetAllOrders(path = "/showAllOrders")
    public List<Order> showAllOrders() {
        return orderService.showAllOrders();
    }

    @CreateOrder(path = "/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @DeleteOrder(path = "/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteOrder(@PathVariable(name = "id") String id) {
        return orderService.deleteOrder(id);
    }

    @CreateOrderDto(path = "/dto/create")
    public OrderDtoAfter createOrderDto(@RequestBody OrderDtoBefore orderDtoBefore) {
    return orderService.createOrderDto(orderDtoBefore);
    }
}
