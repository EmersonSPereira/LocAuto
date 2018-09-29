package br.com.emerson.locauto.teste;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import br.com.emerson.locauto.controller.VeiculoController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-servlet-test.xml" })
public class VeiculoControllerTest {

	private MockMvc mockMvc;

	@Autowired
	private VeiculoController controller;

	@Before
	public void setUp() throws Exception {

		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/jsp/");
		viewResolver.setSuffix(".jsp");

		mockMvc = MockMvcBuilders.standaloneSetup(controller).setViewResolvers(viewResolver).build();
	}

	@Test
	public void testVeiculoC() throws Exception {

		mockMvc.perform(get("/veiculoC"))
        .andExpect(status().isOk())
        .andExpect(forwardedUrl("/WEB-INF/jsp/carro.jsp"));
	}

	@Test
	public void testAddCarro() throws Exception {

		mockMvc.perform(post("/salvaVeiculoC"))
        .andExpect(view().name("redirect:/exibeVeiculos"));
	}

	@Test
	public void testVeiculoM() throws Exception {

		mockMvc.perform(get("/veiculoM"))
        .andExpect(status().isOk())
        .andExpect(forwardedUrl("/WEB-INF/jsp/motocicleta.jsp"));
	}

	@Test
	public void testAddMotocicleta() throws Exception {

		mockMvc.perform(post("/salvaVeiculoM"))
        .andExpect(view().name("redirect:/exibeVeiculos"));
	}

	@Test
	public void testDeleteVeiculo() throws Exception {

		mockMvc.perform(post("/deleteVeiculo/3"))
		.andExpect(view().name("redirect:/exibeVeiculos"));
	}

	@Test
	public void testExibeVeiculos() throws Exception {

		mockMvc.perform(get("/exibeVeiculos"))
        .andExpect(status().isOk())
        .andExpect(forwardedUrl("/WEB-INF/jsp/exibeVeiculos.jsp"));
	}

}
