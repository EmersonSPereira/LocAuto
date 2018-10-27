package br.com.emerson.locauto.teste;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.joda.time.DateTime;
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
import br.com.emerson.locauto.controller.LocacaoController;
import br.com.emerson.locauto.model.LocacaoClientePJ;
import br.com.emerson.locauto.service.AgenciaService;
import br.com.emerson.locauto.service.LocacaoService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-servlet-test.xml" })
public class LocacaoControllerTest {
	
	@Autowired
	private LocacaoService locacaoService;
	
	private LocacaoClientePJ clientePJ;
	
	private MockMvc mockMvc;

	@Autowired
	private LocacaoController controller;
	
	private AgenciaService service;
	

	@Before
	public void setUp() throws Exception {
		
		clientePJ = new LocacaoClientePJ();
		locacaoService.salvar(clientePJ);
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
 
        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                                 .setViewResolvers(viewResolver)
                                 .build();
	}

	@Test
	public void locacaoClientePF() throws Exception {

		mockMvc.perform(get("/locacaoClientePF"))
        .andExpect(status().isOk())
        .andExpect(forwardedUrl("/WEB-INF/jsp/locacaoClientePF.jsp"));
	}
	
	@Test
	public void locacaoClientePJ() throws Exception {

		mockMvc.perform(get("/locacaoClientePJ"))
        .andExpect(status().isOk())
        .andExpect(forwardedUrl("/WEB-INF/jsp/locacaoClientePJ.jsp"));
	}
	

	@Test
	public void locacaoFInalizarPF() throws Exception {

		mockMvc.perform(get("/locacaoClientePF/finalizar/1"))
        .andExpect(view().name("redirect:/exibeLocacoes"));
	}
	
	@Test
	public void locacaoFInalizarPJ() throws Exception {

		mockMvc.perform(get("/locacaoClientePJ/finalizar/2"))
        .andExpect(view().name("redirect:/exibeLocacoes"));
	}
	
	@Test
	public void testExibeLocacao() throws Exception {

		mockMvc.perform(get("/exibeLocacoes"))
        .andExpect(status().isOk())
        .andExpect(forwardedUrl("/WEB-INF/jsp/exibeLocacoes.jsp"));
	}
	
	@Test
	public void testCalculaDiasLocacao() {
		
		DateTime d1 = new DateTime();
		DateTime d2 = new DateTime();
		assertEquals(0, controller.calculaDiasLocacao(d1, d2));
	}
	
	@Test
	public void calcularValorSeguro() {
		
		assertEquals(50, controller.calcularValorSeguro(100, "Total"));
		assertEquals(25, controller.calcularValorSeguro(100, "Parcial"));
		assertEquals(0, controller.calcularValorSeguro(100, "Nenhum"));
	}

}
