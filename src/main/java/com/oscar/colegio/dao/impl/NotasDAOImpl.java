package com.oscar.colegio.dao.impl;

import java.util.List;

import com.oscar.colegio.dao.NotasDAO;
import com.oscar.colegio.dtos.NotaDTO;

public class NotasDAOImpl implements NotasDAO{

	@Override
	public List<NotaDTO> obtenerTodasNotas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<NotaDTO> obtenerNotaPorIdNombreAsignaturaNotaFecha(String idAlumno, String nombre, String asignatura,
			String nota, String fecha) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<NotaDTO> obtenerNotaPorNombreAsignaturaFecha(String nombre, String asignatura, String fecha) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer insertarNota(String idAlumno, String idAsignatura, String nota, String fecha) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer actualizarNota(String idNota, String idAlumno, String idAsignatura, String nota, String fecha) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer eliminarNota(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
