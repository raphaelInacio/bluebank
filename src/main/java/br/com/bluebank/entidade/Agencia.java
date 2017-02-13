package br.com.bluebank.entidade;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Agencia {
	@Id
	private Integer numero;
	
	@JsonIgnore
	@OneToMany()
	private List<Conta> contas;

	public Agencia(Integer numero) {
		this.numero = numero;
	}

	Agencia() {
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}

}
