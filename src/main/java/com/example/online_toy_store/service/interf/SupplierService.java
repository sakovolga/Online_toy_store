package com.example.online_toy_store.service.interf;

import com.example.online_toy_store.entity.Supplier;
import org.springframework.stereotype.Service;

public interface SupplierService {

    Supplier createSupplier(Supplier supplier);

    Supplier showByName(String name);
}
