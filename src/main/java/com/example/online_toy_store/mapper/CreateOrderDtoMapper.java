package com.example.online_toy_store.mapper;

import com.example.online_toy_store.dto.OrderDetailDto;
import com.example.online_toy_store.dto.OrderDetailDtoAfter;
import com.example.online_toy_store.dto.OrderDtoAfter;
import com.example.online_toy_store.dto.OrderDtoBefore;
import com.example.online_toy_store.entity.*;
import com.example.online_toy_store.entity.enums.OrderStatus;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
@Component
public interface CreateOrderDtoMapper {
    @Mappings({
            @Mapping(target = "OId", ignore = true),
            @Mapping(target = "orderDate", ignore = true),
            @Mapping(target = "orderStatus", ignore = true),
            @Mapping(target = "user", ignore = true),
            @Mapping(target = "promoCode", ignore = true),
            @Mapping(target = "orderDetails", source = "orderDetailsDto")
    })
    Order toEntity(OrderDtoBefore orderDtoBefore);

    default Set<OrderDetail> mapToOrderDetails(OrderDtoBefore orderDtoBefore) {
        return orderDtoBefore.getOrderDetailsDto().stream()
                .map(this::mapToOrderDetail)
                .collect(Collectors.toSet());
    }

    default OrderDetail mapToOrderDetail(OrderDetailDto orderDetailDto){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderComment(orderDetailDto.getOrderComment());
        orderDetail.setQuantity(Integer.parseInt(orderDetailDto.getQuantity()));
        Product product = new Product();
        product.setPId(UUID.fromString(orderDetailDto.getProductId()));
        orderDetail.setProduct(product);
        return orderDetail;
    }

    @AfterMapping
    default void generateOrderInfo(@MappingTarget Order order, OrderDtoBefore orderDtoBefore){
        order.setOrderDate(LocalDateTime.now());
        order.setOrderStatus(OrderStatus.PROCESSING);
        order.setOrderDetails(mapToOrderDetails(orderDtoBefore));
        User user = new User();
        user.setUID(UUID.fromString(orderDtoBefore.getUserId()));
        order.setUser(user);
    }

    @Mappings({
            @Mapping(target = "orderDate", source = "orderDate"),
            @Mapping(target = "orderStatus", source = "orderStatus"),
    })
    OrderDtoAfter toDto(Order order);

    @AfterMapping
    default void generateOrderAnswer(@MappingTarget OrderDtoAfter orderDtoAfter, Order order){
        orderDtoAfter.setAnswer("Congratulations, " + order.getUser().getFirstName() +
                ", your order has been successfully created!!");
        orderDtoAfter.setDiscount(String.valueOf(order.getPromoCode().getDiscountAmount()));
        orderDtoAfter.setOrderDetails(mapToOrderDetailsDtoAfter(order));
        orderDtoAfter.setOrderCost(String.valueOf(calculateCost(order).setScale(2, RoundingMode.HALF_UP)));
        orderDtoAfter.setDiscountedOrderCost(String
                .valueOf(calculateDiscountedCost(order).setScale(2, RoundingMode.HALF_UP)));
    }

    default Set<OrderDetailDtoAfter> mapToOrderDetailsDtoAfter(Order order) {
        return order.getOrderDetails().stream()
                .map(this::mapToOrderDetailDtoAfter)
                .collect(Collectors.toSet());
    }

    default OrderDetailDtoAfter mapToOrderDetailDtoAfter(OrderDetail orderDetail){
        OrderDetailDtoAfter orderDetailDtoAfter = new OrderDetailDtoAfter();
        orderDetailDtoAfter.setProductName(orderDetail.getProduct().getName());
        orderDetailDtoAfter.setPrice(String.valueOf(orderDetail.getProduct().getPrice()));
        orderDetailDtoAfter.setQuantity(String.valueOf(orderDetail.getQuantity()));
        orderDetailDtoAfter.setComment(orderDetail.getOrderComment());
        return orderDetailDtoAfter;
    }

    default BigDecimal calculateCost(Order order){
        return order.getOrderDetails().stream()
                .map(e -> e.getProduct().getPrice().multiply(BigDecimal.valueOf(e.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    default BigDecimal calculateDiscountedCost(Order order){
        return BigDecimal.valueOf(1 - order.getPromoCode().getDiscountAmount()/100).multiply(calculateCost(order));
    }

}
