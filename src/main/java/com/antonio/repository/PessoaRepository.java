package com.antonio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.antonio.entity.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
    
}
