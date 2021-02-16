package com.oscar.colegio.dao;

import java.util.List;

import com.oscar.colegio.dtos.Asignatura;

public interface AsignaturasDAO {
	List<Asignatura> obtenerAsignaturaPorIdNombreCursoTasa(Integer id, String nombre, Integer curso, Double tasa);
	Integer insertarAsignatura(Integer id, String nombre, Integer curso, Double tasa);
	Integer actualizarAsignatura(Integer id, String nombre, Integer curso, Double tasa);
	Integer eliminarAsignatura(Integer id);
	int obtenerNumeroAsignaturasMatriculadas(String idAlumno);
	double obtenerTasaAsignatura(String idAsignatura);
}
