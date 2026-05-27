package com.carlos.api_seguros.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.carlos.api_seguros.entity.Sinistro;
import com.carlos.api_seguros.service.SinistroService;

@RestController
@RequestMapping("/sinistros")
public class SinistroController {

    private final SinistroService sinistroService;

    public SinistroController(SinistroService sinistroService) {
        this.sinistroService = sinistroService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Sinistro criar(@RequestBody Sinistro sinistro) {
        return sinistroService.criar(sinistro);
    }

    @GetMapping
    public List<Sinistro> listar() {
        return sinistroService.listar();
    }
}