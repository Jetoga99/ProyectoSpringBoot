package com.knifeserviceit.knifeservicedb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.knifeserviceit.knifeservicedb.model.Desarrollador;
import com.knifeserviceit.knifeservicedb.model.Servicios;
import com.knifeserviceit.knifeservicedb.service.ServiciosService;

@RestController
@RequestMapping(path= "/api/servicios/")
public class ServiciosController {
 private final ServiciosService serviceService ;
@Autowired
 public ServiciosController(ServiciosService serviceService) {
	super();
	this.serviceService = serviceService;
}
 
 @GetMapping
	public List<Servicios> getAllServicios(){
		return serviceService.getServicios();
	}//get all records from servicios table 
 
 
 @GetMapping(path= "{servId}")//http://localhost:8080/api/servicios/1
	public Servicios getServicio(@PathVariable("servId") Long id) {
		return serviceService.getServicio(id);
	}//this function gets the specified id data
 
	@DeleteMapping(path= "{servId}")//http://localhost:8080/api/servicios/1
	public Servicios deleteServicio(@PathVariable("servId") Long id) {
		return serviceService.deleteServicio(id);
		
	}//this function gets and deletes the specified id data
	
	@PostMapping
	public Servicios addServicio(@RequestBody Servicios servicio) {
		return serviceService.AddServicio(servicio);
	}//this function allows you to add a new record
	
	@PutMapping(path= "{servId}")//http://localhost:8080/api/servicios/1
	public Servicios updateServiciodta(@PathVariable("servId") Long id,
			@RequestParam (required = false) String servicio_nombre,
			@RequestParam (required = false) String servicio_descripcion,
			@RequestParam (required = false) String imagen) 
		{
		return serviceService.addServicio(id, servicio_nombre, servicio_descripcion, imagen);
		}// updateServicio
	

	
}
