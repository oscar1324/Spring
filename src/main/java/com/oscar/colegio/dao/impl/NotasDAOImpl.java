package com.oscar.colegio.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oscar.colegio.dao.NotasDAO;
import com.oscar.colegio.dtos.NotaDTO;
import com.oscar.colegio.entities.AlumnoEntity;
import com.oscar.colegio.entities.AsignaturasEntity;
import com.oscar.colegio.entities.NotaEntity;
import com.oscar.colegio.repositorios.AlumnoRepository;
import com.oscar.colegio.repositorios.AsignaturaRepository;
import com.oscar.colegio.repositorios.NotasRepository;

@Service
public class NotasDAOImpl implements NotasDAO{
	@Autowired
	private AlumnoRepository AlumnoR;
	
	@Autowired
	private AsignaturaRepository AsigR;
	
	@Autowired
	private NotasRepository NotaR;

	@Override
	public List<NotaDTO> obtenerNotaPorIdNombreAsignaturaNotaFecha(Integer idAlumno, String nombre, String asignatura,
			Double nota, String fecha) {
		List<NotaDTO> listaNotas = NotaR.buscarPorAlumnoAsignaturaNotaFecha(idAlumno, nombre, asignatura,
				nota, fecha);
		return listaNotas;
	}



	@Override
	public Integer insertarNota(Integer idAlumno, Integer idAsignatura, Double nota, String fecha) {
		AlumnoEntity alumnoEntity = AlumnoR.findById(idAlumno).get();
		AsignaturasEntity asig = AsigR.findById(idAsignatura).get();
		NotaEntity notas = new NotaEntity( alumnoEntity, asig, nota, fecha);
		NotaR.save(notas);
		return 1;
	}

	@Override
	public Integer actualizarNota(Integer idNota, String idAlumno, String idAsignatura, Double nota, String fecha) {
		//List<NotaDTO> listaNotas = NotaR.buscarPorAlumnoAsignaturaNotaFecha(idAlumno, idAlumno, idAsignatura, nota, fecha);
		return 1;
	}

	@Override
	public Integer eliminarNota(Integer id) {
		NotaR.deleteById(id);
		return 1;
	}

	@Override
	public List<NotaDTO> obtenerNotaPorNombreAsignaturaFecha(String nombre, String asignatura, String fecha) {
		// TODO Auto-generated method stub
		return null;
	}


}
