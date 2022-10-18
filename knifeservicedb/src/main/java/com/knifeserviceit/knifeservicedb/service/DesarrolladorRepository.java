package com.knifeserviceit.knifeservicedb.service;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.knifeserviceit.knifeservicedb.model.Desarrollador;

public interface DesarrolladorRepository extends JpaRepository<Desarrollador, Long>{
	@Query("SELECT dev FROM Desarrollador dev WHERE dev.Email=?1")//JPQL
	Optional<Desarrollador> findByEmail(String Email);

}//developer repository interface
