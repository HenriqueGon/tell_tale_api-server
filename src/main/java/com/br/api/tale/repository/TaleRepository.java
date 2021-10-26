package com.br.api.tale.repository;

import com.br.api.tale.model.Tale;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaleRepository extends JpaRepository<Tale, Long>{
  
}
