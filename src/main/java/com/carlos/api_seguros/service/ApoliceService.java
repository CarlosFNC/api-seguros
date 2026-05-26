package com.carlos.api_seguros.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.carlos.api_seguros.entity.Apolice;
import com.carlos.api_seguros.repository.ApoliceRepository;

@Service
public class ApoliceService {
	
	private final ApoliceRepository apoliceRepository;
	
	public ApoliceService(ApoliceRepository apoliceRepository) {
		this.apoliceRepository = apoliceRepository;
	}
	
	public Apolice criar(Apolice apolice) {
		if(apoliceRepository.existsbyNumeroApolice(apolice.getNumeroApolice())) {
			throw new RuntimeException("Número da apólice já cadastrado.");
		}
		
		if(apolice.getValorSegurado().doubleValue() <= 0) {
			throw new RuntimeException("Valor segurado deve ser maior que zero.");
		}
		
		if(!apolice.getDataFimVigencia().isAfter(apolice.getDataInicioVigencia())) {
			 throw new RuntimeException("Data fim dever ser maior que data início."); 
		}
		
		return apoliceRepository.save(apolice);
	}
	
	public List<Apolice> listar(){
		return apoliceRepository.findAll();
	}
	
	public Apolice buscarPorId(Long id) {
		return apoliceRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Apólice não encontrado."));
	}
}
