package com.eoi.GestionEmpleados.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eoi.GestionEmpleados.entidades.Empleado;

@Repository
public interface EmpleadosRepository extends CrudRepository<Empleado,Long> {
	
}
