package com.oscar.colegio.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.oscar.colegio.dtos.AlumnoDTO;
import com.oscar.colegio.entities.AlumnoEntity;
import com.oscar.colegio.entities.MunicipiosEntity;

@Repository
public interface AlumnoRepository extends CrudRepository<AlumnoEntity, Integer>{
	
	@Query(value = "select new com.oscar.colegio.dtos.AlumnoDTO (a.id, a.nombre, m.nombre, m.idMunicipio, a.famNumerosa) "
			+ "FROM com.oscar.colegio.entities.AlumnoEntity a, com.oscar.colegio.entities.MunicipiosEntity m "
			+ "WHERE a.idMunicipio = m.idMunicipio "
			+ "AND (a.id LIKE CONCAT('%',:id,'%') or :id is null)" // is null para que lo tenga en cuenta
			+ "AND a.nombre LIKE CONCAT ('%',:nombre,'%')")
		List<AlumnoDTO>buscarAlumnoporIDyNombre(@Param("id") Integer id, @Param("nombre") String nombre); // Enchufo los valores aen  la query

}
