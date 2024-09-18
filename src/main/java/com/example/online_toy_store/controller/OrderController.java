package com.example.online_toy_store.controller;

import com.example.online_toy_store.annotation.*;
import com.example.online_toy_store.dto.OrderDtoAfter;
import com.example.online_toy_store.dto.OrderDtoBefore;
import com.example.online_toy_store.entity.Order;
import com.example.online_toy_store.service.interf.OrderService;
import com.example.online_toy_store.validation.UuidChecker;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetOrderByID(path = "/showOrder/{id}")
    public Order showOrderById(@PathVariable(name = "id") @UuidChecker String id) {
        return orderService.showOrder(id);
    }

    @GetAllOrders(path = "/showAllOrders")
    public List<Order> showAllOrders(HttpServletRequest request) {
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

    private void handleRequest(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies!= null){
            for (Cookie cookie: cookies){
                System.out.println("JSESSIONID: " + cookie.getValue());
            }
        }
    }
}
