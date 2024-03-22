package com.example.online_toy_store.service.impl;

import com.example.online_toy_store.entity.Product;
import com.example.online_toy_store.exception.ProductDoesNotExistException;
import com.example.online_toy_store.exception.UserDoesNotExistException;
import com.example.online_toy_store.exception.errorMessage.ErrorMessage;
import com.example.online_toy_store.repository.ProductRepository;
import com.example.online_toy_store.service.interf.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    @Override
    @Transactional
    public Product showProduct(String id) {
        return productRepository.findById
                        (UUID.fromString(id))
                .orElseThrow(() -> new ProductDoesNotExistException(ErrorMessage.PRODUCT_DOES_NOT_EXIST));
    }

    @Override
    @Transactional
    public List<Product> showProducts() {
        return productRepository.findAll();
    }
}
