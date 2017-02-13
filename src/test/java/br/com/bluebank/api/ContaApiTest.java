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
public class ContaApiTest {

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
	public void deveRetornarContas() throws Exception {
		mvc.perform(get("/api/contas"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$").isArray())
			.andExpect(jsonPath("$").isNotEmpty())
			.andExpect(jsonPath("$[0].numero").value(4000))
			.andExpect(jsonPath("$[1].numero").value(4001));
	}
	
	@Test
	public void deveRetornarClientePorCpf() throws Exception {
		mvc.perform(get("/api/contas/4000/32687308846"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.numero").value(4000))
			.andExpect(jsonPath("$.cliente.nome").value("Raphael Inácio"))
			.andExpect(jsonPath("$.cliente.cpf").value("32687308846"));
	}
}
