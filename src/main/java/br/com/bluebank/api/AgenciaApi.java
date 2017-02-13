package br.com.bluebank.api;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bluebank.entidade.Agencia;
import br.com.bluebank.repositorio.AgenciaRepositorio;

@RestController
@RequestMapping("/api/agencias")
public class AgenciaApi {

	@Autowired
	private AgenciaRepositorio repositorio;
	
	@RequestMapping(method = GET)
	public Iterable<Agencia> listarAgencias() {
		return repositorio.findAll();
	}
	
	@RequestMapping(value = "/{numero}", method = GET)
	public Agencia listarPorNumero(@PathVariable("numero") Integer numero) {
		return repositorio.findByNumero(numero);
	}
}
