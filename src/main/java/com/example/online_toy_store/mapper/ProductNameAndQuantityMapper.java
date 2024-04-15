package com.example.online_toy_store.mapper;

import com.example.online_toy_store.dto.ProductNameAndQuantityDto;
import com.example.online_toy_store.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductNameAndQuantityMapper {

    ProductNameAndQuantityDto toDto(Product product);
}
