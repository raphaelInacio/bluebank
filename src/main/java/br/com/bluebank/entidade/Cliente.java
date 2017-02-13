package br.com.bluebank.entidade;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cliente {
	
	@Id
	private String cpf;

	private String nome;
	
	public Cliente(String nome, String cpf){
		this.nome = nome;
		this.cpf = cpf;
	}
	
	Cliente() { }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
