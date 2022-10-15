//pojo de servicios

package com.knifeserviceit.knifeservicedb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="servicios")
public class Servicios {
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
@Column(name ="Servicios_Id", unique=true, nullable=false)
	private Long servicios_id;
	private String servicio_nombre;
	@Column(name="Servicio_Descripción")
	private String servicio_descripcion;
	@Column(name="Imagen")
	private String imagen;
	public Servicios(Long servicios_id, String servicio_nombre, String servicio_descripcion, String imagen) {
		super();
		this.servicios_id = servicios_id;
		this.servicio_nombre = servicio_nombre;
		  this.servicio_descripcion = servicio_descripcion;
		 this.imagen = imagen;
	}
	public Servicios () {}
	public String getServicio_nombre() {
		return servicio_nombre;
	}
	public void setServicio_nombre(String servicio_nombre) {
		this.servicio_nombre = servicio_nombre;
	}
	public String getServicio_descripcion() {
		return servicio_descripcion;
	}
	public void setServicio_descripcion(String servicio_descripcion) {
		this.servicio_descripcion = servicio_descripcion;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public Long getServicios_id() {
		return servicios_id;
	}
	
	

}
