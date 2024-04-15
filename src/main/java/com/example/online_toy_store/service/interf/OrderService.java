package com.example.online_toy_store.service.interf;

import com.example.online_toy_store.dto.OrderDtoAfter;
import com.example.online_toy_store.dto.OrderDtoBefore;
import com.example.online_toy_store.entity.Order;

import java.util.List;

public interface OrderService {

    Order showOrder(String id);

    Order createOrder(Order order);

    String deleteOrder(String id);

    List<Order> showAllOrders();

    OrderDtoAfter createOrderDto(OrderDtoBefore orderDtoBefore);
}
