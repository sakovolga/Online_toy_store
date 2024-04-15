package com.example.online_toy_store.mapper;

import com.example.online_toy_store.dto.OrderDetailDto;
import com.example.online_toy_store.entity.OrderDetail;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

import java.util.Set;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
@Component
public interface OrderDetailMapper {
    @Named("mapToEntity")
    Set<OrderDetail> mapToEntity(Set<OrderDetailDto> orderDetailDtoSet);


    default OrderDetail mapToEntity(OrderDetailDto orderDetailDto){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setQuantity(Integer.parseInt(orderDetailDto.getQuantity()));
        orderDetail.setOrderComment(orderDetailDto.getOrderComment());
        return orderDetail;
    }


}
