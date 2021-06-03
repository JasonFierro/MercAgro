package com.mercagro.web.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mercagro.web.app.entity.Ciudades;

@Repository
public interface CiudadRepository extends CrudRepository<Ciudades, Long>{

}
