package com.mercagro.web.app.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mercagro.web.app.entity.Clientes;
import com.mercagro.web.app.entity.Productos;
import com.mercagro.web.app.entity.imagesProduct;
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
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "redirect:/login?logout";
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
	
	@RequestMapping("/productos")
	public String imageneProductos(Model model) {
	 
	    imagesProduct prod1 = new imagesProduct(1L, "legumbres.jpeg");
	    imagesProduct prod2 = new imagesProduct(2L, "frutas.jpg");
	    imagesProduct prod3 = new imagesProduct(3L, "verdura.jpg");
	    imagesProduct prod4 = new imagesProduct(3L, "hortalizas.jpg");
	 
	    List<imagesProduct> list = new ArrayList<imagesProduct>();
	 
	    list.add(prod1);
	    list.add(prod2);
	    list.add(prod3);
	    list.add(prod4);
	 
	    model.addAttribute("imagenesProducts", list);
	 
	    return "products";
	}
	
	@GetMapping("/listar")
	public String userFormu(Model model) {
		model.addAttribute("userFormu", new Clientes());
		model.addAttribute("userList", userService.getAllUsers());
		model.addAttribute("productoList", productoService.getAllProductos());
		model.addAttribute("roles",roleRepository.findAll());
		model.addAttribute("listTab","active");
		return "user-form/user-view";
	}
	
	@PostMapping("/listar")
	public String createUser(@Valid @ModelAttribute("userFormu")Clientes user, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			model.addAttribute("userFormu", user);
			model.addAttribute("formTab","active");
		}else {
			try {
				userService.createUser(user);
				model.addAttribute("userFormu", new Clientes());
				model.addAttribute("listTab","active");
				
			} catch (Exception e) {
				model.addAttribute("formErrorMessage",e.getMessage());
				model.addAttribute("userFormu", user);
				model.addAttribute("formTab","active");
				model.addAttribute("userList", userService.getAllUsers());
				model.addAttribute("roles",roleRepository.findAll());
			}
		}
		model.addAttribute("productoList", productoService.getAllProductos());
		model.addAttribute("userList", userService.getAllUsers());
		model.addAttribute("roles",roleRepository.findAll());
		return "user-form/user-view";
	}
	
	@GetMapping("/editUser/{id}")
	public String getEditUserForm(Model model, @PathVariable(name ="id")Long id)throws Exception{
		Clientes userToEdit = userService.getUserById(id);
		
		model.addAttribute("userFormu", userToEdit);
		model.addAttribute("userList", userService.getAllUsers());
		model.addAttribute("productoList", productoService.getAllProductos());
		model.addAttribute("roles",roleRepository.findAll());
		model.addAttribute("formTab","active");
		model.addAttribute("editMode","true");
		model.addAttribute("passwordForm",new ChangePasswordForm(id));
		
		return "user-form/user-view";
	}
	
	@PostMapping("/editUser")
	public String postEditUserForm(@Valid @ModelAttribute("userFormu")Clientes user, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			model.addAttribute("userFormu", user);
			model.addAttribute("formTab","active");
			model.addAttribute("editMode","true");
			model.addAttribute("passwordForm",new ChangePasswordForm(user.getId()));
		}else {
			try {
				userService.updateUser(user);
				model.addAttribute("userFormu", new Clientes());
				model.addAttribute("listTab","active");
			} catch (Exception e) {
				model.addAttribute("formErrorMessage",e.getMessage());
				model.addAttribute("userFormu", user);
				model.addAttribute("formTab","active");
				model.addAttribute("userList", userService.getAllUsers());
				model.addAttribute("roles",roleRepository.findAll());
				model.addAttribute("editMode","true");
				model.addAttribute("passwordForm",new ChangePasswordForm(user.getId()));
			}
		}
		
		model.addAttribute("userList", userService.getAllUsers());
		model.addAttribute("roles",roleRepository.findAll());
		return "user-form/user-view";
		
	}
	
	@GetMapping("/listar/cancel")
	public String cancelEditUser(ModelMap model) {
		return "redirect:/listar";
	}
	
	@GetMapping("/deleteUser/{id}")
	public String deleteUser(Model model, @PathVariable(name="id")Long id) {
		try {
			userService.deleteUser(id);
			//productoService.deleteProduct(id);
		} catch (Exception e) {
			model.addAttribute("listErrorMessage",e.getMessage());
		}
		return userFormu(model);
	}
	
	@GetMapping("/listarProductos/cancel")
	public String cancelEditProduct(ModelMap model) {
		return "redirect:/listarProductos";
	}
	
	@GetMapping("/deleteProduct/{id}")
	public String deleteProduct(Model model, @PathVariable(name="id")Long id) {
		try {
			//userService.deleteUser(id);
			productoService.deleteProduct(id);
		} catch (Exception e) {
			model.addAttribute("listErrorMessage",e.getMessage());
		}
		return productFormu(model);
	}
	
	@GetMapping("/listarProductos")
	public String productFormu(Model model) {
		model.addAttribute("productFormu", new Productos());
		model.addAttribute("productoList", productoService.getAllProductos());
		model.addAttribute("listTab","active");
		return "product-form/product-view";
	}
	
	@PostMapping("/listarProductos")
	public String createProduct(@Valid @ModelAttribute("productFormu")Productos product, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			model.addAttribute("productFormu", product);
			model.addAttribute("formTab","active");
		}else {
			try {
				productoService.createProduct(product);
				model.addAttribute("productFormu", new Productos());
				model.addAttribute("listTab","active");
				
			} catch (Exception e) {
				model.addAttribute("formErrorMessage",e.getMessage());
				model.addAttribute("productFormu", product);
				model.addAttribute("formTab","active");
				model.addAttribute("productoList", productoService.getAllProductos());
			}
		}
		model.addAttribute("productoList", productoService.getAllProductos());
		return "product-form/product-view";
	}
	
	@GetMapping("/editProduct/{id}")
	public String getEditProductForm(Model model, @PathVariable(name ="id")Long id)throws Exception{
		Productos productToEdit = productoService.getProductsById(id);
		
		model.addAttribute("productFormu", productToEdit);
		model.addAttribute("productoList", productoService.getAllProductos());
		model.addAttribute("formTab","active");
		model.addAttribute("editMode","true");
		
		return "product-form/product-view";
	}
	
	@PostMapping("/editProduct")
	public String postEditProductForm(@Valid @ModelAttribute("productFormu")Productos product, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			model.addAttribute("productFormu", product);
			model.addAttribute("formTab","active");
			model.addAttribute("editMode","true");
		}else {
			try {
				productoService.updateProduct(product);
				model.addAttribute("productFormu", new Productos());
				model.addAttribute("listTab","active");
			} catch (Exception e) {
				model.addAttribute("formErrorMessage",e.getMessage());
				model.addAttribute("productFormu", product);
				model.addAttribute("formTab","active");
				model.addAttribute("editMode","true");
			}
		}
		model.addAttribute("productoList", productoService.getAllProductos());
		return "product-form/product-view";
		
	}
	
	
	@PostMapping("/editUser/changePassword")
	public ResponseEntity postEditUseChangePassword(@Valid @RequestBody ChangePasswordForm form, Errors errors) {
		try {
			if( errors.hasErrors()) {
				String result = errors.getAllErrors()
                        .stream().map(x -> x.getDefaultMessage())
                        .collect(Collectors.joining(""));

				throw new Exception(result);
			}
			userService.changePassword(form);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		return ResponseEntity.ok("Success");
	}
}
