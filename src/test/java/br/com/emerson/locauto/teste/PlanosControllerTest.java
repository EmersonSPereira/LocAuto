package br.com.emerson.locauto.teste;

import static org.junit.Assert.assertTrue;
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

import br.com.emerson.locauto.controller.PlanosController;
/**
 * Esta é uma classe de test e testa a classe: PlanosController
 * @author Emerson
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-servlet-test.xml" })
public class PlanosControllerTest {

	
	private MockMvc mockMvc;

	@Autowired
	private PlanosController controller;
	
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
	public void testPlanoC() throws Exception {
		
		mockMvc.perform(get("/planoC"))
        .andExpect(status().isOk())
        .andExpect(forwardedUrl("/WEB-INF/jsp/planoCarro.jsp"));
	}

	@Test
	public void testAddPlanoC() throws Exception {

		mockMvc.perform(post("/salvaPlanoC"))
        .andExpect(view().name("sucessoSalvar"));
	}

	@Test
	public void testPlanoM() throws Exception {
		
		mockMvc.perform(get("/planoM"))
        .andExpect(status().isOk())
        .andExpect(forwardedUrl("/WEB-INF/jsp/planoMotocicleta.jsp"));
	}

	@Test
	public void testAddPlanoM() throws Exception {

		mockMvc.perform(post("/salvaPlanoM"))
        .andExpect(view().name("sucessoSalvar"));
	}


	@Test
	public void testExibePlanos() throws Exception {
		mockMvc.perform(get("/exibePlanos"))
        .andExpect(status().isOk())
        .andExpect(forwardedUrl("/WEB-INF/jsp/exibePlanos.jsp"));
	}

	@Test
	public void testSalvaPlanosCarro() {
		
		assertTrue(controller.salvaPlanosCarro());
	}

	@Test
	public void testSalvaPlanosMoto() {

		assertTrue(controller.salvaPlanosMoto());
	}

}
