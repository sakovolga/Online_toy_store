package com.example.online_toy_store.controller;

import com.example.online_toy_store.entity.Order;
import com.example.online_toy_store.service.interf.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/showOrder/{id}")
    public Order showOrderById(@PathVariable(name = "id") String id){
        return orderService.showOrder(id);
    }

//    @PostMapping("/new/{clientId}")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Order createOrder(@PathVariable(name = "id") String id)

}
