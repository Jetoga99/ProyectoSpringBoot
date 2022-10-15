package com.knifeserviceit.knifeservicedb.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.knifeserviceit.knifeservicedb.model.Proyecto;
import com.knifeserviceit.knifeservicedb.model.Tipo_desarrollador;

@Service
public class ProyectoService {
private ProyectoRepositorio proyectorepositorio;
@Autowired
public ProyectoService(ProyectoRepositorio proyectorepositorio) {
	super();
	this.proyectorepositorio = proyectorepositorio;
}

public List<Proyecto> getAllProjects(){
	return proyectorepositorio.findAll();
}//gets all data 

public Proyecto getAProject(Long id) {
return proyectorepositorio.findById(id).orElseThrow(()->
new IllegalArgumentException("el proyecto con Id "+ id +" no existe en la base de datos"));
}//gets only the specific data

public Proyecto addProyecto(Proyecto proyecto) {
	return proyectorepositorio.save(proyecto);
}//this method saves the new record

public Proyecto deleteproyecto(Long id) {
	Proyecto temPro=null;
	if (proyectorepositorio.existsById(id)) {
		temPro= proyectorepositorio.findById(id).get();
		proyectorepositorio.deleteById(id);
		
	}//if exist 
	return temPro;
}//method that deletes a record

public Proyecto updateProyecto(Long id, String descripcion, Double costo, Date fecha_inicio, Date fecha_fin, String Cliente) {
	Proyecto temPro =null;
	if (proyectorepositorio.existsById(id)) {
		if(descripcion != null) temPro.setDescripcion(descripcion);
		if(costo != null) temPro.setCosto(costo.doubleValue());
		if(fecha_inicio != null) temPro.setFecha_inicio(fecha_inicio);
		if(fecha_fin != null) temPro.setFecha_fin(fecha_fin);
		if(Cliente != null) temPro.setCliente(Cliente);
	}else {
		System.out.println("update - El tipo de proyecto con Id: " + id +" No esxiste en la base de datos");
	}
	return temPro;

}//method to update data 




}
