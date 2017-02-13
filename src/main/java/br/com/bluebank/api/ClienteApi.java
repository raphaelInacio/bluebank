package br.com.bluebank.api;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bluebank.entidade.Cliente;
import br.com.bluebank.repositorio.ClienteRepositorio;

@RestController
@RequestMapping("/api/clientes")
public class ClienteApi {

	@Autowired
	private ClienteRepositorio repositorio;

	@RequestMapping(method = GET)
	public Iterable<Cliente> listarClientes() {
		return repositorio.findAll();
	}

	@RequestMapping(value = "/{cpf}", method = GET)
	public Cliente listarClientePorCPF(@PathVariable("cpf") String cpf) {
		return repositorio.findOne(cpf);
	}
}
