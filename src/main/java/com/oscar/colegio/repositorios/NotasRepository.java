package com.oscar.colegio.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.oscar.colegio.dtos.NotaDTO;
import com.oscar.colegio.entities.NotaEntity;

public interface NotasRepository extends CrudRepository<NotaEntity, Integer> {
	
	@Query(value = "select new com.oscar.colegio.dtos.NotaDTO (a.id, m.id, m.nombre, asig.id, asig.nombre, a.nota, a.fecha) "
			+ "FROM com.oscar.colegio.entities.NotaEntity a, com.oscar.colegio.entities.AlumnoEntity m, com.oscar.colegio.entities.AsignaturasEntity asig "
			+ "WHERE a.alumnos.id = m.id AND a.asignaturas.id=asig.id "
			+ "AND (m.id LIKE CONCAT('%', :id,'%') or :id is null) "
			+ "AND (m.nombre LIKE CONCAT ('%', :nombreAlumno, '%') or :nombreAlumno is null) "
			+ "AND (asig.nombre LIKE CONCAT ('%', :nombreAsignatura, '%') or :nombreAsignatura is null) "
			+ "AND (a.fecha LIKE CONCAT ('%', :fecha, '%') or :fecha is null) " // error fecha
			+ "AND (a.nota LIKE CONCAT ('%', :nota, '%') or :nota is null)    ")
	List<NotaDTO>buscarPorAlumnoAsignaturaNotaFecha(
			@Param("id") Integer idAlumno, 
			@Param("nombreAlumno")String nombreAlumno, 
			@Param("nombreAsignatura") String asignatura, 
			@Param("nota")Double nota, 
			@Param("fecha") String fecha);

	
}
