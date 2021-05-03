package com.marinhosoftware.agenda.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.marinhosoftware.agenda.domain.Contato;
import com.marinhosoftware.agenda.dto.ContatoDTO;
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
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody ContatoDTO objDto) {
		Contato obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody ContatoDTO objDto,@PathVariable Integer id) {
		Contato obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Contato> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ContatoDTO>> findAll() {
		List<Contato> list = service.findAll();
		List<ContatoDTO> listDto = list.stream().map(obj -> new ContatoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value = "/filter",method = RequestMethod.GET)
	public ResponseEntity<List<ContatoDTO>> findByNomeOrEmail(
		@RequestParam(value = "nome", defaultValue = "") String nome,
		@RequestParam(value = "email", defaultValue = "") String email) {
		List<Contato> list = service.findByNameOrEmail(nome, email);
		List<ContatoDTO> listDto = list.stream().map(obj -> new ContatoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

}
