package com.br.api.tale.controller;

import com.br.api.tale.repository.TaleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import com.br.api.tale.model.Tale;

@RestController
public class TaleController {

  @Autowired
	private TaleRepository taleRepository;
	
	@GetMapping("/tales")
	public List<Tale> findAll() {
		return this.taleRepository.findAll();
	}

	@GetMapping("/tales/{name}")
	public List<Tale> findByName(@PathVariable("name") String name) {
		return this.taleRepository.findByNameContaining(name);
	}

	@GetMapping("/tales/search/{id}")
	public Optional<Tale> findByTaleId(@PathVariable("id") Long id) {
		return this.taleRepository.findById(id);
	}
	
	@PostMapping("/tales/save")
	@ResponseStatus(HttpStatus.CREATED)
	public Tale add(@RequestBody Tale tale) {
		return this.taleRepository.save(tale);
	}

  @PutMapping("/tales/edit")
  public void edit(@RequestBody Tale tale) {
    if (tale.getId() > 0) {
      this.taleRepository.save(tale);
    }
  }
	
	@DeleteMapping("/tales")
	public void remove(@RequestBody Tale tale) {
		this.taleRepository.delete(tale);
	}
}
