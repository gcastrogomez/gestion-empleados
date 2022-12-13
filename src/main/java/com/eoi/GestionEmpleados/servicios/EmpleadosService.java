package com.eoi.GestionEmpleados.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eoi.GestionEmpleados.entidades.Empleado;
import com.eoi.GestionEmpleados.repositorios.EmpleadosRepository;

@Service
public class EmpleadosService {
	
	@Autowired //Inyectará el objeto Empleado
	private EmpleadosRepository empleadoRepository;
	
	public List<Empleado> findAll() { //Sirve para buscar todos los empleados
		return (List<Empleado>)empleadoRepository.findAll();
	}
	
	public Empleado findById(long id) { //Busca un empleado por ID
		return empleadoRepository.findById(id).orElse(null);
	}
	
	public Empleado insert(Empleado e) { //Inserta un nuevo empleado
		return empleadoRepository.save(e);
	}
	
	public Empleado update(long id, Empleado e) {
		e.setId(id);	//Actualiza un empleado
		return empleadoRepository.save(e);
	}
	
	public void delete(long id) { //Elimina un empleado
		empleadoRepository.deleteById(id);
	}
	
}
