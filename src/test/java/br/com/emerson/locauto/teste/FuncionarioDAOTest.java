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

import br.com.emerson.locauto.model.Funcionario;
import br.com.emerson.locauto.model.Gerente;
import br.com.emerson.locauto.model.Locador;
import br.com.emerson.locauto.service.FuncionarioService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-servlet-test.xml"})
public class FuncionarioDAOTest {

	@Autowired
	private FuncionarioService dao;
	private Gerente f1;
	private Locador f2;
	private List<Funcionario> funcionarios;

	@Before
	public void setUp() throws Exception {

		

		f1 = new Gerente();
		f1.setCpf("454654564-54");
		f1.setDataNascimento("21/10/1999");
		f1.setEmail("lalalall@gmail.com,");
		f1.setEndereco("Rua lalala, monte santo,888, campina grande, Paraiba");
		f1.setNaturalidade("Campina Grande");
		f1.setNome("J�ao Pedro");
		f1.setRg("46546465");
		f1.setTelefone("8399887415");

		f2 = new Locador();
		f2.setCpf("999887055-53");
		f2.setDataNascimento("08/5/1985");
		f2.setEmail("lalalall@gmail.com,");
		f2.setEndereco("Rua lalala, Santo Antonio,26, campina grande, Paraiba");
		f2.setNaturalidade("Campina Grande");
		f2.setNome("Araujo SIlva");
		f2.setRg("555555");
		f2.setTelefone("83999888899");
	}

	@Test
	public void testSalvar() {

		// teste salvar
		assertEquals(f1, dao.salvar(f1));

		// setando o id do funcionario a ser editado
		f1.setId(1);
		f1.setNome("Jo�o");

		// test editar funcionario
		assertEquals("Jo�o", dao.salvar(f1).getNome());
	}

	@Test
	public void testBuscaPorId() {
		// Salvando um novo funcionario no banco
		f1.setId(1);
		f1.setRg("5805933");
		dao.salvar(f1);

		funcionarios = dao.buscaTodos();

		// teste busca o ultimo funcionario adicionado no banco pelo id e compara seu rg
		assertEquals("5805933", dao.buscaPorId(1).getRg());
	}

	@Test
	public void testBuscaTodos() {
		dao.salvar(f2);

		/*
		 * O m�todo buscaTodos retorna uma lista de Funcionarios com todos os veiculos
		 * contidos no banco, o teste abaixo verifica se a lista � vazia, como
		 * anteriormente foi inserido um funcionario no banco o teste tem que dar falso.
		 */

		assertFalse(dao.buscaTodos().isEmpty());
	}

	@Test
	public void testDeleta() {

		// salvando um funcionario no banco
		dao.salvar(f1);

		// recebendo todos os Funcionarios no banco
		funcionarios = dao.buscaTodos();
		Funcionario f3 = funcionarios.get(funcionarios.size() - 1);
		Integer idValido = f3.getId();

		for (Funcionario f1 : funcionarios) {

			System.out.println(f1.getNome());

		}

		/*
		 * O metodo deleta recebe um id como parametro e deleta o funcionario que possui
		 * o id do banco, o teste abaixo deleta o ultimo funcionario inserido no banco.
		 */
		assertTrue(dao.deleta(idValido));
		
		funcionarios = dao.buscaTodos();
		for (Funcionario f1 : funcionarios) {

			System.out.println(f1.getNome());

		}


		// testando o metodo deleta passando um Id inexistente
		assertFalse(dao.deleta(687684641));

	}

}
