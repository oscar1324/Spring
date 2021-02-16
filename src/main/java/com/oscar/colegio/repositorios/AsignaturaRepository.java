package com.oscar.colegio.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.oscar.colegio.dtos.Asignatura;
import com.oscar.colegio.entities.AlumnoEntity;
import com.oscar.colegio.entities.AsignaturasEntity;

public interface AsignaturaRepository extends CrudRepository<AsignaturasEntity, Integer> {
	
	// Query	
	@Query(	
			value= " select new com.oscar.colegio.dtos.Asignatura "
					+ " (a.id, a.nombre, a.curso, a.tasa) "
					+ "FROM AsignaturasEntity a where  (a.id LIKE CONCAT('%',:id,'%') or :id is null) "
					+ "AND a.nombre LIKE CONCAT('%',:nombre,'%')  "
					+ "AND (a.curso LIKE CONCAT('%',:curso,'%') or :curso is null)"
					+ "AND (a.tasa LIKE CONCAT('%',:tasa,'%') or :tasa is null) ")
	List<Asignatura>buscaAsignaturaPorIdNombreCursoTasa(
			@Param("id")Integer id,@Param("nombre") String nombre,
			@Param("curso") Integer curso,
			@Param("tasa") Double tasa);
	
	
	
		
//	@Query(value = "select new com.oscar.colegio.dtos.Asignatura (a.id, a.nombre, a.curso, a.tasa) "
//			+ "FROM com.oscar.colegio.entities.AsignaturasEntity a "
//			+ "WHERE (a.id LIKE CONCAT('%',:id,'%') or :id is null) "
//			+ "AND a.nombre LIKE CONCAT('%',:nombre,'%')"
//			+ "AND a.curso LIKE CONCAT ('%', :curso, '%')"
//			+ "AND a.tasa LIKE CONCAT ('%', :tasa, '%')")
}
