package com.marinhosoftware.agenda.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.marinhosoftware.agenda.domain.Contato;
import com.marinhosoftware.agenda.service.ContatoService;

@RestController
@RequestMapping(value = "/contatos")
public class ContatoResource {
	
	@Autowired
	private ContatoService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Contato> find(@PathVariable Integer id) {
		Contato obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}


}
