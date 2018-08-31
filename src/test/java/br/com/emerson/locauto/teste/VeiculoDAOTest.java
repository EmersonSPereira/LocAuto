package br.com.emerson.locauto.teste;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.emerson.locauto.dao.VeiculoDAO;
import br.com.emerson.locauto.model.Carro;
import br.com.emerson.locauto.model.Motocicleta;
import br.com.emerson.locauto.model.Veiculo;

public class VeiculoDAOTest {

	VeiculoDAO dao;
	Motocicleta moto;
	Carro carro;
	List<Veiculo> veiculos;

	@Before
	public void setUp() throws Exception {
		
		dao = new VeiculoDAO();

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
		carro.setAcessorios("Ar, Trava, Direção");
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
		//alterando a cor da moto com id = 1 para posteriormente comparar no teste de busca
		moto.setId(1);
		moto.setCor("Preta");
		dao.salvar(moto);

		//teste de busca
		assertEquals("Preta", dao.buscaPorId(1).getCor());
	}

	@Test
	public void testBuscaTodos() {
		//salvando um veiculo no banco
		dao.salvar(carro);
		
		/* O método buscaTodos retorna uma lista de veiculos com todos os veiculos
		 * contidos no banco, o teste abaixo verifica se a lista é vazia, como anteriormente
		 * foi inserido um veiculo no banco o teste tem que dar falso.
		 */
		assertFalse(dao.buscaTodos().isEmpty());
	}

	@Test
	public void testDeleta() {
		
		//salvando um veiculo no banco
		dao.salvar(carro);

		//recebendo todos os veiculos no banco
		veiculos = dao.buscaTodos();
		Veiculo veiculo = veiculos.get(veiculos.size()- 1);
		Integer idValido = veiculo.getId();

		/* O metodo deleta recebe um id como parametro e deleta o veiculo que possui o id do
		 * banco, o teste abaixo deleta o ultimo veiculo inserido no banco
		 */
		assertTrue(dao.deleta(idValido));

		//testando o metodo deleta passando um Id inexistente
		assertFalse(dao.deleta(498498456));

	}

}
