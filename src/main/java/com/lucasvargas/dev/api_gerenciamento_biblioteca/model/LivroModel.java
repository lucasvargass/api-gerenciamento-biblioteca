package com.lucasvargas.dev.api_gerenciamento_biblioteca.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "tb_livro")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LivroModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private Integer anoPublicacao;
    private String sobre;
    private String linguaOriginal;
    private Integer quantidadePaginas;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private AutorModel autorModel;

}
