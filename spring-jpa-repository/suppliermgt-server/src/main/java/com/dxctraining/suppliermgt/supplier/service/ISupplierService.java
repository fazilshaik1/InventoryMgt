package com.dxctraining.suppliermgt.supplier.service;


import java.util.List;

import com.dxctraining.suppliermgt.supplier.entities.Supplier;

public interface ISupplierService {

    Supplier findSupplierById(int id);

    Supplier save(Supplier supplier);

    void remove(int id);

    List<Supplier> findByName(String name);

    List<Supplier> allSuppliers();

}
