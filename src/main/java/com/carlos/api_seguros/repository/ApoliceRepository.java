package com.carlos.api_seguros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.carlos.api_seguros.entity.Apolice;

public interface ApoliceRepository extends JpaRepository<Apolice, Long>{
	
	boolean existsbyNumeroApolice(String numeroApolice); //isso é tipo uma consulta no SQL

}
