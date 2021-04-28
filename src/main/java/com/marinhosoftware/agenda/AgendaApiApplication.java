package com.marinhosoftware.agenda;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.marinhosoftware.agenda.domain.Contato;
import com.marinhosoftware.agenda.repository.ContatoRepository;

@SpringBootApplication
public class AgendaApiApplication implements CommandLineRunner {
	
	@Autowired
	private ContatoRepository contatoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(AgendaApiApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		Contato contato = new Contato("Lucas", "Goes Marinho", "lucasmarcos343@gmail.com");
		contato.getTelefones().addAll(Arrays.asList("92984156896","92991520089"));
		
		Contato contato2 = new Contato("Karol", "Alessandra Marques", "karol@hotmail.com");
		contato2.getTelefones().addAll(Arrays.asList("92985568966","92986256596"));
		
		contatoRepository.saveAll(Arrays.asList(contato, contato2));
	}

}
