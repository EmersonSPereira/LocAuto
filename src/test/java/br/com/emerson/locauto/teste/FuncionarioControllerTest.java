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

import br.com.emerson.controller.FuncionarioController;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-servlet-test.xml" })
public class FuncionarioControllerTest {
	
	private MockMvc mockMvc;

	@Autowired
	private FuncionarioController controller;

	@Before
	public void setUp() throws Exception {
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
 
        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                                 .setViewResolvers(viewResolver)
                                 .build();
	}

	@Test
	public void testFuncionarioG() throws Exception {

		mockMvc.perform(get("/funcionarioG"))
        .andExpect(status().isOk())
        .andExpect(forwardedUrl("/WEB-INF/jsp/gerente.jsp"));
	}

	@Test
	public void testAddFuncionarioG() throws Exception {

		mockMvc.perform(post("/salvaFuncionarioG"))
        .andExpect(view().name("redirect:/exibeFuncionarios"));
	}

	@Test
	public void testFuncionarioL() throws Exception {

		mockMvc.perform(get("/funcionarioL"))
        .andExpect(status().isOk())
        .andExpect(forwardedUrl("/WEB-INF/jsp/locador.jsp"));
	}

	@Test
	public void testAddFuncionarioL() throws Exception {

		mockMvc.perform(post("/salvaFuncionarioL"))
        .andExpect(view().name("redirect:/exibeFuncionarios"));
	}

	@Test
	public void testDeleteFuncionario() throws Exception {

		mockMvc.perform(post("/deleteFuncionario/3"))
		.andExpect(view().name("redirect:/exibeFuncionarios"));
	}

	@Test
	public void testExibeFuncionarios() throws Exception {

		mockMvc.perform(get("/exibeFuncionarios"))
        .andExpect(status().isOk())
        .andExpect(forwardedUrl("/WEB-INF/jsp/exibeFuncionarios.jsp"));
	}

}
