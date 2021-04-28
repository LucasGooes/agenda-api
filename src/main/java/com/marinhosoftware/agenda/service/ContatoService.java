package com.marinhosoftware.agenda.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marinhosoftware.agenda.domain.Contato;
import com.marinhosoftware.agenda.repository.ContatoRepository;

@Service
public class ContatoService {
	
	@Autowired
	private ContatoRepository repo;
	
	public Contato find(Integer id) {
		Optional<Contato> obj = repo.findById(id);
		return obj;
	}

}
