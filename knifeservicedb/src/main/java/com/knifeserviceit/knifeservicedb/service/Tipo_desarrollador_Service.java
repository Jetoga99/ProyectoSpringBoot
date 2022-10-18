package com.knifeserviceit.knifeservicedb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.knifeserviceit.knifeservicedb.model.Tipo_desarrollador;

@Service

public class Tipo_desarrollador_Service {
	private final Tipo_DesarrolladorRepository tipo_desarrolladorRepository;
	@Autowired
	public Tipo_desarrollador_Service(Tipo_DesarrolladorRepository tipo_desarrolladorRepository) {
		super();
		this.tipo_desarrolladorRepository = tipo_desarrolladorRepository;
	}
	
	public List<Tipo_desarrollador> getAllDevtype(){
		return tipo_desarrolladorRepository.findAll();
	}//method that allows you to get all records from table 
	
	public Tipo_desarrollador getDeveloper(Long id) {
		return tipo_desarrolladorRepository.findById(id).orElseThrow(()->new IllegalArgumentException(
		"El tipo de desarrollador con Id " +id +" No existe en la base de datos"));
		
	}//this method returns the data that matches with the id 
	
	public Tipo_desarrollador addTipo_desarrollador(Tipo_desarrollador tipo_desarrolador) {
		return tipo_desarrolladorRepository.save(tipo_desarrolador);
	}//this method saves the new record
	
	public Tipo_desarrollador deleteTipo_desarrollador(Long id) {
		Tipo_desarrollador	temptype=null;
		if (tipo_desarrolladorRepository.existsById(id)) {
			temptype= tipo_desarrolladorRepository.findById(id).get();
			tipo_desarrolladorRepository.deleteById(id);
			
		}//if exist 
		return temptype;
	}//method that deletes a record
	
	public Tipo_desarrollador updatetipo_desarrollador(Long id, String descripcion) {
		Tipo_desarrollador temptype =null;
		if (tipo_desarrolladorRepository.existsById(id)) {
			if(descripcion != null) temptype.setDescripcion(descripcion);	
		}else {
			System.out.println("update - El tipo de desarrollador con Id: " + id +" No esxiste en la base de datos");
		}
		return temptype;

	}//method to update data 
	
	
	
	
}
