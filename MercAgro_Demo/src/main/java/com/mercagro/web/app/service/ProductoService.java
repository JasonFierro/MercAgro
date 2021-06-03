package com.mercagro.web.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;

import com.mercagro.web.app.entity.Clientes;
import com.mercagro.web.app.entity.Productos;

public interface ProductoService {
	
	public Iterable<Productos> getAllProductos();
	
	public List<Productos> findByNombre(String term);
	
	public Productos getProductsById(Long id) throws Exception;
	
	public Productos createProduct(Productos productos) throws Exception;
	
	public Productos updateProduct(Productos productos) throws Exception;
	
	public void deleteProduct(Long id) throws Exception;
}
