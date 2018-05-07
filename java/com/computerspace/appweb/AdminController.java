package com.computerspace.appweb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.computerspace.appweb.servicios.ClienteServicios;
import com.computerspace.appweb.servicios.EmpleadoServicios;

@Controller
@RequestMapping (path="/administrarclientes")
public class AdminController {


		
//		@Autowired
//		ClienteServicios clienteServicios;
//		
//		@RequestMapping(path="clientes")
//		public String listaClientes (Model model) {
//		List<DataCliente> clientes = clienteServicios.listaClientes();
//		model.addAttribute("clientes", clientes);
//			
//		return "administrarclientes";
//		}
		
		@GetMapping
		public String verclientes (Model model) {
			
			
			return "verclientes";
		}


//	@RequestMapping ("baja/{id}")
//	public String baja (@PathVariable String id, Model model) {
//		//poner el metodo para dar de baja
//		long v = Long.parseLong(id);
////		model.addAttribute("id", "")
//		return "verclientes";
//		}
	}

