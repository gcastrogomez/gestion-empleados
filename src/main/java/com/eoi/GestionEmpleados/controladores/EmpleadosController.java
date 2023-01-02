package com.eoi.GestionEmpleados.controladores;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.eoi.GestionEmpleados.entidades.Empleado;
import com.eoi.GestionEmpleados.servicios.EmpleadosService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/gestion_empleados")
public class EmpleadosController {
	@Autowired
	private EmpleadosService empleadoService;
	
	@Operation(summary = "Obtiene toda la lista de empleados")
	@GetMapping() //Con el Get, listamos todos los empleados
	public List<Empleado> list() {
		return empleadoService.findAll();
	}
	
	@Operation(summary = "Obtiene un empleado por su id")
	@GetMapping("/{id}") //Con el Get, elegiremos un empleado por id
	public Empleado findById(@PathVariable Long id) {
		return empleadoService.findById(id);
	}
	
	@Operation(summary = "Añade un empleado a la lista")
	@PostMapping() //Con el post, añadimos un empleado por id
	public Empleado insert(@Valid @RequestBody Empleado e) {
	return empleadoService.insert(e);
	}
	@Operation(summary = "Modifica un empleado de la lista")
	@PutMapping("/{id}") //Con el Put, modificamos un empleado con su id
	public Empleado update(@PathVariable long id,@Valid @RequestBody Empleado e) {
	return empleadoService.update(id, e);
	}
	@Operation(summary = "Elimina un empleado de la lista")
	@DeleteMapping("/{id}") //Con el Delete, borramos un empleado con su id
	public void delete(@PathVariable long id) {
	empleadoService.delete(id);
	}
	/*@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }*/
}
