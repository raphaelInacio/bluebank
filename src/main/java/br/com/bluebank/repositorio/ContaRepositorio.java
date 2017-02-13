package br.com.bluebank.repositorio;

import org.springframework.data.repository.CrudRepository;

import br.com.bluebank.entidade.Cliente;
import br.com.bluebank.entidade.Conta;

public interface ContaRepositorio extends CrudRepository<Conta, Long>  {
	
	public Conta findByNumero(Integer numero);
	
	public Conta findByNumeroAndCliente(Integer numero, Cliente cliente);

}
