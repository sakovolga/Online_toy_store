package com.example.online_toy_store.service.interf;

import com.example.online_toy_store.entity.Supplier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

public interface SupplierService {

    Supplier createSupplier(Supplier supplier);

    Supplier showByName(String name);

    List<Supplier> showAll();
}
