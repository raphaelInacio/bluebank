package br.com.bluebank.repositorio;

import org.springframework.data.repository.CrudRepository;

import br.com.bluebank.entidade.Conta;
import br.com.bluebank.entidade.Operacao;

public interface OperacaoRepositorio extends CrudRepository<Operacao, Long> {
	public Iterable<Operacao> findByConta(Conta conta);
}
