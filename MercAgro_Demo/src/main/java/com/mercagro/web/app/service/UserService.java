package com.mercagro.web.app.service;
import com.mercagro.web.app.Controller.ChangePasswordForm;
import com.mercagro.web.app.entity.Clientes;


public interface UserService {

	public Iterable<Clientes> getAllUsers();
	
	public Clientes createUser(Clientes clientes) throws Exception;

	public Clientes getUserById(Long id) throws Exception;
	
	public Clientes updateUser(Clientes clientes) throws Exception;
	
	public void deleteUser(Long id) throws Exception;
	
	public Clientes changePassword(ChangePasswordForm form) throws Exception;

}
