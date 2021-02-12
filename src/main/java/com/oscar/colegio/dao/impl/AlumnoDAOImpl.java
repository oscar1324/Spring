package com.oscar.colegio.dao.impl;

import java.util.List;

import com.oscar.colegio.dao.AlumnoDAO;
import com.oscar.colegio.dtos.AlumnoDTO;

public class AlumnoDAOImpl implements AlumnoDAO{
	
	

	@Override
	public List<AlumnoDTO> obtenerTodosAlumnos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AlumnoDTO> obtenerAlumnosporIdyNombre(String id, String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer insertarAlumno(String id, String nombre, String idMunicipio, String familia_numerosa) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer actualizarAlumno(String idOld, String idNew, String nombre, String idMunicipio,
			String familia_numerosa) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer borrarAlumno(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean esFamiliaNumerosa(String idAlumno) {
		// TODO Auto-generated method stub
		return false;
	}

}
