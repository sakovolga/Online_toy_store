package com.example.online_toy_store.controller;

import com.example.online_toy_store.entity.Order;
import com.example.online_toy_store.exception.TheOrderAlreadyExistsException;
import com.example.online_toy_store.service.interf.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/showOrder/{id}")
    public Order showOrderById(@PathVariable(name = "id") String id){
        return orderService.showOrder(id);
    }

    @GetMapping("/showAllOrders")
    public List<Order> showAllOrders(){
        return orderService.showAllOrders();
    }



    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
//    @ResponseStatus(HttpStatus.CREATED)
    public Order createOrder(@RequestBody Order order) {
//        try {
//            return orderService.createOrder(order);
//        } catch (TheOrderAlreadyExistsException e) {
//            throw new RuntimeException(e);
//        }
        return orderService.createOrder(order);
    }
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    private void deleteOrder(@PathVariable(name = "id") String id){
        orderService.deleteOrder(id);
    }

}
