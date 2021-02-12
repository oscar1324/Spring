package com.oscar.colegio.dao;
import java.util.List;

import com.oscar.colegio.dtos.AlumnoDTO;
public interface AlumnoDAO{
	
	List<AlumnoDTO> obtenerTodosAlumnos();
	List<AlumnoDTO> obtenerAlumnosporIdyNombre(String id, String nombre);
	Integer insertarAlumno(String id, String nombre, String idMunicipio, String familia_numerosa);
	Integer actualizarAlumno(String idOld, String idNew, String nombre, String idMunicipio, String familia_numerosa);
	Integer borrarAlumno (String id);
	
	public boolean esFamiliaNumerosa(String idAlumno);
}
