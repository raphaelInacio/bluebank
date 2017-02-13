package br.com.bluebank.entidade;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Conta {

	@Id
	@GeneratedValue
	private Long id;

	private Integer numero;

	private BigDecimal saldo;

	@ManyToOne
	private Agencia agencia;

	@OneToOne
	private Cliente cliente;

	public Conta(Integer numero, BigDecimal saldo, Agencia agencia, Cliente cliente) {
		this.saldo = saldo;
		this.numero = numero;
		this.setAgencia(agencia);
		this.setCliente(cliente);
	}

	Conta() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Agencia getAgencia() {
		return agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
