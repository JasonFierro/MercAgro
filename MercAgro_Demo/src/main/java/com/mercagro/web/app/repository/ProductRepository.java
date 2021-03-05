package com.mercagro.web.app.repository;

import java.util.Optional;
import org.springframework.stereotype.Repository;
import com.mercagro.web.app.entity.Productos;

@Repository
public interface ProductRepository {
	public Optional<Productos> findByProducts(String products);
}
