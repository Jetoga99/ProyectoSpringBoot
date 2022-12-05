package com.knifeserviceit.knifeservicedb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.knifeserviceit.knifeservicedb.model.Desarrollador;

@Service
public class DesarrolladorService {
 private final DesarrolladorRepository desarrolladorRepository;
@Autowired
	public DesarrolladorService(DesarrolladorRepository desarrolladorRepository) {
	super(); 
	this.desarrolladorRepository = desarrolladorRepository;
	}
 
public List<Desarrollador> getDesarrollador(){
	return desarrolladorRepository.findAll();
	}//funcion que te permite conseguir todos los registros de la base de datos.

public Desarrollador getDesarrollador(Long id) {
	return desarrolladorRepository.findById(id).orElseThrow(
			()-> new IllegalArgumentException("El Desarrollador con el Id " 
					+ id + " No existe en la base de datos"));
}//consulta de desarrollador por id 

public Desarrollador deleteDesarrollador(Long id) {
	Desarrollador tempDes =null;
	if(desarrolladorRepository.existsById(id)) {
		tempDes= desarrolladorRepository.findById(id).get();
		desarrolladorRepository.deleteById(id);
	}//if developer existe then
	
	return tempDes;
}//function deleteDeveloper

public Desarrollador AddDeveloper(Desarrollador desarrollador){
	return desarrolladorRepository.save(desarrollador);
}//function that saves data from desarrollador table

public Desarrollador updateDeveloper(Long Id , String Nombre, String Apellidos, 
		Long Proyecto_Id, Long tipo_Desarrollador) {
	
	Desarrollador tempdev = null;
	if (desarrolladorRepository.existsById(Id)) {
		tempdev = desarrolladorRepository.findById(Id).get();
		if (Nombre!= null) tempdev.setNombre(Nombre);
		if(Apellidos!=null) tempdev.setApellidos(Apellidos);
		if(Proyecto_Id != null) tempdev.setProyecto_Id(Proyecto_Id);
		if(tipo_Desarrollador != null) tempdev.setTipo_desarrollador(tipo_Desarrollador);
		desarrolladorRepository.save(tempdev);
		}else {
		System.out.println("update - El desarrollador con el Id: " + Id +" No esxiste en la base de datos");
		
	}//if exist 
	return tempdev;
	
}//update developer data

public boolean autenticador_dev(Desarrollador desa) {
	boolean outcome = false ;
	Optional<Desarrollador> developerByEmail = 
	desarrolladorRepository.findByEmail(desa.getEmail());
	
	if (developerByEmail.isPresent()) {
		Desarrollador dev = developerByEmail.get();
		if (dev.getContraseña().equals(desa.getContraseña())) {
			outcome = true;
		}//if passwords are equals
		
	}
	return outcome;
}//fin clse de autenticador


public boolean ExisteONo(Desarrollador desa) {
	boolean outcome = false ;
	Optional<Desarrollador> developerByEmail = 
	desarrolladorRepository.findByEmail(desa.getEmail());
	if (developerByEmail.isPresent()) {
			outcome = true;
	}
	return outcome;
}//fin clse de autenticador de existencia 




public Desarrollador Change_Password(Long id, String Password, String NewPassword) {
	     Desarrollador dev_per = null;
	     if(desarrolladorRepository.existsById(id)) {
			dev_per =desarrolladorRepository.findById(id).get();
			if (( Password!=null)&&(NewPassword!=null)&&(dev_per.getContraseña().equals(Password))) {
				dev_per.setContraseña(NewPassword);
				desarrolladorRepository.save(dev_per);
			}//validation passwords if
		}//existence verification 
	
	     return dev_per;
	
}//class change password 





}//DesarrolladorService close