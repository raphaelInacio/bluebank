package br.com.bluebank.repositorio;

import org.springframework.data.repository.CrudRepository;

import br.com.bluebank.entidade.Cliente;

public interface ClienteRepositorio  extends CrudRepository<Cliente, String>{

}
