package com.computerspace.appweb.modelo;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmpleadoRepository extends JpaRepository <Empleado, Long>{

	Empleado findByEmail(String email);
	//consulta para buscar por nombre


	
	
}
