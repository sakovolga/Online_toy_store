package com.example.online_toy_store.service.impl;

import com.example.online_toy_store.entity.Supplier;
import com.example.online_toy_store.exception.ASupplierWithTheSameNameAlreadyExistsException;
import com.example.online_toy_store.exception.SupplierDoesNotExistException;
import com.example.online_toy_store.repository.SupplierRepository;
import com.example.online_toy_store.service.interf.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;
    @Override
    @Transactional
    public Supplier createSupplier(Supplier supplier) {
        Supplier check = supplierRepository.findBySupplierName(supplier.getSupplierName());
        if (check != null) throw new ASupplierWithTheSameNameAlreadyExistsException
                ("A supplier with name " + supplier.getSupplierName() + " already exists");
        return supplierRepository.saveAndFlush(supplier);
    }

    @Override
    @Transactional
    public Supplier showByName(String name) {
        Supplier supplier = supplierRepository.findBySupplierName(name);
        if (supplier == null) throw new SupplierDoesNotExistException("Supplier not found with name: " + name);
        return supplier;
    }
}
