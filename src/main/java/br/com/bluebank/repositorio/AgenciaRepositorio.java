package br.com.bluebank.repositorio;

import org.springframework.data.repository.CrudRepository;

import br.com.bluebank.entidade.Agencia;

public interface AgenciaRepositorio extends CrudRepository<Agencia, Integer> {

	Agencia findByNumero(Integer numero);

}
