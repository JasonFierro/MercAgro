package com.mercagro.web.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mercagro.web.app.entity.TipoDocumento;

@Repository
public interface TipoDocumentoRepository extends CrudRepository<TipoDocumento, Long> {
	
		//public Optional findByNombre(String nombre);

}
