package com.mercagro.web.app.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mercagro.web.app.entity.Clientes;
import com.mercagro.web.app.entity.Productos;
import com.mercagro.web.app.repository.CiudadRepository;
import com.mercagro.web.app.repository.RoleRepository;
import com.mercagro.web.app.repository.TipoDocumentoRepository;
import com.mercagro.web.app.service.ProductoService;
import com.mercagro.web.app.service.UserService;

@Controller
public class userController {
	
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private TipoDocumentoRepository tipoDocRepository;
	
	@Autowired
	private CiudadRepository ciudadRepository;
	
	
	@GetMapping({"/","/login"})
	public String login(Model model) {
		model.addAttribute("titulo", "Login");
		return "login";
	}
	
	@RequestMapping(value = "productos",method = RequestMethod.GET)
	public String listarProdutos(Model model) {
		model.addAttribute("titulo", "Productos");
		model.addAttribute("productoList", productoService.getAllProductos());
		return "products";
	}
	
	@GetMapping({"/nuevosProductos"})
	public String newProducts(Model model) {
		model.addAttribute("nuevosProductos", new Productos());
		model.addAttribute("titulo", "Ingresar Productos");
		return "productsNew";
	}
	
	@PostMapping("/nuevosProductos")
	public String postProductForm(@Valid @ModelAttribute("nuevosProductos")Productos producto, BindingResult result, ModelMap model) {
			if(result.hasErrors()) {
				model.addAttribute("nuevosProductos", producto);
				//model.addAttribute("formTab","active");
			}else {
				try {//Aca tendras error porque este metodo no existe, pero lo crearemos en la siguiente seccion.
					productoService.createProduct(producto);
					model.addAttribute("nuevosProductos", new Productos());
					//model.addAttribute("listTab","active");
				} catch (Exception e) {
					model.addAttribute("formError",e.getMessage());
					model.addAttribute("nuevosProductos", producto);
					//model.addAttribute("formTab","active");
				}
			}
			return "productsNew";
		}
	
	@RequestMapping(value = "clientes",method = RequestMethod.GET)
	public String listarClientes(Model model) {
		model.addAttribute("titulo", "MercAgro");
		model.addAttribute("clienteList", userService.getAllUsers());
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
	
	
	@GetMapping("/userForm")
	public String userForm(Model model) {
		model.addAttribute("userForm", new Clientes());
		model.addAttribute("userList", userService.getAllUsers());
		model.addAttribute("roles",roleRepository.findAll());
		model.addAttribute("tipoDoc",tipoDocRepository.findAll());
		model.addAttribute("ciudades",ciudadRepository.findAll());
		//model.addAttribute("listTab","active");
		return "user-view";
	}

	
	@PostMapping("/userForm")
	public String postUserForm(@Valid @ModelAttribute("userForm")Clientes user, BindingResult result, ModelMap model) {
			if(result.hasErrors()) {
				model.addAttribute("userForm", user);
				//model.addAttribute("formTab","active");
			}else {
				try {//Aca tendras error porque este metodo no existe, pero lo crearemos en la siguiente seccion.
					userService.createUser(user);
					model.addAttribute("userForm", new Clientes());
					//model.addAttribute("listTab","active");
				} catch (Exception e) {
					model.addAttribute("formError",e.getMessage());
					model.addAttribute("userForm", user);
					//model.addAttribute("formTab","active");
				}
			}

			model.addAttribute("userList", userService.getAllUsers());
			model.addAttribute("roles",roleRepository.findAll());
			model.addAttribute("tipoDoc",tipoDocRepository.findAll());
			model.addAttribute("ciudades",ciudadRepository.findAll());
			return "user-view";
		}
}
