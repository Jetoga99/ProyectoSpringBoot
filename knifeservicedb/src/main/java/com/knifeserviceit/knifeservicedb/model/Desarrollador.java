//SE ESTABLE LA CLASE POJO 

package com.knifeserviceit.knifeservicedb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity    //es una entidad
@Table(name="desarrollador")//estableciendo el nombre de la base de datos

public class Desarrollador {
@Id
@GeneratedValue(strategy =GenerationType.IDENTITY)
@Column(name="Desarrollador_Id", unique= true, nullable=false)
	private Long desarrollador_id;//read only
	private String Nombre;
	private String Apellidos;
	private String Email;
	private String Contraseña;
	@Column(name="Proyecto_Id")
	private Long proyecto_Id;
	@Column(name="Tipo_Desarrollador")
	private Long tipo_desarrollador;
	public Desarrollador(Long Desarrollador_Id, String nombre, String apellidos, String email, String contraseña,
			Long Proyecto_Id,  Long Tipo_Desarrollador) {
		super();
		this.desarrollador_id = Desarrollador_Id;
		this.Nombre = nombre; 
		this.Apellidos = apellidos;
		this.Email = email;
		this.Contraseña = contraseña;
		proyecto_Id = Proyecto_Id;
		tipo_desarrollador= Tipo_Desarrollador;
	}
	public Desarrollador() {}//constructor de classe 
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellidos() {
		return Apellidos;
	}
	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getContraseña() {
		return Contraseña;
	}
	public void setContraseña(String contraseña) {
		Contraseña = contraseña;
	}
	
	public Long getProyecto_Id() {
		return proyecto_Id;
	}
	public void setProyecto_Id(Long proyecto_Id) {
		this.proyecto_Id = proyecto_Id;
	}
	
	public Long getDesarrollador_Id() {
		return desarrollador_id;
	}
	
	
	public Long getTipo_desarrollador() {
		return tipo_desarrollador;
	}
	public void setTipo_desarrollador(Long tipo_desarrollador) {
		this.tipo_desarrollador = tipo_desarrollador;
	}
	@Override
	public String toString() {
		return "Desarrollador [desarrollador_id=" + desarrollador_id + ", Nombre=" + Nombre + ", Apellidos=" + Apellidos
				+ ", Email=" + Email + ", Contraseña=" + Contraseña + ", proyecto_Id=" + proyecto_Id
				+ ", tipo_desarrollador=" + tipo_desarrollador + "]";
	}
	

}
