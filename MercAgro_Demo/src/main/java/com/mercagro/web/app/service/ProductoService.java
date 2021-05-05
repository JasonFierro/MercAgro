package com.mercagro.web.app.service;

import java.util.List;
import java.util.Optional;

import com.mercagro.web.app.entity.Productos;

public interface ProductoService {
	
	public Iterable<Productos> getAllProductos();
	
	public Productos createProduct(Productos productos) throws Exception;
	
	/*public Optional<Productos> findProductosById(Long id);
	
	public Productos saveProductos(Productos productosnew);
	
	public String deleteProductos(Long id);
	
	public String updateProductos(Productos productosUpdate);*/
}
