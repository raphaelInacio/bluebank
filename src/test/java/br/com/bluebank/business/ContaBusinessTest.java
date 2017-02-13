package br.com.bluebank.business;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class ContaBusinessTest {

	@Test
	public void deveDebitarSaldo() {
		ContaBusiness conta = new ContaBusiness();
		BigDecimal valorAtual = new BigDecimal(5.0);
		BigDecimal valorOperacao = new BigDecimal(4.5);
		BigDecimal valorDebitado = conta.debitarSaldo(valorAtual, valorOperacao);
		assertEquals(new BigDecimal(0.5), valorDebitado);
	}
	
	@Test
	public void deveAcresentarSaldo() {
		ContaBusiness conta = new ContaBusiness();
		BigDecimal valorAtual = new BigDecimal(5.0);
		BigDecimal valorOperacao = new BigDecimal(4.0);
		valorAtual.subtract(valorOperacao);
		BigDecimal valorDebitado = conta.adicionarSaldo(valorAtual, valorOperacao);
		assertEquals(new BigDecimal(9), valorDebitado);
	}

}
