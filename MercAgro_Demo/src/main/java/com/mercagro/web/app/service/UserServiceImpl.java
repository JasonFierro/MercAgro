package com.mercagro.web.app.service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mercagro.web.app.Controller.ChangePasswordForm;
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
		}else {
			//throw new Exception("Usuario Registrado");
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
	
	@Override
	public Clientes getUserById(Long id) throws Exception {
		return repository.findById(id).orElseThrow(() -> new Exception("El usuario no existe."));
	}

	@Override
	public Clientes updateUser(Clientes fromUser) throws Exception {
		Clientes toUser = getUserById(fromUser.getId());
		mapUser(fromUser, toUser);
		return repository.save(toUser);
	}
	
	/**
	 * Map everythin but the password.
	 * @param from
	 * @param to
	 */
	protected void mapUser(Clientes from,Clientes to) {
		to.setUsername(from.getUsername());
		to.setNombre(from.getNombre());
		to.setApellido(from.getApellido());
		to.setCorreo(from.getCorreo());
		to.setAuthority(from.getAuthority());
	}

	@Override
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public void deleteUser(Long id) throws Exception {
		Clientes user = getUserById(id);
		repository.delete(user);
	}

	
	
	@Override
	public Clientes changePassword(ChangePasswordForm form) throws Exception {
		Clientes user = getUserById(form.getId());
		
		if ( !isLoggedUserADMIN() && !user.getPassword().equals(form.getCurrentPassword())) {
			throw new Exception ("Current Password invalido.");
		}
		
		if( user.getPassword().equals(form.getNewPassword())) {
			throw new Exception ("Nuevo debe ser diferente al password actual.");
		}
		
		if( !form.getNewPassword().equals(form.getConfirmPassword())) {
			throw new Exception ("Nuevo Password y Current Password no coinciden.");
		}
		
		String encodePassword = bCryptPasswordEncoder.encode(form.getNewPassword());
		user.setPassword(encodePassword);
		return repository.save(user);
	}
	
	private boolean isLoggedUserADMIN() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails loggedUser = null;
		if (principal instanceof UserDetails) {
			loggedUser = (UserDetails) principal;
		
			loggedUser.getAuthorities().stream()
					.filter(x -> "ADMIN".equals(x.getAuthority() ))      
					.findFirst().orElse(null); //loggedUser = null;
		}
		return loggedUser != null ?true :false;
	}

}
