package com.mercagro.web.app.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mercagro.web.app.entity.Productos;
import com.sun.el.stream.Optional;

@Repository
public interface ProductRepository extends CrudRepository<Productos, Long> {
	
	//public Optional findByNombre(String nombre);
	
	//@Query("select p from Productos p where p.nombre like %?1")
	List<Productos> findByNombre(String term);

}
