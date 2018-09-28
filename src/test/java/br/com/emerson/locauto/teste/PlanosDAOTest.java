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
import br.com.emerson.locauto.model.Planos;
import br.com.emerson.locauto.model.PlanosCarro;
import br.com.emerson.locauto.model.PlanosMoto;
import br.com.emerson.locauto.service.PlanosService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-servlet-test.xml" })
public class PlanosDAOTest {

	private PlanosCarro planoCarroA, planoCarroB;
	private PlanosMoto planoMotoA, planoMotoB;
	private List<Planos> planos;

	@Autowired
	private PlanosService dao;

	@Before
	public void setUp() throws Exception {

		planoCarroA = new PlanosCarro();
		planoCarroA.setPlano("A");
		planoCarroA.setVeiculos("Celta, Pálio, Gol ");
		planoCarroA.setCilindradas(1000);
		planoCarroA.setAcessorios("Sem AC - 2P");

		planoCarroB = new PlanosCarro();
		planoCarroB.setPlano("B");
		planoCarroB.setVeiculos("Celta, Pálio, Gol, Sandero ");
		planoCarroB.setCilindradas(1000);
		planoCarroB.setAcessorios("AC - 2P/4P");

		planoMotoA = new PlanosMoto();
		planoMotoA.setPlano("A");
		planoMotoA.setVeiculos("Honda Biz, Honda CG, Yahama YBR, Traxx Fly");
		planoMotoA.setCilindradas(125);

		planoMotoB = new PlanosMoto();
		planoMotoB.setPlano("B");
		planoMotoB.setVeiculos("Honda CBX, Yahaha XTZ ");
		planoMotoB.setCilindradas(250);

	}

	@Test
	public void testSalvar() {

		// teste salvar
		assertEquals(planoCarroA, dao.salvar(planoCarroA));

		// setando o id do plano a ser editado
		planoCarroA.setId(1);
		planoCarroA.setCilindradas(2000);

		// test editar plano
		Integer cilindradas = 2000;
		planoCarroA = (PlanosCarro) dao.salvar(planoCarroA);
		assertEquals(cilindradas, planoCarroA.getCilindradas());

	}

	@Test
	public void testBuscaPorId() {

		// salvando um plano no banco
		dao.salvar(planoMotoA);

		// recuperando o id do ultimo plano adicionado no banco

		planos = dao.buscaTodos();
		Planos plano = planos.get(planos.size() - 1); // recuperando o ultimo plano inserido no banco
		Integer idultimo = plano.getId(); // recuperando o id do plano

		planoMotoA = (PlanosMoto) dao.buscaPorId(idultimo);// realizando uma busca por id
		assertEquals(idultimo, planoMotoA.getId());
	}

	@Test
	public void testBuscaTodos() {

		// salvando um plano no banco
		dao.salvar(planoCarroB);

		/*
		 * O metodo buscaTodos retorna uma lista de planos com todos os clientes
		 * contidos no banco, o teste abaixo verifica se a lista esta vazia, como
		 * anteriormente foi inserido um cliente no banco o teste tem que dar falso.
		 */

		assertFalse(dao.buscaTodos().isEmpty());
	}

	@Test
	public void testBuscaPorTipo() {
		// buscando planos do tipo PC = Plano Carro
		planos = dao.buscaPorTipo("PC");

		// verificando se todos os planos trazidos na busca são do tipo PC
		for (Planos plano : planos) {

			assertEquals("PC", plano.getTipo());

		}
	}

	@Test
	public void testDeleta() {

		// salvando um plano no banco
		dao.salvar(planoMotoB);

		// recuperando o id do ultimo plano adicionado no banco

		planos = dao.buscaTodos();
		Planos plano = planos.get(planos.size() - 1); // recuperando o ultimo plano inserido no banco
		Integer idultimo = plano.getId(); // recuperando o id do plano

		/*
		 * O metodo deleta recebe um id como parametro e deleta o plano que possui o id
		 * do banco, o teste abaixo deleta o ultimo plano inserido no banco
		 */

		assertTrue(dao.deleta(idultimo));

		// testando o metodo deleta passando um Id inexistente
		assertFalse(dao.deleta(498498456));
	}

}
