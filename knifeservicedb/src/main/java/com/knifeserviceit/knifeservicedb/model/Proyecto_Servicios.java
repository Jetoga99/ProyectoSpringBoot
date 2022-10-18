package com.knifeserviceit.knifeservicedb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="proyecto_servicios")
public class Proyecto_Servicios {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="proy_serv_id", nullable=false, unique=true)
private Long Proy_Serv_Id;
@Column(name="Proyecto_Id")
private Long proyecto_Id;
@Column(name="Servicios_Id")
private Long servicios_Id;

public Proyecto_Servicios(Long proy_Serv_Id, Long proyecto_Id, Long servicios_Id) {
	super();
	Proy_Serv_Id = proy_Serv_Id;
	this.proyecto_Id = proyecto_Id;
	this.servicios_Id = servicios_Id;
}
public Proyecto_Servicios() {}
public Long getProyecto_Id() {
	return proyecto_Id;
}
public void setProyecto_Id(Long proyecto_Id) {
	this.proyecto_Id = proyecto_Id;
}
public Long getServicios_Id() {
	return servicios_Id;
}
public void setServicios_Id(Long servicios_Id) {
	this.servicios_Id = servicios_Id;
}
public Long getProy_Serv_Id() {
	return Proy_Serv_Id;
}
@Override
public String toString() {
	return "Proyecto_Servicios [Proy_Serv_Id=" + Proy_Serv_Id + ", proyecto_Id=" + proyecto_Id + ", servicios_Id="
			+ servicios_Id + "]";
}


}
