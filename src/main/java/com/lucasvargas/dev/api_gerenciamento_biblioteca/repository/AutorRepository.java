package com.lucasvargas.dev.api_gerenciamento_biblioteca.repository;

import com.lucasvargas.dev.api_gerenciamento_biblioteca.model.AutorModel;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<AutorModel, Long> {

}
