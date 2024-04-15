package com.example.online_toy_store.service.interf;

import com.example.online_toy_store.dto.ProductAfterCreatingDto;
import com.example.online_toy_store.dto.ProductBeforeCreatingDto;
import com.example.online_toy_store.dto.ProductNameAndQuantityDto;
import com.example.online_toy_store.entity.Product;

import java.util.List;
import java.util.Set;

public interface ProductService {

    Product showProduct(String id);

    List<Product> showProducts();

//    ProductNameAndQuantityDto getProductNAQDto(String id);

    ProductAfterCreatingDto createProductDto(ProductBeforeCreatingDto productBeforeCreatingDto);
}
