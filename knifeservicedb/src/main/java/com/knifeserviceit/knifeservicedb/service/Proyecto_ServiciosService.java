package com.knifeserviceit.knifeservicedb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.knifeserviceit.knifeservicedb.model.Proyecto_Servicios;
import com.knifeserviceit.knifeservicedb.model.Tipo_desarrollador;

@Service
public class Proyecto_ServiciosService {
	private Proyecto_ServicioRepository proyecto_servicioRepository;
	@Autowired
	public Proyecto_ServiciosService(Proyecto_ServicioRepository proyecto_servicioRepository) {
		super();
		this.proyecto_servicioRepository = proyecto_servicioRepository;
	}
	
	public List<Proyecto_Servicios> getAllProjects_serv(){
		return proyecto_servicioRepository.findAll();
	}//method that allows you to get all records from table 
	
	public Proyecto_Servicios getproject_serv(Long id) {
		return proyecto_servicioRepository.findById(id).orElseThrow(()->new IllegalArgumentException(
		"El proyecto_servicios con Id " + id +" No existe en la base de datos"));
		
	}//this method returns the data that matches with the id 
	
	public Proyecto_Servicios addP_S(Proyecto_Servicios proyecto_servicios) {
		return proyecto_servicioRepository.save(proyecto_servicios);
	}//this method saves the new record
	
	public Proyecto_Servicios deleteproject_serv(Long id) {
		Proyecto_Servicios	temP_S=null;
		if (proyecto_servicioRepository.existsById(id)) {
			temP_S= proyecto_servicioRepository.findById(id).get();
			proyecto_servicioRepository.deleteById(id);
			
		}//if exist 
		return temP_S;
	}//method that deletes a record
	
	public Proyecto_Servicios updateP_S(Long Id,Long proyecto_id, Long servicio_id) {
		Proyecto_Servicios temP_S =null;
		if (proyecto_servicioRepository.existsById(Id)) {
			if(proyecto_id != null) temP_S.setProyecto_Id(proyecto_id);
			if(servicio_id != null) temP_S.setServicios_Id(servicio_id);

		}else {
			System.out.println("update - El Proyecto con Id: " + Id +" No esxiste en la base de datos");
		}
		return temP_S;

	}//method to update data 
	
	
	
	
	
	
	
}
