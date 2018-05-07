package com.computerspace.appweb.servicios;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerspace.appweb.DataCliente;
import com.computerspace.appweb.modelo.Cliente;
import com.computerspace.appweb.modelo.ClienteRepository;
import com.computerspace.appweb.modelo.Comentario;
import com.computerspace.appweb.modelo.ComentarioRepository;

@Service
public class ClienteServicios {

	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ComentarioRepository comentarioRepository;

	public List<DataCliente> listaClientes() {
		List<DataCliente> datos = new ArrayList<DataCliente>();
		List<Cliente> clientes = clienteRepository.findAll();
		for (Cliente c : clientes) {
			DataCliente dc = new DataCliente();

			dc.setIdcliente(c.getIdclientes());
			dc.setNombre(c.getNombre());
			dc.setApellido(c.getApellidos());

			datos.add(dc);
		}

		return datos;
	}

	public boolean alta(Cliente cliente) {
		return (clienteRepository.save(cliente) != null);

	}

	public boolean validarCliente(String email, String password) {
		boolean retVal = false;
		Cliente c = clienteRepository.findByEmail(email);
		if (c != null) {
			if (c.getPassword().equals(password))
				retVal = true;
		}
		return retVal;
	}

	public boolean bajaCliente(String id) {
		boolean retVal = false;
		try {
			clienteRepository.deleteById(Long.valueOf(id));

			retVal = true;
		} catch (Exception e) {
			retVal = false;
		}
		return retVal;
	}

	public boolean modificarCliente(Long id, DataCliente datos) {
		boolean retVal = false;
		try {
			Cliente cliente = clienteRepository.findByIdclientes(id);
			cliente.setNombre(datos.getNombre());
			cliente.setApellidos(datos.getApellido());
			cliente.setPassword(datos.getDataLogin().getPassword());
			cliente.setEmail(datos.getDataLogin().getEmail());
			clienteRepository.save(cliente);
			retVal = true;
		} catch (Exception e) {
			retVal = false;
		}
		return retVal;
	}

	public boolean añadirclienteconcomentarios(String email, String password) {
		boolean retVal = false;

		Cliente cli1 = new Cliente("nombre4", "apellido4", "email7", "contraseña");
		Set<Comentario> comentarios = new HashSet<Comentario>();
		Comentario c1 = new Comentario("comentario 1");
		c1.setCliente(cli1);
		comentarios.add(c1);

		Comentario c2 = new Comentario("comentario 2");
		c2.setCliente(cli1);
		comentarios.add(c2);

		cli1.setComentarios(comentarios);
		clienteRepository.save(cli1);

		return retVal;
	}

	public boolean añadircomentarios(String email, String password) {
		boolean retVal = false;

		Cliente c = clienteRepository.findByEmail("email7");

		Comentario ck = new Comentario("comentario nuevo para el usuario email7");
		ck.setCliente(c);
		c.getComentarios().add(ck);
		clienteRepository.save(c);

		return retVal;
	}

	public boolean recuperarcomentarios(String email, String password) {
		boolean retVal = false;

		Comentario co = comentarioRepository.findById(1L).get();

		return retVal;
	}

}
