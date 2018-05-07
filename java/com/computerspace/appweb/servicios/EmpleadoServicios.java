package com.computerspace.appweb.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerspace.appweb.modelo.Cliente;
import com.computerspace.appweb.modelo.ClienteRepository;
import com.computerspace.appweb.modelo.Empleado;
import com.computerspace.appweb.modelo.EmpleadoRepository;

@Service
public class EmpleadoServicios {
	
	@Autowired
	private EmpleadoRepository empleadoRepository;
	private ClienteRepository clienteRepository;
	
//	public boolean baja (Cliente cliente) {
//		return (clienteRepository.delete(cliente));
//		
//	}
	
	public int  validarEmpleado (String email, String password) {
		int retVal = 0;	
		Empleado e = empleadoRepository.findByEmail(email);
		if ( e != null) {
			if (e.getPassword().equals(password)){
				retVal = e.getPermiso().intValue();
		}
		
	}
		return retVal;
}
}
