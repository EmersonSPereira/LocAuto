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

import br.com.emerson.locauto.controller.ClienteController;
import br.com.emerson.locauto.model.ClientePF;
import br.com.emerson.locauto.model.ClientePJ;
import br.com.emerson.locauto.service.ClienteService;
/**
 * Esta é uma classe de test e testa a classe: ClienteController
 * @author Emerson
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-servlet-test.xml" })
public class ClienteControllerTest {


	private MockMvc mockMvc;
	
	@Autowired
	private ClienteService clienteService;

	@Autowired
	private ClienteController controller;
	
	private ClientePF pf;
	private ClientePJ pj;
	
	Integer idpf, idpj;

	@Before
	public void setUp() throws Exception {
		
		pf = new ClientePF();
		pj = new ClientePJ();
		
		idpf = clienteService.salvar(pf).getId();
		idpj = clienteService.salvar(pj).getId();

		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
 
        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                                 .setViewResolvers(viewResolver)
                                 .build();
	}

	@Test
	public void testClientePF() throws Exception {

		 mockMvc.perform(get("/clientePF"))
         .andExpect(status().isOk())
         .andExpect(forwardedUrl("/WEB-INF/jsp/clientePF.jsp"));
	}

	@Test
	public void testClientePJ() throws Exception {
		mockMvc.perform(get("/clientePJ"))
        .andExpect(status().isOk())
        .andExpect(forwardedUrl("/WEB-INF/jsp/clientePJ.jsp"));
	}

	@Test
	public void testAddCliente() throws Exception {
		mockMvc.perform(post("/salvaClientePF"))
        .andExpect(view().name("sucessoSalvar"));
	}

	@Test
	public void testAddClientePJ() throws Exception {
		mockMvc.perform(post("/salvaClientePJ"))
		.andExpect(view().name("sucessoSalvar"));
	}

	@Test
	public void editarClientePF() throws Exception {

		mockMvc.perform(post("/editarClientePF/" + idpf))
        .andExpect(status().isOk())
        .andExpect(forwardedUrl("/WEB-INF/jsp/clientePF.jsp"));
	}
	
	@Test
	public void editarClientePJ() throws Exception {

		mockMvc.perform(post("/editarClientePJ/" + idpj))
        .andExpect(status().isOk())
        .andExpect(forwardedUrl("/WEB-INF/jsp/clientePJ.jsp"));
	}


	@Test
	public void testExibeClientes() throws Exception {
		mockMvc.perform(get("/exibeClientes"))
        .andExpect(status().isOk())
        .andExpect(forwardedUrl("/WEB-INF/jsp/exibeClientes.jsp"));
	}

}
