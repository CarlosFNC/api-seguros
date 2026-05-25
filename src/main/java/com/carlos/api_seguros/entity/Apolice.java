package com.carlos.api_seguros.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "apolice")
@Getter // gera os métodos Getters
@Setter // gera os métodos Setters
@NoArgsConstructor // gera o construtor default(sem argumentos) exigência da JPA
@AllArgsConstructor // gera o construtor que recebe totos os campos como argumento
public class Apolice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_apolice", nullable = false, unique = true)
    private String numeroApolice;

    @Column(name = "nome_segurado", nullable = false)
    private String nomeSegurado;

    @Column(name = "cpf_segurado", nullable = false)
    private String cpfSegurado;

    @Column(name = "valor_segurado", nullable = false)
    private BigDecimal valorSegurado;

    @Column(name = "data_inicio_vigencia", nullable = false)
    private LocalDate dataInicioVigencia;

    @Column(name = "data_fim_vigencia", nullable = false)
    private LocalDate dataFimVigencia;

    @OneToMany(mappedBy = "apolice")
    private List<Sinistro> sinistros;
}