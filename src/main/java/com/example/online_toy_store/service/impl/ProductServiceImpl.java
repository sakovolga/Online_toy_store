package com.example.online_toy_store.service.impl;

import com.example.online_toy_store.dto.ProductAfterCreatingDto;
import com.example.online_toy_store.dto.ProductBeforeCreatingDto;
import com.example.online_toy_store.entity.Product;
import com.example.online_toy_store.entity.Supplier;
import com.example.online_toy_store.exception.NoProductsFoundException;
import com.example.online_toy_store.exception.ProductDoesNotExistException;
import com.example.online_toy_store.exception.errorMessage.ErrorMessage;
import com.example.online_toy_store.mapper.CreateProductDtoMapper;
import com.example.online_toy_store.repository.ProductRepository;
import com.example.online_toy_store.repository.SupplierRepository;
import com.example.online_toy_store.service.interf.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CreateProductDtoMapper createProductDtoMapper;
    private final SupplierRepository supplierRepository;

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
        List<Product> productList = productRepository.findAll();
        if (productList.isEmpty()) {
            throw new NoProductsFoundException(ErrorMessage.NO_PRODUCTS_FOUND);
        }
        return productList;
    }

    @Override
    @Transactional
    public ProductAfterCreatingDto createProductDto(ProductBeforeCreatingDto productBeforeCreatingDto) {
        Product product = createProductDtoMapper.toEntity(productBeforeCreatingDto);
        Supplier supplier = supplierRepository.findBySupplierName(productBeforeCreatingDto.getSupplierName());
        if (supplier == null) {
            Supplier newSupplier = createProductDtoMapper.toSupplier((productBeforeCreatingDto));
            Supplier supplier1 = supplierRepository.saveAndFlush(newSupplier);
            product.setSupplier(supplier1);
        } else {
            product.setSupplier(supplier);
        }
        return createProductDtoMapper.toDto(productRepository.saveAndFlush(product));
    }
}
