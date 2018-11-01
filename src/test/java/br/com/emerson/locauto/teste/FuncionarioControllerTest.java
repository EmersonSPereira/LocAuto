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

import br.com.emerson.locauto.controller.FuncionarioController;
import br.com.emerson.locauto.model.Gerente;
import br.com.emerson.locauto.model.Locador;
import br.com.emerson.locauto.service.FuncionarioService;

/**
 * Esta é uma classe de test e testa a classe: FuncionarioController
 * @author Emerson
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-servlet-test.xml" })
public class FuncionarioControllerTest {
	
	private MockMvc mockMvc;
	
	@Autowired 
	private FuncionarioService funcionarioService;
	
	private Gerente gerente;
	private Locador locador;
	Integer idGerente, idLocador;
	 

	@Autowired
	private FuncionarioController controller;

	@Before
	public void setUp() throws Exception {
		gerente = new Gerente();
		locador = new Locador();
		 idGerente = funcionarioService.salvar(gerente).getId();
		 idLocador = funcionarioService.salvar(locador).getId();
		
		
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
        .andExpect(view().name("sucessoSalvar"));
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
        .andExpect(view().name("sucessoSalvar"));
	}

	@Test
	public void editarGerente() throws Exception {

		mockMvc.perform(post("/editarFuncionarioG/" + idGerente))
        .andExpect(status().isOk())
        .andExpect(forwardedUrl("/WEB-INF/jsp/gerente.jsp"));
	}
	
	@Test
	public void editarLocador() throws Exception {

		mockMvc.perform(post("/editarFuncionarioL/" + idLocador))
        .andExpect(status().isOk())
        .andExpect(forwardedUrl("/WEB-INF/jsp/locador.jsp"));
	}

	@Test
	public void testExibeFuncionarios() throws Exception {

		mockMvc.perform(get("/exibeFuncionarios"))
        .andExpect(status().isOk())
        .andExpect(forwardedUrl("/WEB-INF/jsp/exibeFuncionarios.jsp"));
	}

}
