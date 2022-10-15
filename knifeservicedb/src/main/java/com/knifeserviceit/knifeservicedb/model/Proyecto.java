package com.knifeserviceit.knifeservicedb.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.crypto.Data;

@Entity
@Table(name ="proyecto")
public class Proyecto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Proyecto_Id", nullable=false, unique=true)
	private Long proyecto_id;
	@Column(name="Descripción")
	private String descripcion;
	@Column(name ="Costo")
	private double costo;
	@Column(name="Fecha_Inicio")
	private Date fecha_inicio;
	@Column(name="Fecha_Fin")
	private Date fecha_fin;
	private String cliente ;
	public Proyecto(Long proyecto_id, String descripcion, double costo, Date fecha_inicio, Date fecha_fin,
			String cliente) {
		super();
		this.proyecto_id = proyecto_id;
		this.descripcion = descripcion;
		this.costo = costo;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.cliente = cliente;
	}
	public Proyecto () {}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}
	public Date getFecha_inicio() {
		return fecha_inicio;
	}
	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}
	public Date getFecha_fin() {
		return fecha_fin;
	}
	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public Long getProyecto_id() {
		return proyecto_id;
	}
	@Override
	public String toString() {
		return "Proyecto [proyecto_id=" + proyecto_id + ", descripcion=" + descripcion + ", costo=" + costo
				+ ", fecha_inicio=" + fecha_inicio + ", fecha_fin=" + fecha_fin + ", cliente=" + cliente + "]";
	}

}
