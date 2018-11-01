package br.com.emerson.locauto.teste;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.emerson.locauto.model.Cliente;
import br.com.emerson.locauto.model.ClientePF;
import br.com.emerson.locauto.model.Locacao;
import br.com.emerson.locauto.model.LocacaoClientePF;
import br.com.emerson.locauto.service.ClienteService;
import br.com.emerson.locauto.service.LocacaoService;
/**
 * Esta é uma classe de test e testa o DAO: Locacao
 * @author Emerson
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-servlet-test.xml"})
public class LocacaoDAOTest {

	@Autowired
	private LocacaoService dao;
	
	@Autowired
	private ClienteService clienteService;
	
	private ClientePF clientepf;
	private LocacaoClientePF lc2;
	private Locacao lc1;
	private List<Locacao> locacoes;
	@Before
	public void setUp() throws Exception {
		clientepf = new ClientePF();
		clientepf.setNome("Emerson");
		clienteService.salvar(clientepf);
		lc1 = new Locacao();
		lc1.setNivelDoTanque("Cheio");
		
		lc2 = new LocacaoClientePF();
		lc2.setStatus("Ativa");
		lc2.setClientePF(clientepf);
		
	}

	@Test
	public void testSalvar() {
		
		assertEquals(lc1, dao.salvar(lc1));
	}

	@Test
	public void testBuscaPorId() {
		lc1.setId(1);
		dao.salvar(lc1);
		assertEquals("Cheio", dao.buscaPorId(1).getNivelDoTanque());
	}

	@Test
	public void testBuscaTodos() {
		dao.salvar(lc1);
		locacoes = dao.buscaTodos();
		assertFalse(locacoes.isEmpty());
		
	}

	@Test
	public void testBuscaPorTipoCliente() {
		dao.salvar(lc2);
		locacoes = dao.buscaPorTipoCliente("PF");
		for (Locacao locacao : locacoes) {

			assertEquals("PF", locacao.getCliente());

		}
	}
	
	@Test
	public void testDeleteLocacao() {
		
		Integer idValido = dao.salvar(lc2).getId();
		assertTrue(dao.deleta(idValido));
	}
	
	@Test
	public void testBuscaporTipoStatus() {
		dao.salvar(lc2);
		locacoes = dao.buscaPorTipoClienteStatus("PF", "Ativa");
		assertFalse(locacoes.isEmpty());
	}

}
