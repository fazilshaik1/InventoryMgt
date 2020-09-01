package com.dxctraining.suppliermgt.supplier.service;

import com.dxctraining.suppliermgt.exceptions.InvalidArgumentException;
import com.dxctraining.suppliermgt.exceptions.SupplierNotFoundException;
import com.dxctraining.suppliermgt.supplier.dao.ISupplierDao;
import com.dxctraining.suppliermgt.supplier.entities.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class SupplierServiceImpl implements ISupplierService{

    @Autowired
    private ISupplierDao dao;

    @Override
    public Supplier findSupplierById(int id) {
       Optional<Supplier> optional= dao.findById(id);
       if(!optional.isPresent()){
           throw new SupplierNotFoundException("supplier not found for id="+id);
       }
        Supplier supplier=optional.get();
        return supplier;
    }



    @Override
    public Supplier save(Supplier supplier) {
        validate(supplier);
        supplier=dao.save(supplier);
        return supplier;
    }

    private void validate(Supplier supplier) {
		if(supplier == null) {
			throw new InvalidArgumentException("supplier should not be null");
		}
		
	}



	@Override
    public void remove(int id) {
       dao.deleteById(id);
    }

    @Override
    public List<Supplier> findByName(String name) {
       List<Supplier> list =dao.findByName(name);
       return list;
    }


    @Override
    public List<Supplier> allSuppliers(){
        List<Supplier>list = dao.findAll();
        return list;
    }

}
