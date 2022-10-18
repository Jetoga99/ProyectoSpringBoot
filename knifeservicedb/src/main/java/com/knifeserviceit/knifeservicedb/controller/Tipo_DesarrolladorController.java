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

import com.knifeserviceit.knifeservicedb.model.Tipo_desarrollador;
import com.knifeserviceit.knifeservicedb.service.Tipo_desarrollador_Service;

@RestController
@RequestMapping(path="/api/tipo_desarrollador/")
public class Tipo_DesarrolladorController {
	private final Tipo_desarrollador_Service tipo_desarrollador_Service;
	@Autowired
	public Tipo_DesarrolladorController(Tipo_desarrollador_Service tipo_desarrollador_Service) {
		super();
		this.tipo_desarrollador_Service = tipo_desarrollador_Service;
	}
	
	@GetMapping
	public List<Tipo_desarrollador> getallTypes(){
		return tipo_desarrollador_Service.getAllDevtype();
	}//this gets all data 
	
	@GetMapping(path="{idType}")//http://localhost:8080/api/tipo_desarrollador/1
	public Tipo_desarrollador gettypedev(@PathVariable("idType") Long id) {
		return tipo_desarrollador_Service.getDeveloper(id);
		
	}//gettypedev
	
	@DeleteMapping(path= "{idType}")
	public Tipo_desarrollador deletetypedev(@PathVariable("idType") Long id) {
		return tipo_desarrollador_Service.deleteTipo_desarrollador(id);
		
	}//this method deletes the specified id data 
	
	@PostMapping
	public Tipo_desarrollador addtypedev(@RequestBody Tipo_desarrollador tipo_desarrollador) {
		return tipo_desarrollador_Service.addTipo_desarrollador(tipo_desarrollador);
	}//this method adds a new register in the table
	
	@PutMapping(path ="{idType}")
	public Tipo_desarrollador updatetypedev(@PathVariable("idType") Long Id,
		@RequestParam (required = false) String descripcion) {
		
		return tipo_desarrollador_Service.updatetipo_desarrollador(Id, descripcion);
	}//function that allows you to change some information regarding the data
	
	
	
}
