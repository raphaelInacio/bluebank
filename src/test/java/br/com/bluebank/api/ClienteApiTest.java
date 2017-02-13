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
public class ClienteApiTest {

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
	public void deveRetornarClientes() throws Exception {
		mvc.perform(get("/api/clientes"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$").isArray())
			.andExpect(jsonPath("$").isNotEmpty())
			.andExpect(jsonPath("$[0].nome").value("Raphael Inácio"))
			.andExpect(jsonPath("$[0].cpf").value("32687308846"));
	}
	
	@Test
	public void deveRetornarClientePorCpf() throws Exception {
		mvc.perform(get("/api/clientes/32687308846"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.nome").value("Raphael Inácio"))
			.andExpect(jsonPath("$.cpf").value("32687308846"));
	}

}
