package com.marinhosoftware.agenda.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.marinhosoftware.agenda.domain.Contato;

@RestController
@RequestMapping(value = "/contatos")
public class ContatoResource {
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Contato> find(@PathVariable Integer id) {
		Contato obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}


}
