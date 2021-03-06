package com.kruger.practica.modelo;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "vacunacion", uniqueConstraints = { @UniqueConstraint(columnNames = { "dosis" }) })
public class Vacunacion {
	
	@Id
	@Column(name = "codigo")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer codigo;
	
	@Column(name = "fechavacunacion")
	Date fechaVacunacion;
	
	@Column(name = "dosis")
	private Integer dosis;
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "cempleado")
	private Empleado empleado;
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "cvacuna")
	private Vacuna vacuna;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Date getFechaVacunacion() {
		return fechaVacunacion;
	}

	public void setFechaVacunacion(Date fechaVacunacion) {
		this.fechaVacunacion = fechaVacunacion;
	}

	public Integer getDosis() {
		return dosis;
	}

	public void setDosis(Integer dosis) {
		this.dosis = dosis;
	}

	public Empleado getCempleado() {
		return empleado;
	}

	public void setCempleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Vacuna getCvacuna() {
		return vacuna;
	}

	public void setCvacuna(Vacuna vacuna) {
		this.vacuna = vacuna;
	}
	
	

}
