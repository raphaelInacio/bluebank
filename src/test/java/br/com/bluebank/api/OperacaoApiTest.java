package br.com.bluebank.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import br.com.bluebank.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@WebIntegrationTest
public class OperacaoApiTest {

	@Autowired
	private WebApplicationContext context;

	private MockMvc mvc;

	@Before
	public void setup() {
		mvc = MockMvcBuilders
				.webAppContextSetup(context)
				.build();
	}

	@Test
	public void deveRetornarUmaOperacaoTransferencia() throws Exception {
		mvc.perform(get("/api/operacoes"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$").isArray())
			.andExpect(jsonPath("$").isNotEmpty())
			.andExpect(jsonPath("$[0].tipoOperacao").value("TRANSFERENCIA"));
	}
	
	@Test
	public void deveRetornarOperacoesPorConta() throws Exception {
		mvc.perform(get("/api/operacoes/4000"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$[0].tipoOperacao").value("TRANSFERENCIA"))
		.andExpect(jsonPath("$[0].conta.numero").value(4000))
		.andExpect(jsonPath("$[0].conta.cliente.nome").value("Raphael Inácio"))
		.andExpect(jsonPath("$[0].conta.cliente.cpf").value("32687308846"));
	}
}
