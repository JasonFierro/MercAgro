package com.mercagro.web.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mercagro.web.app.entity.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long>{

	//public Role findByDescripcion(String descripcion);
}