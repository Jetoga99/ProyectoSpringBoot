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

import com.knifeserviceit.knifeservicedb.model.ChangePassword;
import com.knifeserviceit.knifeservicedb.model.Desarrollador;
import com.knifeserviceit.knifeservicedb.service.DesarrolladorService;

@RestController
@RequestMapping(path="/api/desarrollador/")
public class DesarrolladorController {
	private final DesarrolladorService desarrolladorService;
	@Autowired
	public DesarrolladorController(DesarrolladorService desarrolladorService) {
		super();
		this.desarrolladorService = desarrolladorService;
	}//constructor of DesarrolladorService
	
	@GetMapping
	public List<Desarrollador> getAllDesarrolladores(){
		return desarrolladorService.getDesarrollador();
	}//get all records from Desarrollador table 
	
	@GetMapping(path= "{devId}")//http://localhost:8080/api/desarrollador/1
	public Desarrollador getDeveloper(@PathVariable("devId") Long id) {
		return desarrolladorService.getDesarrollador(id);
	}//this function gets the specified id data
	
	@DeleteMapping(path= "{devId}")//http://localhost:8080/api/desarrollador/1
	public Desarrollador deleteDeveloper(@PathVariable("devId") Long id) {
		return desarrolladorService.deleteDesarrollador(id);
		
	}//this function gets and deletes the specified id data
	
	@PostMapping
	public Desarrollador addDeveloper(@RequestBody Desarrollador desarrollador) {
		return desarrolladorService.AddDeveloper(desarrollador);
	}//this function allows you to add a new record
	
	@PutMapping(path= "{devId}")//http://localhost:8080/api/desarrollador/1
	public Desarrollador updateDeveloperdta(@PathVariable("devId") Long id,
			@RequestParam (required = false) String nombre,
			@RequestParam (required = false) String apellidos, 
			@RequestParam (required = false) Long proyecto_Id,
			@RequestParam (required = false) Long tipo_desarrollador)
	{
return desarrolladorService.updateDeveloper(id, nombre, apellidos,proyecto_Id,tipo_desarrollador);
		}//UPDATE DEVELOPER INFORMATION BUT NOT EMAIL NEITHER PASSWORD 
	
	
	
	@PostMapping(path= "{devId}")//http://localhost:8080/api/desarrollador/1
	public Desarrollador changePassword(@PathVariable("devId") Long id,
		@RequestBody ChangePassword Change_Password)
	{
return desarrolladorService.Change_Password(id,Change_Password.getPassword(),Change_Password.getNewpassword() );
		}
	
	
	
	

}
