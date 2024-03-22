package com.example.online_toy_store.service.interf;

import com.example.online_toy_store.entity.Product;

import java.util.List;
import java.util.Set;

public interface ProductService {

    Product showProduct(String id);

    List<Product> showProducts();
}
