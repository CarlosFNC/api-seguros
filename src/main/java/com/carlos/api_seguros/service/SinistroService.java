package com.carlos.api_seguros.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.carlos.api_seguros.entity.Apolice;
import com.carlos.api_seguros.entity.Sinistro;
import com.carlos.api_seguros.repository.ApoliceRepository;
import com.carlos.api_seguros.repository.SinistroRepository;

@Service
public class SinistroService {
	private SinistroRepository sinistroRepository;
	private ApoliceRepository apoliceRepository;
	
	public SinistroService(SinistroRepository sinistroRepository, ApoliceRepository apoliceRepository) {
		this.sinistroRepository = sinistroRepository;
		this.apoliceRepository = apoliceRepository;
	}
	
	public Sinistro criar(Sinistro sinistro) {
		
		Apolice apolice = apoliceRepository.findById(sinistro.getApolice().getId())
				.orElseThrow(() -> new RuntimeException("Apólice não encontrado."));
		
		if(sinistro.getValorPrejuizo().doubleValue() <= 0) {
			throw new RuntimeException("Valor do prejuizo deve ser maior que zero.");
		}
		
		if(sinistro.getDataSinistro().isBefore(apolice.getDataInicioVigencia()) || 
			sinistro.getDataSinistro().isAfter(apolice.getDataFimVigencia())) {
			throw new RuntimeException("Sinistro fora da vigência da apólice.");
		}
		
		sinistro.setApolice(apolice);
		
		return sinistroRepository.save(sinistro);
	}
	
	public List<Sinistro> listar(){
		return sinistroRepository.findAll();
	}
	
	public List<Sinistro> listarPorApolice(Long idApolice){
		return sinistroRepository.findByApoliceId(idApolice);
	}
}
