package br.com.bluebank.business;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bluebank.entidade.Conta;
import br.com.bluebank.entidade.Operacao;
import br.com.bluebank.repositorio.ContaRepositorio;
import br.com.bluebank.repositorio.OperacaoRepositorio;
import br.com.bluebank.util.TipoOperacao;

@Service
public class OperacaoBusiness {

	@Autowired
	ContaRepositorio contaRepositorio;

	@Autowired
	OperacaoRepositorio operacaoRepositorio;

	@Autowired
	ContaBusiness contaBusiness;

	public Operacao transferencia(Conta contaCliente, Operacao operacaoDestino) {

		BigDecimal saldoDebitado = contaBusiness.debitarSaldo(contaCliente.getSaldo(), operacaoDestino.getValor());
		BigDecimal saldoAcrescimo = contaBusiness.adicionarSaldo(operacaoDestino.getConta().getSaldo(),
				operacaoDestino.getValor());

		Conta contaDestino = operacaoDestino.getConta();
		contaCliente.setSaldo(saldoDebitado);
		contaDestino.setSaldo(saldoAcrescimo);

		Operacao operacaoContaCliente = new Operacao(TipoOperacao.TRANSFERENCIA, operacaoDestino.getValor(),
				contaCliente);

		contaRepositorio.save(contaCliente);
		operacaoRepositorio.save(operacaoContaCliente);

		contaRepositorio.save(contaDestino);
		operacaoDestino.setConta(contaDestino);
		operacaoRepositorio.save(operacaoDestino);

		return operacaoContaCliente;
	}

}
