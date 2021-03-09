package com.mercagro.web.app.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mercagro.web.app.entity.Productos;
import com.sun.el.stream.Optional;

@Repository
public interface ProductRepository extends CrudRepository<Productos, Long> {
	
	public Optional findByNombre(String nombre);

}
