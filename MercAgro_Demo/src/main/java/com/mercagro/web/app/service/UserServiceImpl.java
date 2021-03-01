package com.mercagro.web.app.service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercagro.web.app.entity.Clientes;
import com.mercagro.web.app.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserRepository repository;
	
	@Override
	public Iterable<Clientes> getAllUsers() {
		return repository.findAll();
	}

	private boolean checkUsernameAvailable(Clientes clientes) throws Exception {
		Optional<Clientes> userFound = repository.findByUsuario(clientes.getUsuario());
		if (userFound.isPresent()) {
			throw new Exception("Usuario no disponible");
		}
		return true;
	}

	private boolean checkPasswordValid(Clientes clientes) throws Exception {
		if ( !clientes.getContrasena().equals(clientes.getConfirmContrasena())) 
		{
			throw new Exception("Contraseña y Confirmar Contraseña no son iguales");
		}
		return true;
	}


	@Override
	public Clientes createUser(Clientes clientes) throws Exception {
		if (checkUsernameAvailable(clientes) && checkPasswordValid(clientes)) {
			clientes = repository.save(clientes);
		}
		return clientes;
	}

	@Override
	public Clientes getUserById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Clientes updateUser(Clientes clientes) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub
		
	}
}
