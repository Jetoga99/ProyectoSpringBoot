package com.knifeserviceit.knifeservicedb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.knifeserviceit.knifeservicedb.jwt.config.JwtFilter;

@SpringBootApplication
public class KnifeservicedbApplication {

	public static void main(String[] args) {
		SpringApplication.run(KnifeservicedbApplication.class, args);
	}
	
	@Bean
	public FilterRegistrationBean<JwtFilter> jwtFilter(){
		FilterRegistrationBean<JwtFilter> registrationBean = new FilterRegistrationBean<>();
		registrationBean.setFilter(new JwtFilter());
		registrationBean.addUrlPatterns("/api/desarrollador/*");
		registrationBean.addUrlPatterns("/api/tipo_desarrollador/*");
		registrationBean.addUrlPatterns("/api/proyecto_servicios/*");
		registrationBean.addUrlPatterns("/api/proyecto/*");
		registrationBean.addUrlPatterns("/api/servicios/*");
		return registrationBean; 
	}
	
}
