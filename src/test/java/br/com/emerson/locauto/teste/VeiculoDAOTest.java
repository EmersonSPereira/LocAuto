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

import br.com.emerson.locauto.model.Carro;
import br.com.emerson.locauto.model.Cliente;
import br.com.emerson.locauto.model.Motocicleta;
import br.com.emerson.locauto.model.Planos;
import br.com.emerson.locauto.model.Veiculo;
import br.com.emerson.locauto.service.VeiculoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-servlet-test.xml" })
public class VeiculoDAOTest {

	@Autowired
	private VeiculoService dao;
	private Motocicleta moto;
	private Carro carro;
	private List<Veiculo> veiculos;

	@Before
	public void setUp() throws Exception {

		moto = new Motocicleta();
		moto.setMarca("Honda");
		moto.setCor("Azul");
		moto.setModelo("Titan");
		moto.setAgencia("Campina Grande");
		moto.setPotencia(75);
		moto.setFreios("ABS");
		moto.setCilindradas(160);
		moto.setRenavam("545464646464");
		moto.setTipoCombustivel("Flex");
		moto.setAno(1995);

		carro = new Carro();
		carro.setMarca("Fiat");
		carro.setModelo("uno");
		carro.setCor("Vermelho");
		carro.setPotencia(65);
		carro.setRenavam("546546545");
		carro.setAcessorios("Ar, Trava, Direestáestáo");
		carro.setAgencia("Campina Grande");
		carro.setTipoCombustivel("Gasolina");
		carro.setAno(2010);
		veiculos = null;
	}

	@Test
	public void testSalvar() {

		// teste salvar
		assertEquals(moto, dao.salvar(moto));

		// teste editar veiculo
		moto.setId(1); // setando id do veiculo a ser editado
		moto.setCor("Amarela");
		assertEquals("Amarela", dao.salvar(moto).getCor());
	}

	@Test
	public void testBuscaPorId() {
		// salvando um veiculo no banco
		dao.salvar(moto);

		// recuperando o id do ultimo cliente adicionado no banco

		veiculos = dao.buscaTodos();
		Veiculo veiculo = veiculos.get(veiculos.size() - 1); // recuperando o ultimo cliente inserido no banco
		Integer idultimo = veiculo.getId(); // recuperando o id do cliente

		// alterando a cor para comparar na busca
		moto.setId(idultimo);
		moto.setCor("Preta");
		dao.salvar(moto);
		// teste de busca
		assertEquals("Preta", dao.buscaPorId(idultimo).getCor());
	}

	@Test
	public void testBuscaTodos() {
		// salvando um veiculo no banco
		dao.salvar(carro);

		/*
		 * O mestátodo buscaTodos retorna uma lista de veiculos com todos os veiculos
		 * contidos no banco, o teste abaixo verifica se a lista está vazia, como
		 * anteriormente foi inserido um veiculo no banco o teste tem que dar falso.
		 */
		assertFalse(dao.buscaTodos().isEmpty());
	}

	@Test
	public void testBuscaPorTipo() {
		// buscando planos do tipo M = Motocicleta
		veiculos = dao.buscaPorTipo("M");

		// verificando se todos os planos trazidos na busca são do tipo Motocicleta
		for (Veiculo veiculo : veiculos) {

			assertEquals("M", veiculo.getTipo());

		}
	}

	@Test
	public void testDeleta() {

		// salvando um veiculo no banco
		dao.salvar(carro);

		// recebendo todos os veiculos no banco
		veiculos = dao.buscaTodos();
		Veiculo veiculo = veiculos.get(veiculos.size() - 1);
		Integer idValido = veiculo.getId();

		/*
		 * O metodo deleta recebe um id como parametro e deleta o veiculo que possui o
		 * id do banco, o teste abaixo deleta o ultimo veiculo inserido no banco
		 */
		assertTrue(dao.deleta(idValido));

		// testando o metodo deleta passando um Id inexistente
		assertFalse(dao.deleta(498498456));

	}

}
