package com.knifeserviceit.knifeservicedb.controller;

import java.sql.Date;
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

import com.knifeserviceit.knifeservicedb.model.Proyecto;
import com.knifeserviceit.knifeservicedb.service.ProyectoService;

@RestController
@RequestMapping(path="/api/proyecto/" )
public class ProyectoController {
private ProyectoService proyectoservice;
@Autowired
public ProyectoController(ProyectoService proyectoservice) {
	super();
	this.proyectoservice = proyectoservice;
}
@GetMapping
public List<Proyecto> getAllProjects(){
	return proyectoservice.getAllProjects();
}
@GetMapping(path="{prjId}")
public Proyecto getaProject(@PathVariable("prjId") Long id) {
	return proyectoservice.getAProject(id);
}
@PostMapping
public Proyecto addProject(@RequestBody Proyecto proyecto) {
	return proyectoservice.addProyecto(proyecto);
}

@DeleteMapping(path="{idProy}")
public Proyecto deleteProject(@PathVariable("idProy") Long Id ) {
	return proyectoservice.deleteproyecto(Id);
}

@PutMapping(path="{idProy}")
public Proyecto updateProject(@PathVariable("idProy") Long Id,
		@RequestParam (required = false ) String descripcion,
		@RequestParam (required = false) Double costo,
		@RequestParam (required = false) Date fecha_inicio,
		@RequestParam (required = false) Date fecha_fin,
		@RequestParam (required = false) String cliente) {
	return proyectoservice.updateProyecto
			(Id, descripcion, costo, fecha_inicio, fecha_fin, cliente);
}



}