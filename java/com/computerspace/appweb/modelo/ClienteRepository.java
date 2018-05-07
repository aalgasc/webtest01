package com.computerspace.appweb.modelo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClienteRepository extends JpaRepository <Cliente, Long>{

	Cliente findByEmail(String email);
	
	//consulta para buscar por nombre
//	@Query ("SELECT c FROM Cliente c WHERE c.nombre = :nombre")
//	public List<Cliente>busca (@Param("nombre") String nombre);

	
	
	Cliente findByIdclientes (long idclientes);

	
	
}
