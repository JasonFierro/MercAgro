package com.mercagro.web.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mercagro.web.app.entity.Productos;
import com.mercagro.web.app.repository.ProductRepository;

@Repository
public class ProductoServiceImpl implements ProductoService {
	
	@Autowired
	ProductRepository productRepository;

	public Iterable<Productos> getAllProductos() {
		
		return productRepository.findAll();
	}

	/*
	@Override
	public List<Productos> findAllProductos() {
		return productRepository.findAll(); 
	}

	@Override
	public Optional<Productos> findProductosById(Long id) {
		Optional<Productos> productos = productRepository.findById(id);
		return productos;
	}

	@Override
	public Productos saveProductos(Productos productosnew) {
		if (productosnew != null) {
			return productRepository.save(productosnew);
		} 
		return new Productos();
	}

	@Override
	public String deleteProductos(Long id) {
		if (productRepository.findById(id).isPresent()) {
			productRepository.deleteById(id);
			return "Producto eliminado correctamente.";
		}
		return "Error! El producto no existe";
	}

	@Override
	public String updateProductos(Productos productosUpdate) {
		Long num = (long) productosUpdate.getId_articulo();
		if (productRepository.findById(num).isPresent()) {
			Productos productosToUpdate = new Productos();
			productosToUpdate.setId_articulo(productosToUpdate.getId_articulo());
			productosToUpdate.setId_estado(productosToUpdate.getId_estado());
			productosToUpdate.setNombre(productosToUpdate.getNombre());
			productosToUpdate.setDescripcion(productosToUpdate.getDescripcion());
			productosToUpdate.setCosto(productosToUpdate.getCosto());
			productosToUpdate.setCantidad(productosToUpdate.getCantidad());
			productRepository.save(productosToUpdate);
			return "Producto Modificado";
		}
		return "Error! El producto no se modifico.";
	}*/

}
