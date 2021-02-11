package com.oscar.colegio.entities;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;


@Entity
@Table(name = "matriculaciones")
public class MatriculacionesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "id_asignatura")
	private AsignaturasEntity asignaturas;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "id_alumno")
	private AlumnoEntity alumnos;
	
	@Column(name = "fecha")
	private String fecha;
	
	@Column(name = "activo")
	private Integer activo;
	
	/**
	 * @param id
	 * @param asignaturas
	 * @param alumnos
	 * @param fecha
	 * @param activo
	 */
	public MatriculacionesEntity(Integer id, AsignaturasEntity asignaturas, AlumnoEntity alumnos, String fecha,
			Integer activo) {
		super();
		this.id = id;
		this.asignaturas = asignaturas;
		this.alumnos = alumnos;
		this.fecha = fecha;
		this.activo = activo;
	}

	/**
	 * @param id
	 * @param asignaturas
	 * @param alumnos
	 * @param fecha
	 */
	public MatriculacionesEntity(AsignaturasEntity asignaturas, AlumnoEntity alumnos, String fecha) {
		super();
		this.asignaturas = asignaturas;
		this.alumnos = alumnos;
		this.fecha = fecha;
	}

	/**
	 * @param id
	 * @param asignaturas
	 * @param alumnos
	 * @param fecha
	 * @param activo
	 */
	public MatriculacionesEntity(int id, AsignaturasEntity asignaturas, AlumnoEntity alumnos, String fecha,
			int activo) {
		super();
		this.id = id;
		this.asignaturas = asignaturas;
		this.alumnos = alumnos;
		this.fecha = fecha;
		this.activo = activo;
	}

	/**
	 * @param asignaturas
	 * @param alumnos
	 * @param fecha
	 * @param activo
	 */
	public MatriculacionesEntity(AsignaturasEntity asignaturas, AlumnoEntity alumnos, String fecha, int activo) {
		super();
		this.asignaturas = asignaturas;
		this.alumnos = alumnos;
		this.fecha = fecha;
		this.activo = activo;
	}

	/**
	 * 
	 */
	public MatriculacionesEntity() {
		super();
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the asignaturas
	 */
	public AsignaturasEntity getAsignaturas() {
		return asignaturas;
	}

	/**
	 * @param asignaturas the asignaturas to set
	 */
	public void setAsignaturas(AsignaturasEntity asignaturas) {
		this.asignaturas = asignaturas;
	}

	/**
	 * @return the alumnos
	 */
	public AlumnoEntity getAlumnos() {
		return alumnos;
	}

	/**
	 * @param alumnos the alumnos to set
	 */
	public void setAlumnos(AlumnoEntity alumnos) {
		this.alumnos = alumnos;
	}

	/**
	 * @return the fecha
	 */
	public String getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the activo
	 */
	public int getActivo() {
		return activo;
	}

	/**
	 * @param activo the activo to set
	 */
	public void setActivo(int activo) {
		this.activo = activo;
	}

	
}