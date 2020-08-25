package com.dxctraining.inventorymgt.item.controller;

import com.dxctraining.inventorymgt.item.dto.ComputerDto;
import com.dxctraining.inventorymgt.item.service.IItemService;
import com.dxctraining.inventorymgt.item.util.ComputerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ComputerController {
	
	@Autowired
	private IItemService service;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ComputerUtil computerUtil;
	


}
