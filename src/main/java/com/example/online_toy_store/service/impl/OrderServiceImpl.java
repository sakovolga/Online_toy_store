package com.example.online_toy_store.service.impl;

import com.example.online_toy_store.entity.Order;
import com.example.online_toy_store.exception.OrderDoesNotExistException;
import com.example.online_toy_store.exception.errorMessage.ErrorMessage;
import com.example.online_toy_store.repository.OrderRepository;
import com.example.online_toy_store.service.interf.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    @Override
    @Transactional
    public Order showOrder(String id) {
        return orderRepository.findById
                        (UUID.fromString(id))
                .orElseThrow(() -> new OrderDoesNotExistException(ErrorMessage.ORDER_DOES_NOT_EXIST));
    }

    @Override
    @Transactional
    public Order createOrder(Order order){
        return orderRepository.saveAndFlush(order);
    }

    @Override
    @Transactional
    public String deleteOrder(String id) {
        Optional<Order> optionalOrder = orderRepository.findById(UUID.fromString(id));
        if (optionalOrder.isEmpty()) throw new OrderDoesNotExistException(ErrorMessage.ORDER_DOES_NOT_EXIST);
        else orderRepository.deleteById(UUID.fromString(id));
        return "Order with this UUID was deleted SUCCESSFULLY";
    }

    @Override
    @Transactional
    public List<Order> showAllOrders() {
        return orderRepository.findAll();
    }
}
