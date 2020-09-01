package com.dxctraining.suppliermgt.supplier.util;

import com.dxctraining.suppliermgt.supplier.dto.SupplierDto;
import com.dxctraining.suppliermgt.supplier.entities.Supplier;

import org.springframework.stereotype.Component;

@Component
public class SupplierUtil {


    public SupplierDto supplierDto(Supplier supplier){
        SupplierDto dto=new SupplierDto(supplier.getId(),supplier.getName(), supplier.getPassword());
        return dto;
    }

}
