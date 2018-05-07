package com.computerspace.appweb.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerspace.appweb.modelo.Cliente;
import com.computerspace.appweb.modelo.ClienteRepository;
import com.computerspace.appweb.modelo.Empleado;

@Service
public class AdminServicios {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	
	public boolean  validaradminnoseusa (String email, String password, int permiso) {
		boolean retVal = false;
		Cliente c = clienteRepository.findByEmail(email);
		if ( c != null) {
			if (c.getPassword().equals(password))
				retVal = true;
		}
		return retVal;
	}
}
