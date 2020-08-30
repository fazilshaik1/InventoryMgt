package com.dxctraining.computermgt.util;

import org.springframework.stereotype.Component;
import com.dxctraining.computermgt.dto.ComputerDto;
import com.dxctraining.computermgt.entities.Computer;

@Component
public class ComputerUtil {
    public ComputerDto computerDto(Computer computer, int supplierId, String supplierName){
        ComputerDto dto = new ComputerDto(computer.getId(),computer.getName(),computer.getDiscsize());
        dto.setSupplierId(supplierId);
        dto.setSupplierName(supplierName);
        return dto;
    }
}
