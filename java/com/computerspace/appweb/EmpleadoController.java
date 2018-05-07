package com.computerspace.appweb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.computerspace.appweb.modelo.Cliente;
import com.computerspace.appweb.modelo.ClienteRepository;
import com.computerspace.appweb.modelo.Empleado;
import com.computerspace.appweb.servicios.ClienteServicios;
import com.computerspace.appweb.servicios.EmpleadoServicios;

@Controller
@RequestMapping(path = "/admin")
public class EmpleadoController {
	@Autowired
	ClienteServicios clienteServicios;
	@Autowired
	EmpleadoServicios empleadoServicios;

	@RequestMapping(path = "clientes")
	public String listaClientes(Model model) {
		List<DataCliente> clientes = clienteServicios.listaClientes();
		model.addAttribute("clientes", clientes);

		return "administrarclientes";
	}

	@GetMapping
	public String login(Model model) {
		model.addAttribute("loginempleado", new DataEmpleadoLogin());

		return "loginempleado";
	}

	@PostMapping
	public String result(@ModelAttribute DataEmpleadoLogin datos, Model model) {

		String pagina = null;

		int permiso = empleadoServicios.validarEmpleado(datos.getEmail(), datos.getPassword());

		if (permiso == 0)
			pagina = "error_login";

		if (permiso == 1)
			pagina = "verclientes";

		if (permiso == 2) {
			List<DataCliente> clientes = clienteServicios.listaClientes();
			model.addAttribute("clientes", clientes);
			pagina = "administrarclientes";
		}

		return pagina;
	}

	@RequestMapping("baja/{id}")
	public String baja(@PathVariable String id, Model model) {
		long v = Long.parseLong(id);
		clienteServicios.bajaCliente(id);
		// model.addAttribute("id", "")
		return "administrarclientes";
	}

	@GetMapping("modificar/{id}")
	public String modificar(@PathVariable String id, Model model) {
		DataCliente dataCliente = new DataCliente();
		dataCliente.setDataLogin(new DataLogin());
		dataCliente.setIdcliente(Long.valueOf(id));

		dataCliente.setNombre(dataCliente.getNombre());
		dataCliente.setApellido(dataCliente.getApellido());
		model.addAttribute("modificar", dataCliente);

		return "modificar";
	}

	@PostMapping("modificar/{id}")
	public String postModificar(@PathVariable Long id, @ModelAttribute DataCliente datos) {

		clienteServicios.modificarCliente(id, datos);

		return "administrarclientes";
	}

}
