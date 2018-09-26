package br.com.emerson.locauto.teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.emerson.locauto.model.Cliente;
import br.com.emerson.locauto.model.ClientePF;
import br.com.emerson.locauto.model.ClientePJ;
import br.com.emerson.locauto.service.ClienteService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-servlet-test.xml" })
public class ClienteDAOTest {

	@Autowired
	private ClienteService dao;
	private ClientePF c1;
	private ClientePJ c2;
	private ClientePF c3;
	private List<Cliente> clientes;

	@Before
	public void setUp() throws Exception {

		c1 = new ClientePF();
		c1.setNome("Emerson");
		c1.setCpf("356.004.750-12");
		c1.setDatNasc("31/12/2000");
		c1.setEmail("emerson@gmail.com");
		c1.setEndereco("Rua da umburanas, 98, Malvinas, Campina Grande, Paraiba");
		c1.setNaturalidade("Campina Grande");
		c1.setRg("3999777");
		c1.setTelefone("(83)9 9999-8888");

		c2 = new ClientePJ();
		c2.setNomeFantasia("shostners and shostners");
		c2.setRazaoSocial("shostners LMTD");
		c2.setCnpj("73.806.128/0001-10");
		c2.setInscEstadual("86264232-9");
		c2.setEmail("shostners@shostners.com");
		c2.setTelefone("(71) 2903-0490");
		c2.setEndereco("Avenida Ferreira, 187, Pero Vaz, Salvador,BA");

		c3 = new ClientePF();
	}

	@Test
	public void testSalvar() {

		// teste salvar
		assertEquals(c1, dao.salvar(c1));

		// setando o id do cliente a ser editado
		c1.setId(1);
		c1.setNome("Joao");

		// test editar cliente
		c1 = (ClientePF) dao.salvar(c1);
		assertEquals("Joao", c1.getNome());
	}

	@Test
	public void testBuscaPorId() {
		//salvando um cliente no banco
		dao.salvar(c1);

		// recuperando o id do ultimo cliente adicionado no banco

		clientes = dao.buscaTodos();
		Cliente cliente = clientes.get(clientes.size() - 1); // recuperando o ultimo cliente inserido no banco
		Integer idultimo = cliente.getId(); // recuperando o id do cliente
		
		//alterando o nome para comparar na busca
		c1.setId(idultimo);
		c1.setNome("Java");
		dao.salvar(c1);

		// teste de busca
		c1 = (ClientePF) dao.buscaPorId(idultimo);
		assertEquals("Java", c1.getNome());
	}

	@Test
	public void testBuscaTodos() {

		// salvando um cliente no banco
		dao.salvar(c2);

		/*
		 * O metodo buscaTodos retorna uma lista de clientes com todos os clientes
		 * contidos no banco, o teste abaixo verifica se a lista esta vazia, como
		 * anteriormente foi inserido um cliente no banco o teste tem que dar falso.
		 */

		assertFalse(dao.buscaTodos().isEmpty());
	}

	@Test
	public void testDeleta() {

		// salvando um cliente no banco
		dao.salvar(c2);

		// recebendo todos os clientes do banco

		clientes = dao.buscaTodos();
		Cliente cliente = clientes.get(clientes.size() - 1); // recuperando o ultimo cliente inserido no banco
		Integer idValido = cliente.getId(); // recuperando o id do cliente

		/*
		 * O metodo deleta recebe um id como parametro e deleta o veiculo que possui o
		 * id do banco, o teste abaixo deleta o ultimo veiculo inserido no banco
		 */

		assertTrue(dao.deleta(idValido));

		// testando o metodo deleta passando um Id inexistente
		assertFalse(dao.deleta(498498456));
	}

}
