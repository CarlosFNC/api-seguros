package com.carlos.api_seguros.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.carlos.api_seguros.entity.Apolice;
import com.carlos.api_seguros.service.ApoliceService;

@RestController
@RequestMapping("/apolice")
public class ApoliceController {
	
	private final ApoliceService apoliceService;

	public ApoliceController(ApoliceService apoliceService) {
		this.apoliceService = apoliceService;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Apolice criar(@RequestBody Apolice apolice) {
		return apoliceService.criar(apolice);
	}
	
	@GetMapping
	public List<Apolice> listar(){
		return apoliceService.listar();
	}
	
	@GetMapping("/{id}")
	public Apolice buscarPorId(@PathVariable Long id) {
		return apoliceService.buscarPorId(id);
		
	}
}
