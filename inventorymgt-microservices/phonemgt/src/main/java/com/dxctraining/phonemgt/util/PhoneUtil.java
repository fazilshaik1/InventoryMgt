package com.dxctraining.phonemgt.util;

import org.springframework.stereotype.Component;
import com.dxctraining.phonemgt.dto.PhoneDto;
import com.dxctraining.phonemgt.entities.Phone;

@Component
public class PhoneUtil {
    public PhoneDto phoneDto(Phone phone, int supplierId, String supplierName){
        PhoneDto dto = new PhoneDto(phone.getId(),phone.getName(),phone.getStoragesize());
        dto.setSupplierId(supplierId);
        dto.setSupplierName(supplierName);
        return dto;
    }
}
