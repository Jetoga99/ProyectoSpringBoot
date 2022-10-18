package com.knifeserviceit.knifeservicedb.jwt.config;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Claims;
import org.springframework.web.filter.GenericFilterBean;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
public class JwtFilter extends GenericFilterBean {
	public static String secret = "KnifeServiceIt-para-problemas-con-tecnologia-tenemos-al-scrum-master-irving-drmas!@2022tm#3";
	 @Override
	 public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	 throws IOException, ServletException{
		 HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		 String authHeader = httpServletRequest.getHeader("authorization");
		 if(("POST".equals(httpServletRequest.getMethod()))|| (("GET".equals(httpServletRequest.getMethod()))&&
				 (! httpServletRequest.getRequestURI().contains("/api/proyecto/"))&&
				 (! httpServletRequest.getRequestURI().contains("/api/servicios/"))&&
				 (! httpServletRequest.getRequestURI().contains("/api/proyecto_servicios/")))||
				 ("PUT".equals(httpServletRequest.getMethod() ))||
				 ("DELETE".equals(httpServletRequest.getMethod())))
		 {
			 if (authHeader ==null || !authHeader.startsWith("Bearer: ")) {
				 throw new ServletException("1. Invalid Token");
				 }//if authheader is empty or has nothing.
			 String token = authHeader.substring(7);
			 try {
				 Claims claims = Jwts.parser().setSigningKey(secret)
						 .parseClaimsJws(token).getBody();
				 claims.forEach((key, value)->{
					System.out.println("key: " + key + "value: " + value); 
				 });
				 
			 }catch(SignatureException | MalformedJwtException |ExpiredJwtException e) {
				 throw new ServletException("2. Invalid token");
			 }//catch
		 }//longest if 
			 chain.doFilter(request,response);
	 }//do filter
	

}//end of JwtFilter
