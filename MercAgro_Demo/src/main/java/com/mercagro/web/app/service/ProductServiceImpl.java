package com.mercagro.web.app.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercagro.web.app.entity.Productos;
import com.mercagro.web.app.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	
	@Override
	public Iterable<Productos> getAllProduct() {
		// TODO Auto-generated method stub
		return null;
	}
	/*
	@Autowired
	ProductRepository productrepository;
	
	@Override
	public Iterable<Productos> getAllProduct() {
		return productrepository.findAll();
	}*/
	
}
