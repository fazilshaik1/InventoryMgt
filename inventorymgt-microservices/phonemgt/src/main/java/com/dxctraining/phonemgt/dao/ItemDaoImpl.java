package com.dxctraining.phonemgt.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dxctraining.phonemgt.entities.Item;
import com.dxctraining.phonemgt.entities.Phone;
import com.dxctraining.phonemgt.exceptions.ItemNullException;

@Repository
public class ItemDaoImpl implements IItemDao{
	
	@Autowired
	private EntityManager em;
	
	@Override
	public Item findById(int id) {
		Item item = em.find(Item.class, id);
		if(item == null) {
			throw new ItemNullException("item is null");
		}
		return item;
	}

	@Override
	public Item addItem(Item item) {
		em.persist(item);
		return item;
	}

	@Override
	public Item updateItem(Item item) {
		em.merge(item);
		return item;
	}

	@Override
	public void removeItem(int id) {
		Item item = findById(id);
		em.remove(item);
		
	}

	@Override
	public List<Phone> phonelist() {
		String jpaql = "from Phone";
		TypedQuery<Phone>query=em.createQuery(jpaql, Phone.class);
		List<Phone>list = query.getResultList();
		return list;
	}

	@Override
	public List<Phone> phonesBySupplier(int supplierId) {
		String jpaql = "from Phone where supplierId=:supplier";
		TypedQuery<Phone>query = em.createQuery(jpaql, Phone.class);
		query.setParameter("supplier" ,supplierId);
		List<Phone>list = query.getResultList();
		return list;
	}


}
