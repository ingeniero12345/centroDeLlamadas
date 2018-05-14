package com.hfn.prueba.VOs;

import java.util.Date;

public class Operador {
	private int id;
	private Boolean estadoDisponible;
	private String nombre;
	private int rol;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Boolean getEstadoDisponible() {
		return estadoDisponible;
	}
	public void setEstadoDisponible(Boolean estado) {
		this.estadoDisponible = estado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getRol() {
		return rol;
	}
	public void setRol(int rol) {
		this.rol = rol;
	}
	
}
