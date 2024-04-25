package com.example.online_toy_store.mapper;

import com.example.online_toy_store.dto.ProductAfterCreatingDto;
import com.example.online_toy_store.dto.ProductBeforeCreatingDto;
import com.example.online_toy_store.entity.Product;
import com.example.online_toy_store.entity.Supplier;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
@Component
public interface CreateProductDtoMapper {

    @Mappings({
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "description", source = "description"),
            @Mapping(target = "price", source = "price"),
            @Mapping(target = "availableQuantity", source = "availableQuantity"),
            @Mapping(target = "category", source = "category"),
            @Mapping(target = "PId", ignore = true),
            @Mapping(target = "supplier", ignore = true),
            @Mapping(target = "orderDetails", ignore = true),
            @Mapping(target = "productReviews", ignore = true),
            @Mapping(target = "available", source = "isAvailable")
    })
    Product toEntity(ProductBeforeCreatingDto productBeforeCreatingDto);

    @Mappings({
            @Mapping(target = "supplierName", source = "supplierName"),
            @Mapping(target = "phone", source = "phone"),
            @Mapping(target = "email", source = "email"),
            @Mapping(target = "address", source = "address"),
            @Mapping(target = "city", source = "city"),
            @Mapping(target = "postalCode", source = "postal_code"),
            @Mapping(target = "country", source = "country"),
            @Mapping(target = "products", ignore = true)
    })
    Supplier toSupplier(ProductBeforeCreatingDto productBeforeCreatingDto);

    @Mappings({
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "description", source = "description"),
            @Mapping(target = "price", source = "price"),
            @Mapping(target = "availableQuantity", source = "availableQuantity"),
            @Mapping(target = "category", source = "category"),
            @Mapping(target = "supplierId", source = "supplier.SId"),
            @Mapping(target = "supplierName", source = "supplier.supplierName"),
            @Mapping(target = "phone", source = "supplier.phone"),
            @Mapping(target = "country", source = "supplier.country"),
            @Mapping(target = "isAvailable", source = "available")
    })
    ProductAfterCreatingDto toDto(Product product);
}
