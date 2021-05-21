package com.mercagro.web.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mercagro.web.app.entity.Clientes;
import com.mercagro.web.app.entity.Productos;
import com.mercagro.web.app.repository.ProductRepository;

@Repository
public class ProductoServiceImpl implements ProductoService {
	
	@Autowired
	ProductRepository productRepository;

	public Iterable<Productos> getAllProductos() {
		
		return productRepository.findAll();
	}

	@Override
	public Productos createProduct(Productos productos) throws Exception {
		if (productos != null) {
			return productRepository.save(productos);
		} 
		return new Productos();
	}

	@Override
	public List<Productos> findByNombre(String term) {
		return productRepository.findByNombre(term);
	}
	
	public Productos getProductsById(Long id) throws Exception {
		return productRepository.findById(id).orElseThrow(() -> new Exception("El producto no existe."));
	}

	@Override
	public Productos updateProduct(Productos productos) throws Exception {
		Productos toProduct = getProductsById(productos.getId());
		mapUser(productos, toProduct);
		return productRepository.save(toProduct);
	}
	
	protected void mapUser(Productos from,Productos to) {
		to.setNombre(from.getNombre());
		to.setDescripcion(from.getDescripcion());
		to.setCosto(from.getCosto());
		to.setCantidad(from.getCantidad());
		to.setTipo(from.getTipo());
	}

	@Override
	public void deleteProduct(Long id) throws Exception {
		Productos product = getProductsById(id);
		productRepository.delete(product);
		
	}


}
