package com.eoi.GestionEmpleados.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
@Table(name="empleados")
public class Empleado implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long id;
	
	@Column
	@NotBlank(message="El nombre es obligatorio.") //Ni vacío ni nulo
	private String nombre;
	
	@Column
	@NotBlank(message="Los apellidos son obligatorios.")
	private String apellidos;
	
	@Column(unique=true)
	@NotNull //No nulo
	@Email(message="Introduzca el email correctamente.") //Formato de email
	private String email;
	
	@Column
	//@NotBlank(message="El teléfono es obligatorio.")
	@Min(600000000) //Obligamos a ese intervalo
	@Max(699999999)
	private int telefono;
	
	@Column
	//@NotBlank(message="Indique su fecha de nacimiento (yyyy-mm-dd).")
	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;
	
	@Column
	//@NotBlank(message="Indique su fecha de contratación (yyyy-mm-dd).")
	@Temporal(TemporalType.DATE)
	private Date fechaContratacion;
	
	@Column(scale=2)
	//@NotBlank(message="El salario anual es obligatorio.")
	@Positive //Solamente positivo
	private double salario;
	
	@Column(unique=true)
	//@NotBlank(message="El número de la Seguridad Social es obligatorio.")
	@Size(min=12, max=12) //Para obligar a que sean 12 números
	private String numeroSS;
	
	@Column
	@NotBlank(message="La dirección es obligatoria.")
	private String direccion;
	
	public Empleado() {
		
	}
	
	public Empleado(Long id, String nombre, String apellidos, String email, int telefono, Date fechaNacimiento,
			Date fechaContratacion, double salario, String numeroSS, String direccion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.telefono = telefono;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaContratacion = fechaContratacion;
		this.salario = salario;
		this.numeroSS = numeroSS;
		this.direccion = direccion;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Date getFechaContratacion() {
		return fechaContratacion;
	}

	public void setFechaContratacion(Date fechaContratacion) {
		this.fechaContratacion = fechaContratacion;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getNumeroSS() {
		return numeroSS;
	}

	public void setNumeroSS(String numeroSS) {
		this.numeroSS = numeroSS;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellidos, direccion, email, fechaContratacion, fechaNacimiento, id, nombre, numeroSS,
				salario, telefono);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		return Objects.equals(apellidos, other.apellidos) && Objects.equals(direccion, other.direccion)
				&& Objects.equals(email, other.email) && Objects.equals(fechaContratacion, other.fechaContratacion)
				&& Objects.equals(fechaNacimiento, other.fechaNacimiento) && id == other.id
				&& Objects.equals(nombre, other.nombre) && numeroSS == other.numeroSS
				&& Double.doubleToLongBits(salario) == Double.doubleToLongBits(other.salario)
				&& telefono == other.telefono;
	}

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email
				+ ", telefono=" + telefono + ", fechaNacimiento=" + fechaNacimiento + ", fechaContratacion="
				+ fechaContratacion + ", salario=" + salario + ", numeroSS=" + numeroSS + ", direccion=" + direccion
				+ "]";
	}
	
	
}
