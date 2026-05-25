package com.carlos.api_seguros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carlos.api_seguros.entity.Sinistro;

public interface SinistroRepository extends JpaRepository<Sinistro, Long> {

    List<Sinistro> findByApoliceId(Long id); //Busca todos os sinistros de uma apólice.

}