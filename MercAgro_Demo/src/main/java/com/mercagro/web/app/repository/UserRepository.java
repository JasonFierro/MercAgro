package com.mercagro.web.app.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mercagro.web.app.entity.Clientes;
import com.mercagro.web.app.entity.Productos;

@Repository
public interface UserRepository extends CrudRepository<Clientes, Long> {
	public Optional<Clientes> findByUsername(String username);
 }
