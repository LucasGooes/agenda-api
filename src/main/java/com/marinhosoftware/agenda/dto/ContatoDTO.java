package com.marinhosoftware.agenda.dto;

import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.marinhosoftware.agenda.domain.Contato;

public class ContatoDTO {

	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min = 1, max=30, message = "O tamanho deve ser entre 1 e 30 caracteres")
	private String primeiroNome;
	private String ultimoNome;
	@Email(message = "Email inválido")
	private String email;
	@NotEmpty(message = "Preenchimento obrigatório")
	private String telefone1;
	private String telefone2;
	
	public ContatoDTO() {
	}
	
	public ContatoDTO(Contato obj) {
		primeiroNome = obj.getPrimeiroNome();
		ultimoNome = obj.getUltimoNome();
		email = obj.getEmail();
		this.setTelefones(obj.getTelefones());
	}

	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}

	public String getUltimoNome() {
		return ultimoNome;
	}

	public void setUltimoNome(String ultimoNome) {
		this.ultimoNome = ultimoNome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone1() {
		return telefone1;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefones(Set<String> telefones) {
		// VER UMA FORMA MAIS ELEGANTE DE IMPLEMENTAR ESSA REGRA
		int count = 0;
		for (String tel: telefones) {
			if (count == 0)
				this.telefone1 = tel;
			if (count > 0 ) {
				this.telefone2 = tel;
			}
			count++;
		}
	}
	
}
