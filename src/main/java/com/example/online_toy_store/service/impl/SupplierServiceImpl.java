package com.example.online_toy_store.service.impl;

import com.example.online_toy_store.entity.Supplier;
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
        return supplierRepository.saveAndFlush(supplier);
    }
}
