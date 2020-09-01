package com.dxctraining.suppliermgt.supplier.dao;


import com.dxctraining.suppliermgt.supplier.entities.Supplier;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ISupplierDao extends JpaRepository<Supplier, Integer> {

    List<Supplier> findByName(String name);

}
