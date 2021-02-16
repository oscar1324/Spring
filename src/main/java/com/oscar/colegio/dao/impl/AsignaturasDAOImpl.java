package com.oscar.colegio.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oscar.colegio.dao.AsignaturasDAO;
import com.oscar.colegio.dtos.Asignatura;
import com.oscar.colegio.entities.AsignaturasEntity;
import com.oscar.colegio.repositorios.AsignaturaRepository;

@Service
public class AsignaturasDAOImpl implements AsignaturasDAO {
	
	@Autowired
	private AsignaturaRepository AR;

	@Override
	public List<Asignatura> obtenerAsignaturaPorIdNombreCursoTasa(Integer id, String nombre, Integer curso,
			Double tasa) {

		return AR.buscaAsignaturaPorIdNombreCursoTasa(id, nombre, curso, tasa);
	}

	@Override
	public Integer insertarAsignatura(Integer id, String nombre, Integer curso, Double tasa) {
		AsignaturasEntity as= new AsignaturasEntity(id, nombre, curso, tasa);
		AR.save(as);
		return 1;
	}

	@Override
	public Integer actualizarAsignatura(Integer id, String nombre, Integer curso, Double tasa) {
		AsignaturasEntity as = new AsignaturasEntity(id, nombre, curso, tasa);
		AR.save(as);
		return 1;
	}

	@Override
	public Integer eliminarAsignatura(Integer id) {
		AR.deleteById(id);
		return 1;
	}

	@Override
	public int obtenerNumeroAsignaturasMatriculadas(String idAlumno) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double obtenerTasaAsignatura(String idAsignatura) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
