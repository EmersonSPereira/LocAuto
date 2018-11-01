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

import br.com.emerson.locauto.controller.AgenciaController;
import br.com.emerson.locauto.service.AgenciaService;

/**
 * Esta é uma classe de test e testa a classe: AgenciaController
 * @author Emerson
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-servlet-test.xml" })
public class AgenciaControllerTest {
	
	
	private MockMvc mockMvc;

	@Autowired
	private AgenciaController controller;
	
	private AgenciaService service;
	

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
	public void testAgencia() throws Exception {

		mockMvc.perform(get("/agencia"))
        .andExpect(status().isOk())
        .andExpect(forwardedUrl("/WEB-INF/jsp/agencia.jsp"));
	}

	@Test
	public void testAddAgencia() throws Exception {

		mockMvc.perform(post("/add"))
        .andExpect(view().name("sucessoSalvar"));
	}
	@Test
	public void editarAgencia() throws Exception {

		mockMvc.perform(post("/editar/1"))
        .andExpect(status().isOk())
        .andExpect(forwardedUrl("/WEB-INF/jsp/agencia.jsp"));
	}

	
	@Test
	public void testExibeAgencias() throws Exception {

		mockMvc.perform(get("/exibeAgencias"))
        .andExpect(status().isOk())
        .andExpect(forwardedUrl("/WEB-INF/jsp/exibeAgencias.jsp"));
	}

}
