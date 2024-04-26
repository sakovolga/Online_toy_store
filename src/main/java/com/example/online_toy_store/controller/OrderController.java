package com.example.online_toy_store.controller;

import com.example.online_toy_store.annotation.*;
import com.example.online_toy_store.dto.OrderDtoAfter;
import com.example.online_toy_store.dto.OrderDtoBefore;
import com.example.online_toy_store.entity.Order;
import com.example.online_toy_store.service.interf.OrderService;
import com.example.online_toy_store.validation.UuidChecker;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
    public List<Order> showAllOrders(HttpServletRequest request) {
        System.out.println("***********************************************************");

        handleRequest(request);
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();

        Object principal = authentication.getPrincipal();
        if (principal instanceof UserDetails) {
            String username = ((UserDetails) principal).getUsername();
            String password = ((UserDetails) principal).getPassword();
            System.out.println("USERNAME: " + username);
            System.out.println("PASSWORD: " + password);
        }

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
        if(cookies !=null) {
            for (Cookie cookie : cookies) {
                System.out.println("JSESSIONID: " + cookie.getValue());
            }
        }
    }
}
