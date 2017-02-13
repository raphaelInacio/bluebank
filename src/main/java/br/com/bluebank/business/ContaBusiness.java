package br.com.bluebank.business;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;
@Service
public class ContaBusiness {

	public BigDecimal debitarSaldo(BigDecimal valorAtual , BigDecimal valorOperacao){
		return valorAtual.subtract(valorOperacao);
	}
	
	public BigDecimal adicionarSaldo(BigDecimal valorAtual , BigDecimal valorOperacao){
		return valorAtual.add(valorOperacao);
	}
}
