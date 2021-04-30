package com.marinhosoftware.agenda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marinhosoftware.agenda.domain.Contato;
import com.marinhosoftware.agenda.dto.ContatoDTO;
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
	
	public Contato update(Contato obj) {
		Contato newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		repo.deleteById(id);
	}
	
	public List<Contato> findAll() {
		return repo.findAll();
	}
	
	public Contato fromDTO(ContatoDTO objDto) {
		Contato contato = new Contato(objDto.getPrimeiroNome(), objDto.getUltimoNome(), objDto.getEmail());
		contato.getTelefones().add(objDto.getTelefone1());
		if (objDto.getTelefone2() != null) {
			contato.getTelefones().add(objDto.getTelefone2());
		}
		return contato;
	}
	
	private void updateData(Contato newObj, Contato obj) {
		newObj.setPrimeiroNome(obj.getPrimeiroNome());
		newObj.setUltimoNome(obj.getUltimoNome());
		newObj.setEmail(obj.getEmail());
		newObj.setTelefones(obj.getTelefones());
	}

}
