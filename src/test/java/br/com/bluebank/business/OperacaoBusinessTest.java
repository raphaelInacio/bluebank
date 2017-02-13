package br.com.bluebank.business;

import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import br.com.bluebank.entidade.Agencia;
import br.com.bluebank.entidade.Cliente;
import br.com.bluebank.entidade.Conta;
import br.com.bluebank.entidade.Operacao;
import br.com.bluebank.repositorio.ContaRepositorio;
import br.com.bluebank.repositorio.OperacaoRepositorio;
import br.com.bluebank.util.TipoOperacao;

public class OperacaoBusinessTest {

	@InjectMocks
	OperacaoBusiness business;
	@Mock
	ContaRepositorio contaRepositorio;
	@Mock
	OperacaoRepositorio operacaoRepositorio;
	@Spy
	ContaBusiness contaBusiness;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	
	public void deveRealizarUmaTransferencia() {

		BigDecimal valorAtual = new BigDecimal(5.0);
		BigDecimal valorOperacao = new BigDecimal(4.5);

		Agencia agencia3000 = new Agencia(3000);

		Cliente raphael = new Cliente("Raphael Inácio", "32687308846");
		Cliente jose = new Cliente("Jose Silva", "32187308846");

		Conta contaRaphael = new Conta(4000, new BigDecimal(3.5), agencia3000, raphael);
		Conta contaJose = new Conta(4001, new BigDecimal(4.5), agencia3000, jose);

		Operacao transferencia = new Operacao(TipoOperacao.TRANSFERENCIA, new BigDecimal(100), contaJose);

		Mockito.when(contaRepositorio.save(contaRaphael)).thenReturn(contaRaphael);
		Mockito.when(contaRepositorio.save(contaJose)).thenReturn(contaRaphael);
		Mockito.when(operacaoRepositorio.save(transferencia)).thenReturn(transferencia);

		Mockito.doReturn(valorAtual.subtract(valorOperacao)).when(contaBusiness).debitarSaldo(valorAtual,
				valorOperacao);
		Mockito.doReturn(valorAtual.add(valorOperacao)).when(contaBusiness).adicionarSaldo(valorAtual, valorOperacao);

		Operacao resultadoOperacao = business.transferencia(contaRaphael, transferencia);
		assertNotNull(resultadoOperacao);
	}

}
