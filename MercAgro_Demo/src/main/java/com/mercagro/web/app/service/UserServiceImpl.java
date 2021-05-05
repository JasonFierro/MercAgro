package com.mercagro.web.app.service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mercagro.web.app.entity.Clientes;
import com.mercagro.web.app.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository repository;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	@Override
	public Iterable<Clientes> getAllUsers() {
		return repository.findAll();
	}

	private boolean checkUsernameAvailable(Clientes clientes) throws Exception {
		Optional<Clientes> userFound = repository.findByUsername(clientes.getUsername());
		if (userFound.isPresent()) {
			throw new Exception("Usuario no disponible");
		}
		return true;
	}

	private boolean checkPasswordValid(Clientes clientes) throws Exception {
		if ( !clientes.getPassword().equals(clientes.getConfirmPassword())) 
		{
			throw new Exception("Contraseña y Confirmar Contraseña no son iguales");
		}
		return true;
	}


	@Override
	public Clientes createUser(Clientes clientes) throws Exception {
		if (checkUsernameAvailable(clientes) && checkPasswordValid(clientes)) {
			String encodePassword = bCryptPasswordEncoder.encode(clientes.getPassword());
			clientes.setPassword(encodePassword);
			clientes = repository.save(clientes);
		}
		return clientes;
	}

}
