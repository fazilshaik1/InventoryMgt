package com.dxctraining.suppliermgt.supplier.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.dxctraining.suppliermgt.supplier.dto.CreateSupplierRequest;
import com.dxctraining.suppliermgt.supplier.dto.SupplierDto;
import com.dxctraining.suppliermgt.supplier.entities.Supplier;
import com.dxctraining.suppliermgt.supplier.service.ISupplierService;
import com.dxctraining.suppliermgt.supplier.util.SupplierUtil;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/suppliers")
public class SupplierRestController {

    @Autowired
    private ISupplierService service;

    @Autowired
    private SupplierUtil supplierUtil;
    
    @PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public SupplierDto addSupplier(@RequestBody CreateSupplierRequest requestData) {
		Supplier supplier = new Supplier(requestData.getName(), requestData.getPassword());
		supplier = service.save(supplier);
		SupplierDto response = supplierUtil.supplierDto(supplier);
		return response;
	}
    
    @GetMapping("/get/{id}")
	@ResponseStatus(HttpStatus.OK)
	public SupplierDto findSupplierById(@PathVariable("id")int id) {
		Supplier supplier = service.findSupplierById(id);
		SupplierDto response = supplierUtil.supplierDto(supplier);
		return response;
	}

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<SupplierDto> fetchAll() {
        List<Supplier> list = service.allSuppliers();
        List<SupplierDto>response=new ArrayList<>();
        for (Supplier supplier:list){
            SupplierDto dto=supplierUtil.supplierDto(supplier);
            response.add(dto);
        }
        return response;
    }

}




