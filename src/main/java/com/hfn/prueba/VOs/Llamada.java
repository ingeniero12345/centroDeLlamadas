package com.hfn.prueba.VOs;

import java.time.LocalDate;
import java.util.Date;

public class Llamada {
private int id;
private LocalDate HoraInicio;
private LocalDate HoraFin;
private String estado;
private int idOperador;
public int getIdOperador() {
	return idOperador;
}
public void setIdOperador(int idOperador) {
	this.idOperador = idOperador;
}
public String getEstado() {
	return estado;
}
public void setEstado(String estado) {
	this.estado = estado;
}
private String descripcion;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public LocalDate getHoraInicio() {
	return HoraInicio;
}
public void setHoraInicio(LocalDate horaInicio) {
	HoraInicio = horaInicio;
}
public LocalDate getHoraFin() {
	return HoraFin;
}
public void setHoraFin(LocalDate horaFin) {
	HoraFin = horaFin;
}
public String getDescripcion() {
	return descripcion;
}
public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}
}
