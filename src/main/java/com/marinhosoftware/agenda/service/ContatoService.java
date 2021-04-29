package com.marinhosoftware.agenda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marinhosoftware.agenda.domain.Contato;
import com.marinhosoftware.agenda.repository.ContatoRepository;
import com.marinhosoftware.agenda.service.exception.ObjectNotFoundException;

@Service
public class ContatoService {
	
	@Autowired
	private ContatoRepository repo;
	
	public Contato find(Integer id) {
		Optional<Contato> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Contato.class.getName()));
	}
	
	@Transactional
	public Contato insert(Contato obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		repo.deleteById(id);
	}
	
	public List<Contato> findAll() {
		return repo.findAll();
	}

}
