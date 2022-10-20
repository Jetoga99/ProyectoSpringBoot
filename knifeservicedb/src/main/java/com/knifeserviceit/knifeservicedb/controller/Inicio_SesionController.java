package com.knifeserviceit.knifeservicedb.controller;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.knifeserviceit.knifeservicedb.jwt.config.JwtFilter;
import com.knifeserviceit.knifeservicedb.model.Desarrollador;
import com.knifeserviceit.knifeservicedb.model.Token;
import com.knifeserviceit.knifeservicedb.service.DesarrolladorService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
@RestController
@RequestMapping(path="/api/iniciar_sesion/")
public class Inicio_SesionController {
private final DesarrolladorService desarrolladorservice;

@Autowired 
	public Inicio_SesionController(DesarrolladorService desarrolladorservice) {
		super();
		this.desarrolladorservice = desarrolladorservice;
		}

@PostMapping
public Token Iniciar_Sesion (@RequestBody  Desarrollador desa) throws ServletException{
	if (desarrolladorservice.autenticador_dev(desa)) {
		return new Token(generateToken(desa.getEmail()));
		
	} //if autenticador 
	throw new ServletException("nombre de usuario o contraseña Incorrectos");
}//cierre Token Iniciar Sesion
	
private String generateToken(String desarrollador) {
	Calendar calendar = Calendar.getInstance();
	calendar.add(Calendar.HOUR, 30);
	return Jwts.builder().setSubject(desarrollador).claim("role","user")
			.setIssuedAt(new Date()).setExpiration(calendar.getTime())
			.signWith(SignatureAlgorithm.HS256, JwtFilter.secret).compact();
}//generador de token
	
@PutMapping //http://localhost:8080/api/desarrollador/1
public Desarrollador getDeveloper(@RequestBody Desarrollador desa ) throws ServletException {
	if (desarrolladorservice.ExisteONo(desa)) {
		return desa;	
	}
	
	throw new ServletException("no Existe aun");

}//this function gets the specified id data



	
}//cierre clase inicio_sesion
