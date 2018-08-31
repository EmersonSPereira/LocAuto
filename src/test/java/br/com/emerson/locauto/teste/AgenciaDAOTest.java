package br.com.emerson.locauto.teste;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.emerson.locauto.dao.AgenciaDAO;
import br.com.emerson.locauto.model.Agencia;

public class AgenciaDAOTest {

	AgenciaDAO dao;
	Agencia ag1,ag2;
	List<Agencia> agencias;

	@Before
	public void setUp() throws Exception {
		dao = new AgenciaDAO();
		ag1 = new Agencia();
		ag2 = new Agencia();
		agencias = null;
		
	}

	@Test
	public void testSalvar() {

		ag1.setCnpj("546545465451");
		ag1.setGerenteResponsavel("Emerson Sousa ");
		ag1.setInscEstadual("2152165");
		ag1.setTelefone("839999999");

		// salvando agencia primeira vez
		assertEquals(ag1, dao.salvar(ag1));

		// Testando edição da agencia
		ag1.setId(1);// setando o id da agencia a ser editada
		ag1.setGerenteResponsavel("Emerson");
		assertEquals("Emerson", dao.salvar(ag1).getGerenteResponsavel());

	}

	@Test
	public void TestDeleta() {
		
		ag2.setCnpj("546545465451");
		ag2.setGerenteResponsavel("Emerson Sousa ");
		ag2.setInscEstadual("2152165");
		ag2.setTelefone("839999999");
		dao.salvar(ag2);
		
		
		agencias = dao.buscaTodos();
		
		Agencia agencia = agencias.get(agencias.size() - 1);
		Integer idValido = agencia.getId();
				
		
		
		assertTrue(dao.deleta(idValido));
		
		//falha ao deletar id não existente
		assertFalse(dao.deleta(5464646));


		
		
	}

}
