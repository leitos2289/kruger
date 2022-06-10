package com.kruger.practica.modelo;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "empleado")
public class Empleado {
	
	@Id
	@Column (name = "cempleado")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cempleado;
	
	@Column(name = "cedula", nullable = false, length = 10)
	private String cedula;
	
	@Column(name = "nombre", nullable = false)
	private String nombre;
	@Column(name = "apellido", nullable = false)
	private String apellido;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "fechanacimiento")
	private Date fechaNacimiento;
	
	@Column(name = "direccion")
	private String Direccion;
	
	@Column(name = "movil")
	private String movil;
	
	@Column(name = "vacunado")
	private boolean vacunado;
	
	public Integer getCempleado() {
		return cempleado;
	}
	public void setCempleado(Integer cempleado) {
		this.cempleado = cempleado;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getDireccion() {
		return Direccion;
	}
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	public String getMovil() {
		return movil;
	}
	public void setMovil(String movil) {
		this.movil = movil;
	}
	public boolean isVacunado() {
		return vacunado;
	}
	public void setVacunado(boolean vacunado) {
		this.vacunado = vacunado;
	}
}
