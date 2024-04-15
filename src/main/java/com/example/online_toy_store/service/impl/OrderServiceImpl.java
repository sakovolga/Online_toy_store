package com.example.online_toy_store.service.impl;

import com.example.online_toy_store.dto.OrderDtoAfter;
import com.example.online_toy_store.dto.OrderDtoBefore;
import com.example.online_toy_store.entity.*;
import com.example.online_toy_store.exception.*;
import com.example.online_toy_store.exception.errorMessage.ErrorMessage;
import com.example.online_toy_store.mapper.CreateOrderDtoMapper;
import com.example.online_toy_store.repository.OrderRepository;
import com.example.online_toy_store.repository.ProductRepository;
import com.example.online_toy_store.repository.PromoCodeRepository;
import com.example.online_toy_store.repository.UserRepository;
import com.example.online_toy_store.service.interf.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CreateOrderDtoMapper createOrderDtoMapper;
    private final PromoCodeRepository promoCodeRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    @Override
    @Transactional
    public Order showOrder(String id) {
        return orderRepository.findById
                        (UUID.fromString(id))
                .orElseThrow(() -> new OrderDoesNotExistException(ErrorMessage.ORDER_DOES_NOT_EXIST));
    }

    @Override
    @Transactional
    public Order createOrder(Order order) {
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

    @Override
    @Transactional
    public OrderDtoAfter createOrderDto(OrderDtoBefore orderDtoBefore) {
        Order order = createOrderDtoMapper.toEntity(orderDtoBefore);

        Order orderAfterSaving = orderRepository.saveAndFlush(order);

        for (OrderDetail od : orderAfterSaving.getOrderDetails()) {
            od.setOrder(orderAfterSaving);
            Optional<Product> product = productRepository.findById(od.getProduct().getPId());
            Product changedProduct = product.orElse(null);
            if (changedProduct != null){
                int availableQuantity = changedProduct.getAvailableQuantity() - od.getQuantity();
                if (availableQuantity < 0) throw new ProductsAreOutException
                        ("Less than " + od.getQuantity() + " items left: " + changedProduct.getName());
                else changedProduct.setAvailableQuantity(availableQuantity);
                if (availableQuantity == 0) changedProduct.setAvailable(false);
            }
            od.setProduct(product.orElse(null));
        }
        PromoCode promoCode = promoCodeRepository.findPromoCodeByPromoName(orderDtoBefore.getPromoName());
        if (promoCode != null){
            int unusedQuantity = promoCode.getUnusedQuantity() - 1;
            promoCode.setUnusedQuantity(unusedQuantity);
            if (unusedQuantity < 0) throw new PromoCodeAreOutException
                    ("All available units of promo code " + promoCode.getPromoName() + " have been used");
            if (orderAfterSaving.getOrderDate().isBefore(promoCode.getStartPromoDate()) ||
                    orderAfterSaving.getOrderDate().isAfter(promoCode.getEndPromoDate()))
                throw new PromoCodeAreOutException("Invalid promotional code expiration date");
            orderAfterSaving.setPromoCode(promoCode);
        } else throw new PromoCodeDoesNotExistException("There is no promotional code with this name");
        Optional<User> user = userRepository.findById(UUID.fromString(orderDtoBefore.getUserId()));
        orderAfterSaving.setUser(user.orElse(null));
        return createOrderDtoMapper.toDto(orderAfterSaving);
    }

}
