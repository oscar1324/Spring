package com.oscar.colegio.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.oscar.colegio.entities.NotaEntity;

public interface NotasRepository extends CrudRepository<NotaEntity, Integer> {
	
	/*String jpql = "select new com.kike.colegio.dtos.NotaDTO(n.id, a.id, a.nombre, asig.id, asig.nombreAsignatura, n.nota, n.fecha) "
		+ "FROM NotasEntity n JOIN AlumnoEntity a ON n.alumnos.id = a.id " 
		+ "JOIN AsignaturasEntity asig ON n.asignaturas.id = asig.id "
		+ "WHERE CAST(a.id AS string) LIKE :idAlumno AND a.nombre LIKE :nombre AND asig.nombreAsignatura LIKE :asignatura "
		+ "AND CAST(n.nota AS string) LIKE :nota AND n.fecha LIKE :fecha";
	 * */
	//@Query(value = "select new com.oscar.dtos.NotaDTO ()")
	
}
