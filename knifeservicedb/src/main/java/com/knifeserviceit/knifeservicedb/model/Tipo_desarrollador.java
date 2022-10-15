package com.knifeserviceit.knifeservicedb.model;//this is the pojo script

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipo_desarrollador")
public class Tipo_desarrollador {
 @Id
 @GeneratedValue(strategy =GenerationType.IDENTITY)
 @Column(name="Tipo_Desarrollador_Id", unique=true, nullable=false)
 	private Long tipo_desarrollador_id;
 	@Column(name="Descripción")
 	private String descripcion;
	public Tipo_desarrollador(Long tipo_desarrollador_id, String descripcion) {
		super();
		this.tipo_desarrollador_id = tipo_desarrollador_id;
		this.descripcion = descripcion;
	}
	public Tipo_desarrollador() {}
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Long getTipo_desarrollador_id() {
		return tipo_desarrollador_id;
	}
	@Override
	public String toString() {
		return "Tipo_desarrollador [tipo_desarrollador_id=" + tipo_desarrollador_id + ", descripcion=" + descripcion
				+ "]";
	}
 	
 
}
