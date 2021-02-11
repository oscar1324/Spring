package com.oscar.colegio.dtos;

public class Asignatura {
	
	private int id;
	private String nombre;
	private int curso;
	private Double tasa;
	
	public Asignatura() {
		super();
	}

	public Asignatura(int id, String nombre, int curso, Double tasa) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.curso = curso;
		this.tasa = tasa;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCurso() {
		return curso;
	}

	public void setCurso(int curso) {
		this.curso = curso;
	}

	public Double getTasa() {
		return tasa;
	}

	public void setTasa(Double tasa) {
		this.tasa = tasa;
	}
	
	
}
