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

import com.knifeserviceit.knifeservicedb.model.Proyecto_Servicios;
import com.knifeserviceit.knifeservicedb.model.Tipo_desarrollador;
import com.knifeserviceit.knifeservicedb.service.Proyecto_ServicioRepository;
import com.knifeserviceit.knifeservicedb.service.Proyecto_ServiciosService;

@RestController
@RequestMapping(path="/api/proyecto_servicios/")
public class Proyecto_ServiciosController {
	private Proyecto_ServiciosService proyecto_serviciosService;
	@Autowired
	
	public Proyecto_ServiciosController(Proyecto_ServiciosService proyecto_serviciosService) {
		super();
		this.proyecto_serviciosService = proyecto_serviciosService;
	}

	@GetMapping
	public List<Proyecto_Servicios> getAllProjects_serv(){
		return proyecto_serviciosService.getAllProjects_serv();
	}//this gets all data 
	
	@GetMapping(path="{idP_S}")//http://localhost:8080/api/proyecto_servicios/1
	public Proyecto_Servicios getP_S(@PathVariable("idP_S") Long id) {
		return proyecto_serviciosService.getproject_serv(id);
		
	}//gettypedev
	
	@DeleteMapping(path= "{idP_S}")
	public Proyecto_Servicios deleteP_S(@PathVariable("idP_S") Long id) {
		return proyecto_serviciosService.deleteproject_serv(id);
		
	}//this method deletes the specified id data 
	
	@PostMapping
	public Proyecto_Servicios addP_S(@RequestBody Proyecto_Servicios proyecto_servicios) {
		return proyecto_serviciosService.addP_S(proyecto_servicios);
	}//this method adds a new register in the table
	
	@PutMapping(path ="{idP_S}")
	public Proyecto_Servicios updateP_D(@PathVariable("idP_S") Long Id,
		@RequestParam (required = false) Long proyecto_id,
		@RequestParam (required = false) Long servicio_id) {
		
		return proyecto_serviciosService.updateP_S(Id, proyecto_id, servicio_id);
	}//function that allows you to change some information regarding the data
	
	

}//Proyecto_servicios
