package com.mercagro.web.app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mercagro.web.app.repository.RoleRepository;
import com.mercagro.web.app.service.ProductoService;
import com.mercagro.web.app.service.UserService;

@Controller
@RequestMapping
public class userController {
	
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private ProductoService productoService;
	
	@RequestMapping(value = "productos",method = RequestMethod.GET)
	public String listarProdutos(Model model) {
		model.addAttribute("titulo", "MercAgro");
		model.addAttribute("productoList", productoService.getAllProductos());
		return "products";
	}
	
	@RequestMapping(value = "listar",method = RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo", "MercAgro");
		model.addAttribute("productoList", productoService.getAllProductos());
		return "listar";
	}
	
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
	
	
	
	@GetMapping("/registro")
	public String getUserForm(Model model) {
		model.addAttribute("titulo", "Registo de Usuario");
		model.addAttribute("roles",roleRepository.findAll());
		//model.addAttribute("listTab","active");
		return "register";
	}
	/*
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
