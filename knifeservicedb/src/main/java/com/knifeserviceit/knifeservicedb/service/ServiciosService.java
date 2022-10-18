package com.knifeserviceit.knifeservicedb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.knifeserviceit.knifeservicedb.model.Desarrollador;
import com.knifeserviceit.knifeservicedb.model.Servicios;

@Service
public class ServiciosService {

	private final ServiciosRepository serviciosRepository;
	@Autowired
	public ServiciosService(ServiciosRepository serviciosRepository) {
		super();
		this.serviciosRepository = serviciosRepository;
	}
	public List<Servicios> getServicios(){
		return serviciosRepository.findAll();
	}//get all servicios method
	
	public Servicios getServicio(Long id) {
		return serviciosRepository.findById(id).orElseThrow(
				()-> new IllegalArgumentException("El servicio con Id " 
						+ id + " No existe en la base de datos"));
	}//query to get the service specified
	
	public Servicios deleteServicio(Long id) {
		Servicios tempServ =null;
		if(serviciosRepository.existsById(id)) {
			tempServ = serviciosRepository.findById(id).get();
			serviciosRepository.deleteById(id);
		}//if servicio exist then
		return tempServ;
	}
	public Servicios AddServicio(Servicios servicios){
		return serviciosRepository.save(servicios);
	}//function that saves data from desarrollador table
	
	public Servicios addServicio(Long Id, String servicio_nombre, 
			String servicio_descripcion, String imagen) {
			Servicios tempServ = null;
			if (serviciosRepository.existsById(Id)) {
				tempServ = serviciosRepository.findById(Id).get();
			if (servicio_nombre!= null) tempServ.setServicio_nombre(servicio_nombre);
			if(servicio_descripcion!=null) tempServ.setServicio_descripcion(servicio_descripcion);
			if(imagen !=null) tempServ.setImagen(imagen);
			serviciosRepository.save(tempServ);
			
			
		}else {
			System.out.println("update - El Servicio con Id: " + Id +" No esxiste en la base de datos");
			
		}//if exist 
		return tempServ;
		
	}//update developer data
	
}
