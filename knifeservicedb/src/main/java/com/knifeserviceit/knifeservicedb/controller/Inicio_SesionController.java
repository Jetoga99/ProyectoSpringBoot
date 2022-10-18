package com.knifeserviceit.knifeservicedb.controller;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
@PutMapping
public Token Iniciar_Sesion (@RequestParam(required=true) String Email, @RequestParam(required=true) String Contraseña) throws ServletException{
	System.out.println(Email);
	if (desarrolladorservice.autenticador_dev(Email, Contraseña )) {
		return new Token(generateToken(Email));
		
	}//if autenticador 
	throw new ServletException("nombre de usuario o contraseña Incorrectos");
	
}//cierre Token Iniciar Sesion
	
private String generateToken(String desarrollador) {
	Calendar calendar = Calendar.getInstance();
	calendar.add(Calendar.HOUR, 30);
	return Jwts.builder().setSubject(desarrollador).claim("role","user")
			.setIssuedAt(new Date()).setExpiration(calendar.getTime())
			.signWith(SignatureAlgorithm.HS256, JwtFilter.secret).compact();
}//generador de token
	
	
}//cierre clase inicio_sesion
