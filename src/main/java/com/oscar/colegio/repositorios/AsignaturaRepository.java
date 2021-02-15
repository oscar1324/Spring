package com.oscar.colegio.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.oscar.colegio.dtos.Asignatura;
import com.oscar.colegio.dtos.AsignaturaDTO;
import com.oscar.colegio.entities.AlumnoEntity;
import com.oscar.colegio.entities.AsignaturasEntity;

public interface AsignaturaRepository extends CrudRepository<AsignaturasEntity, Integer> {
	
	// Query	
	@Query(value = "select new com.oscar.colegio.dtos.Asignatura (a.id, a.nombre, a.curso, a.tasa) "
			+ "FROM com.oscar.colegio.entities.AsignaturasEntity a "
			+ "WHERE (a.id LIKE CONCAT('%',:id,'%') or :id is null) "
			+ "AND a.nombre LIKE CONCAT('%',:nombre,'%')")
			List<Asignatura>buscaAsignaturaporIdNombre(@Param("id") Integer id, @Param("nombre") String nombre);
	
}
