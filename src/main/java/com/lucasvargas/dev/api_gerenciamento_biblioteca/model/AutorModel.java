package com.lucasvargas.dev.api_gerenciamento_biblioteca.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "tb_autor")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AutorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String sobre;
    private LocalDate dataDeNascimento;
    private String nacionalidade;
}
