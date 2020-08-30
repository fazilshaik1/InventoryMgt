package com.dxctraining.computermgt.service;

import java.util.List;

import com.dxctraining.computermgt.entities.Computer;
import com.dxctraining.computermgt.entities.Item;

public interface IItemService {
	Item findById(int id);
	Item addItem(Item item);
	Item updateItem(Item item);
	void removeItem(int id);
	List<Computer>computerlist();
	List<Computer> computersBySupplier(int supplierId);

}
