package br.com.bluebank.api;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bluebank.entidade.Cliente;
import br.com.bluebank.entidade.Conta;
import br.com.bluebank.repositorio.ClienteRepositorio;
import br.com.bluebank.repositorio.ContaRepositorio;

@RestController
@RequestMapping("/api/contas")
public class ContaApi {

	@Autowired
	private ContaRepositorio repositorio;
	
	@Autowired
	private ClienteRepositorio clienteRepositorio;
	
	@RequestMapping(method = GET)
	public Iterable<Conta> listarContas() {
		return repositorio.findAll();
	}
	
	@RequestMapping(value = "/{numero}/{cpf}", method = GET)
	public Conta acessarConta(@PathVariable("numero") Integer numero, @PathVariable String cpf) {
		Cliente cliente = clienteRepositorio.findOne(cpf);
		return repositorio.findByNumeroAndCliente(numero, cliente);
	}
	
	@RequestMapping(value = "/{numero}", method = POST)
	public Conta listarPorNumero(@PathVariable("numero") Integer numero) {
		return repositorio.findByNumero(numero);
	}
}
