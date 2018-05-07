package com.computerspace.appweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.computerspace.appweb.modelo.Cliente;
import com.computerspace.appweb.servicios.ClienteServicios;

@Controller
@RequestMapping (path="/")
public class ClienteController {

	@Autowired
	ClienteServicios clienteServicios;
	
	@GetMapping
	public String login (Model model) {
		model.addAttribute("login", new DataLogin());
		
		return "login";
	}
	
	@PostMapping
	public String result (@ModelAttribute DataLogin datos) {
		
		String pagina;
		
		if (clienteServicios.validarCliente(datos.getEmail(), datos.getPassword()))
			pagina =  "main";
		else
			pagina =  "error_login";
		
		return pagina;
	}
	
	@GetMapping ("/alta")
	public String alta (Model model) {
		DataCliente dataCliente = new DataCliente ();
		dataCliente.setDataLogin(new DataLogin ());
		model.addAttribute("alta", dataCliente);
		return "altausuario";
			
	}
	
	@PostMapping ("/alta")
	public String postAlta (@ModelAttribute DataCliente datos) {
		Cliente clientenuevo = new Cliente (datos.getNombre(),
											datos.getApellido(),
											datos.getDataLogin().getEmail(),
											datos.getDataLogin().getPassword());
	
		clienteServicios.alta(clientenuevo);		
		return "main";
		
	}
	

}
