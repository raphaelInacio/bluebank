package br.com.bluebank.entidade;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.bluebank.util.TipoOperacao;

@Entity
public class Operacao {
	@Id
	@GeneratedValue
	private Long id;

	private BigDecimal valor;

	@Enumerated(value = EnumType.STRING)
	private TipoOperacao tipoOperacao;

	public Operacao(TipoOperacao tipoOperacao, BigDecimal valor, Conta conta) {
		this.tipoOperacao = tipoOperacao;
		this.valor = valor;
		this.conta = conta;
	}

	Operacao() {
	}

	@ManyToOne
	private Conta conta;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public TipoOperacao getTipoOperacao() {
		return tipoOperacao;
	}

	public void setTipoOperacao(TipoOperacao tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}
}
