package com.carlos.api_seguros.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "sinistro")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sinistro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_apolice", nullable = false)
    private Apolice apolice;

    @Column(nullable = false)
    private String descricao;

    @Column(name = "valor_prejuizo", nullable = false)
    private BigDecimal valorPrejuizo;

    @Column(name = "data_sinistro", nullable = false)
    private LocalDate dataSinistro;
}