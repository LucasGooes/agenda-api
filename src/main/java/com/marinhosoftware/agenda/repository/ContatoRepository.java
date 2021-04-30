package com.marinhosoftware.agenda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.marinhosoftware.agenda.domain.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Integer> {
	
	List<Contato> findByPrimeiroNome(String nome);
	@Transactional(readOnly = true)
	List<Contato> findByEmail(String email);

}
