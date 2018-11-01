package br.com.emerson.locauto.teste;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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

import br.com.emerson.locauto.controller.LocacaoController;
import br.com.emerson.locauto.model.ClientePF;
import br.com.emerson.locauto.model.ClientePJ;
import br.com.emerson.locauto.model.LocacaoClientePF;
import br.com.emerson.locauto.model.LocacaoClientePJ;
import br.com.emerson.locauto.model.Locador;
import br.com.emerson.locauto.model.Planos;
import br.com.emerson.locauto.model.Veiculo;
import br.com.emerson.locauto.service.AgenciaService;
import br.com.emerson.locauto.service.ClienteService;
import br.com.emerson.locauto.service.FuncionarioService;
import br.com.emerson.locauto.service.LocacaoService;
import br.com.emerson.locauto.service.PlanosService;
import br.com.emerson.locauto.service.VeiculoService;

/**
 * Esta é uma classe de test e testa a classe: LocacaoController
 * @author Emerson
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-servlet-test.xml" })
public class LocacaoControllerTest {

	@Autowired
	private LocacaoService locacaoService;

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private FuncionarioService funcionarioService;

	@Autowired
	private PlanosService planosService;

	@Autowired
	private VeiculoService veiculoService;

	private LocacaoClientePJ locacaoClientePJ;
	private LocacaoClientePF locacaoClientePF;
	private ClientePJ cliente;
	private ClientePF clientepf;
	private Locador locador;
	private Planos plano;
	private Veiculo veiculo;

	Integer idPJ, idPF;

	private MockMvc mockMvc;

	@Autowired
	private LocacaoController controller;

	private AgenciaService service;

	@Before
	public void setUp() throws Exception {

		clientepf = new ClientePF();
		cliente = new ClientePJ();
		locador = new Locador();
		plano = new Planos();
		veiculo = new Veiculo();

		locacaoClientePJ = new LocacaoClientePJ();
		locacaoClientePJ.setLocador((Locador) funcionarioService.salvar(locador));
		locacaoClientePJ.setClientePJ((ClientePJ) clienteService.salvar(cliente));
		locacaoClientePJ.setPlano(planosService.salvar(plano));
		locacaoClientePJ.setVeiculo(veiculoService.salvar(veiculo));
		idPJ = locacaoService.salvar(locacaoClientePJ).getId();

		locacaoClientePF = new LocacaoClientePF();
		locacaoClientePF.setLocador((Locador) funcionarioService.salvar(locador));
		locacaoClientePF.setClientePF((ClientePF) clienteService.salvar(clientepf));
		locacaoClientePF.setPlano(planosService.salvar(plano));
		locacaoClientePF.setVeiculo(veiculoService.salvar(veiculo));
		idPF = locacaoService.salvar(locacaoClientePF).getId();

		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/jsp/");
		viewResolver.setSuffix(".jsp");

		mockMvc = MockMvcBuilders.standaloneSetup(controller).setViewResolvers(viewResolver).build();
	}

	@Test
	public void locacaoClientePF() throws Exception {

		mockMvc.perform(get("/locacaoClientePF")).andExpect(status().isOk())
				.andExpect(forwardedUrl("/WEB-INF/jsp/locacaoClientePF.jsp"));
	}

	@Test
	public void locacaoClientePJ() throws Exception {

		mockMvc.perform(get("/locacaoClientePJ")).andExpect(status().isOk())
				.andExpect(forwardedUrl("/WEB-INF/jsp/locacaoClientePJ.jsp"));
	}

	@Test
	public void locacaoFInalizarPF() throws Exception {

		mockMvc.perform(get("/locacaoClientePF/finalizar/1")).andExpect(view().name("redirect:/exibeLocacoesAtiva"));
	}

	@Test
	public void locacaoFInalizarPJ() throws Exception {

		mockMvc.perform(get("/locacaoClientePJ/finalizar/" + idPJ))
				.andExpect(view().name("redirect:/exibeLocacoesAtiva"));
	}

	@Test
	public void locacaoCalculaDebitosPJ() throws Exception {

		mockMvc.perform(get("/locacaoClientePJ/calcularDebitos/" + idPJ))
				.andExpect(view().name("saldarDebitosClientePJ"));
	}

	@Test
	public void locacaofizanlizarDebitosPJ() throws Exception {

		mockMvc.perform(get("/locacaoClientePJ/finalizarSaldarDebitos/finalizar/" + idPJ))
				.andExpect(view().name("sucessoSalvar"));
	}

	@Test
	public void locacaoCalculaDebitosPF() throws Exception {

		mockMvc.perform(get("/locacaoClientePF/calcularDebitos/" + idPF))
				.andExpect(view().name("saldarDebitosClientePF"));
	}

	@Test
	public void locacaofizanlizarDebitosPF() throws Exception {

		mockMvc.perform(get("/locacaoClientePf/finalizarSaldarDebitos/finalizar/" + idPF))
				.andExpect(view().name("sucessoSalvar"));
	}
	
	@Test
	public void cancelarLocacao() throws Exception {

		mockMvc.perform(get("/locacao/cancelar/" + idPJ))
				.andExpect(view().name("sucessoSalvar"));
	}


	@Test
	public void testExibeLocacaoAtiva() throws Exception {

		mockMvc.perform(get("/exibeLocacoesAtiva")).andExpect(status().isOk())
				.andExpect(forwardedUrl("/WEB-INF/jsp/exibeLocacoesAtiva.jsp"));
	}

	@Test
	public void testExibeLocacaoFinalizada() throws Exception {

		mockMvc.perform(get("/exibeLocacoesFinalizada")).andExpect(status().isOk())
				.andExpect(forwardedUrl("/WEB-INF/jsp/exibeLocacoesFinalizada.jsp"));
	}

	@Test
	public void testExibeLocacaoCancelada() throws Exception {

		mockMvc.perform(get("/exibeLocacoesCancelada")).andExpect(status().isOk())
				.andExpect(forwardedUrl("/WEB-INF/jsp/exibeLocacoesCancelada.jsp"));
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
