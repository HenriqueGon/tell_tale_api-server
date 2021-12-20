package com.br.api.tale.repository;

import java.util.List;

import com.br.api.tale.model.Tale;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaleRepository extends JpaRepository<Tale, Long>{
  
  List<Tale> findByNameContaining(String name);
}
