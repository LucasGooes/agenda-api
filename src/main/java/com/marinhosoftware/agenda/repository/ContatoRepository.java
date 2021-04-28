package com.marinhosoftware.agenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marinhosoftware.agenda.domain.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Integer> {

}
