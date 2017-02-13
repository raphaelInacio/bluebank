package br.com.bluebank.api;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bluebank.business.OperacaoBusiness;
import br.com.bluebank.entidade.Cliente;
import br.com.bluebank.entidade.Conta;
import br.com.bluebank.entidade.Operacao;
import br.com.bluebank.repositorio.ClienteRepositorio;
import br.com.bluebank.repositorio.ContaRepositorio;
import br.com.bluebank.repositorio.OperacaoRepositorio;

@RestController
@RequestMapping("/api/operacoes")
public class OperacaoApi {

	@Autowired
	private OperacaoRepositorio repositorio;

	@Autowired
	private OperacaoBusiness operacaoBusiness;

	@Autowired
	private ClienteRepositorio clienteRepositorio;

	@Autowired
	private ContaRepositorio contaRepositorio;

	@RequestMapping(method = GET)
	public Iterable<Operacao> listarOperacoes() {
		return repositorio.findAll();
	}

	@RequestMapping(value = "/{numero}", method = GET)
	public Iterable<Operacao> obterOperacaoPorConta(@PathVariable("numero") Integer numero) {
		Conta conta = contaRepositorio.findByNumero(numero);
		return repositorio.findByConta(conta);
	}
	
	@RequestMapping(value = "/{numero}/{cpf}", method = POST)
	public Operacao transferencia(@PathVariable("numero") Integer numero, @PathVariable String cpf,
			@RequestBody Operacao operacao) {
		Cliente cliente = clienteRepositorio.findOne(cpf);
		Conta conta = contaRepositorio.findByNumeroAndCliente(numero, cliente);
		return operacaoBusiness.transferencia(conta, operacao);
	}
}
