package com.oscar.colegio.dao;

import java.util.List;

import com.oscar.colegio.dtos.NotaDTO;

public interface NotasDAO{

	List<NotaDTO> obtenerTodasNotas();
	List<NotaDTO> obtenerNotaPorIdNombreAsignaturaNotaFecha(String idAlumno, String nombre, String asignatura, String nota, String fecha); 
	List<NotaDTO> obtenerNotaPorNombreAsignaturaFecha(String nombre, String asignatura, String fecha); 
	Integer insertarNota(String idAlumno, String idAsignatura,String nota, String fecha);
	Integer actualizarNota(String idNota, String idAlumno, String idAsignatura, String nota, String fecha);
	Integer eliminarNota(String id);
}
