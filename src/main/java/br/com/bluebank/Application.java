package br.com.bluebank;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.bluebank.entidade.Agencia;
import br.com.bluebank.entidade.Cliente;
import br.com.bluebank.entidade.Conta;
import br.com.bluebank.entidade.Operacao;
import br.com.bluebank.repositorio.AgenciaRepositorio;
import br.com.bluebank.repositorio.ClienteRepositorio;
import br.com.bluebank.repositorio.ContaRepositorio;
import br.com.bluebank.repositorio.OperacaoRepositorio;
import br.com.bluebank.util.TipoOperacao;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner demo(ClienteRepositorio clienteRepositorio, AgenciaRepositorio agenciaRepositorio,
			ContaRepositorio contaRepositorio, OperacaoRepositorio operacaoRepositorio) {
		return (args) -> {

			Cliente raphael = new Cliente("Raphael Inácio", "32687308846");
			Cliente jose = new Cliente("Jose Silva", "32187308846");
			

			clienteRepositorio.save(raphael);
			clienteRepositorio.save(jose);

			Agencia agencia3000 = new Agencia(3000);
			agenciaRepositorio.save(agencia3000);

			Agencia agencia3001 = new Agencia(3001);
			agenciaRepositorio.save(agencia3001);

			Agencia agencia3002 = new Agencia(3002);
			agenciaRepositorio.save(agencia3002);

			Conta contaRaphael = new Conta(4000, new BigDecimal(3.5), agencia3000, raphael);
			Conta contaJose = new Conta(4001, new BigDecimal(4.5), agencia3000, jose);

			contaRepositorio.save(contaRaphael);
			contaRepositorio.save(contaJose);

			Operacao transferencia = new Operacao(TipoOperacao.TRANSFERENCIA, new BigDecimal(100), contaRaphael);
			Operacao transferenciaSaque = new Operacao(TipoOperacao.SAQUE, new BigDecimal(20), contaRaphael);
			Operacao transferenciaPagamento = new Operacao(TipoOperacao.PAGAMENTO, new BigDecimal(30), contaRaphael);
			Operacao transferenciaSaque2 = new Operacao(TipoOperacao.SAQUE, new BigDecimal(20), contaRaphael);
			
			Operacao transferenciaContaDestino = new Operacao(TipoOperacao.TRANSFERENCIA, new BigDecimal(100), contaJose);
			
			operacaoRepositorio.save(transferencia);
			operacaoRepositorio.save(transferenciaContaDestino);
			operacaoRepositorio.save(transferenciaSaque);
			operacaoRepositorio.save(transferenciaPagamento);
			operacaoRepositorio.save(transferenciaSaque2);
			
		};
	}
}
