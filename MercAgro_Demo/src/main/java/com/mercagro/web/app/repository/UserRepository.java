package com.mercagro.web.app.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mercagro.web.app.entity.Clientes;

@Repository
public interface UserRepository extends CrudRepository<Clientes, Long> {
	
	Optional<Clientes> findByUsername(String username);
 }
