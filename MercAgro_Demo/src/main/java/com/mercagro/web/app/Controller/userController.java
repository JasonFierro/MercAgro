package com.mercagro.web.app.Controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mercagro.web.app.entity.Clientes;
import com.mercagro.web.app.service.ProductService;
//import com.mercagro.web.app.repository.RoleRepository;
import com.mercagro.web.app.service.UserService;

@Controller
public class userController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	ProductService productService;
	
	
	@GetMapping({"/inicio"})
	public String index(Model model) {
		model.addAttribute("titulo", "MercAgro");
		return "index";
	}
	
	@GetMapping({"/contacto"})
	public String contacto(Model model) {
		model.addAttribute("titulo", "Contactenos");
		return "contacts";
	}
	
	@GetMapping({"/infoproductos"})
	public String infoproducts(Model model) {
		model.addAttribute("titulo", "Información de Productos");
		return "infoproducts";
	}
	
	@GetMapping({"/noticias"})
	public String news(Model model) {
		model.addAttribute("titulo", "Noticias MercAgro");
		return "news";
	}
	
	@GetMapping({"/productos"})
	public String products(Model model) {
		model.addAttribute("titulo", "Productos");
		return "products";
	}
	
	@GetMapping({"/nuevosProductos"})
	public String newProducts(Model model) {
		model.addAttribute("titulo", "Ingresar Productos");
		return "productsNew";
	}
	
	@GetMapping({"/menu"})
	public String menu(Model model) {
		model.addAttribute("titulo", "Menu");
		return "menu";
	}
	
	@GetMapping({"/user"})
	public String user(Model model) {
		model.addAttribute("titulo", "Menu");
		return "user";
	}
	
	@GetMapping({"/admin"})
	public String admin(Model model) {
		model.addAttribute("titulo", "Menu");
		return "admin";
	}

	@GetMapping({"/","/login"})
	public String login(Model model) {
		model.addAttribute("titulo", "Login");
		return "login";
	}
	
	
	@PostMapping("/productos")
	public String productList(Model model) {
		model.addAttribute("productList",productService.getAllProduct());
		return "/productos";
	}
	
	/*
	@GetMapping("/register")
	public String getUserForm(Model model) {
		model.addAttribute("titulo", "Registo de Usuario");
		model.addAttribute("userForm", new Clientes());
		//model.addAttribute("roles",roleRepository.findAll());
		//model.addAttribute("listTab","active");
		return "register";
	}
	
	@PostMapping("/userForm")
	public String createUser(@Valid @ModelAttribute("register")Clientes clientes, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			model.addAttribute("register", clientes);
			//model.addAttribute("formTab","active");
		}else {
			try {
				userService.createUser(clientes);
				model.addAttribute("clientes", new Clientes());
				//model.addAttribute("listTab","active");

			} catch (Exception e) {
				model.addAttribute("formErrorMessage",e.getMessage());
				model.addAttribute("clientes", clientes);
				//model.addAttribute("formTab","active");
				model.addAttribute("userList", userService.getAllUsers());
				model.addAttribute("roles",roleRepository.findAll());
			}
		}

		//model.addAttribute("userList", userService.getAllUsers());
		model.addAttribute("roles",roleRepository.findAll());
		return "login";
	}*/
}
