package com.lucasvargas.dev.api_gerenciamento_biblioteca.repository;

import com.lucasvargas.dev.api_gerenciamento_biblioteca.model.LivroModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<LivroModel, Long> {

}
