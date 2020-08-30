package com.dxctraining.inventorymgt.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dxctraining.inventorymgt.dto.CreateSupplierRequest;
import com.dxctraining.inventorymgt.dto.SupplierDto;
import com.dxctraining.inventorymgt.dto.UpdateSupplierRequest;
import com.dxctraining.inventorymgt.entities.Supplier;
import com.dxctraining.inventorymgt.service.ISupplierService;

@RestController
@RequestMapping("/suppliers")
public class SupplierRestController {
	
	@Autowired
	private ISupplierService service;
	
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public SupplierDto createSupplier(@RequestBody CreateSupplierRequest requestData) {
		Supplier supplier = new Supplier(requestData.getName(), requestData.getPassword());
		supplier = service.addSupplier(supplier);
		SupplierDto response = toDto(supplier);
		return response;	
	}
	
	private SupplierDto toDto(Supplier supplier) {
		SupplierDto dto = new SupplierDto();
		dto.setId(supplier.getId());
		dto.setName(supplier.getName());
		dto.setPassword(supplier.getPassword());
		return dto;
	}

	@GetMapping("/get/{id}")
	@ResponseStatus(HttpStatus.OK)
	public SupplierDto getSupplier(@PathVariable("id")int id) {
		Supplier supplier = service.findById(id);
		SupplierDto response = toDto(supplier);
		return response;
	}
	
	@GetMapping
	public List<SupplierDto> allSuppliers(){
		List<Supplier> list = service.listAll();
		List<SupplierDto> response = new ArrayList<>();
		for(Supplier supplier:list) {
			SupplierDto supplierDto = toDto(supplier);
			response.add(supplierDto);
		}
		return response;
	}
	
	@PutMapping("/update")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public SupplierDto updateSupplier(@RequestBody UpdateSupplierRequest requestData) {
		Supplier supplier = new Supplier(requestData.getId(), requestData.getName(),requestData.getPassword());
		supplier.setId(supplier.getId());
		supplier = service.updateSupplier(supplier);
		SupplierDto response = toDto(supplier);
		return response;
	}
	
	@GetMapping("/authenticate/{id}/{password}")
	public boolean authenticate(@PathVariable("id")int id, @PathVariable("password")String password) {
		boolean status = service.authentication(id, password);
		return status;	
	}

}
