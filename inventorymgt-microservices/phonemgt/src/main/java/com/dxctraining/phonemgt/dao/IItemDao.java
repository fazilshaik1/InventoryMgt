package com.dxctraining.phonemgt.dao;

import java.util.List;
import com.dxctraining.phonemgt.entities.Item;
import com.dxctraining.phonemgt.entities.Phone;

public interface IItemDao {
	Item findById(int id);
	Item addItem(Item item);
	Item updateItem(Item item);
	void removeItem(int id);
	List<Phone> phonelist();
	List<Phone>phonesBySupplier(int supplierId);

}
