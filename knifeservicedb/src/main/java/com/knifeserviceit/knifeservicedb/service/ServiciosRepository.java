package com.knifeserviceit.knifeservicedb.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.knifeserviceit.knifeservicedb.model.Servicios;

public interface ServiciosRepository extends JpaRepository<Servicios, Long> {

	
}
