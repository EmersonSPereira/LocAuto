package br.com.emerson.locauto.dao;
/**
 * @author Emerson Sousa
 * 
 * Esta classe faz o gerenciamento (CRUD) da classe agencia no banco de dados
 */

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.emerson.locauto.connection.ConnectionFactory;
import br.com.emerson.locauto.model.Agencia;

public class AgenciaDAO {

	private final Logger logger = LoggerFactory.getLogger(AgenciaDAO.class);

	/**
	 * Salva uma agencia no banco de dados caso a mesma n�o exista, se j� existe faz
	 * um upload da ag�ncia no banco.
	 * 
	 * @param agencia
	 * @return
	 */
	public Agencia salvar(Agencia agencia) {

		logger.info("Iniciando conexao para salvar/editar registro da agencia");
		EntityManager em = new ConnectionFactory().getConection();

		try {

			logger.info("Transa��o inciada");
			em.getTransaction().begin();
			if (agencia.getId() == null) {

				em.persist(agencia);
				logger.info("Agencia salva no banco");
			} else {

				em.merge(agencia);
				logger.info("Edi��o de Agencia salva no banco");

			}

			logger.info("transa��o comitada no banco");
			em.getTransaction().commit();

		} catch (Exception e) {
			logger.error("Falha ao salvar/editar agencia: " + e.getMessage());
			em.getTransaction().rollback();
		} finally {

			em.close();

		}

		return agencia;
	}

	/**
	 * Busca  a ag�ncia no banco de dados pelo o id passado como par�metro e retorna a ag�ncia encontrada.
	 * @param id
	 * @return
	 */
	public Agencia buscaPorId(Integer id) {

		EntityManager em = new ConnectionFactory().getConection();
		Agencia agencia = null;

		try {

			logger.info("Realizando busca por id na tabela Funcionarios");
			agencia = em.find(Agencia.class, id);

		} catch (Exception e) {
			logger.error("A busca Falhou: " + e.getMessage());
		}

		logger.info("retornando resultado da busca");

		return agencia;

	}

	/**
	 * Recupera uma lista de todas as ag�ncias armazenadas no banco
	 * 
	 * @return
	 */
	public List<Agencia> buscaTodos() {

		EntityManager em = new ConnectionFactory().getConection();
		List<Agencia> agencias = null;

		try {
			logger.info("Buscando todas as agencias na tabela");
			agencias = em.createQuery("FROM Agencia").getResultList();
		} catch (Exception e) {

			logger.error("Falha na busca: " + e.getMessage());
		} finally {
			em.close();
		}

		return agencias;
	}

	/**
	 * Deleta do banco de dados a ag�ncia com id passado como par�metro do banco de
	 * dados
	 * 
	 * @param id
	 * @return
	 */
	public boolean deleta(Integer id) {

		EntityManager em = new ConnectionFactory().getConection();
		Agencia agencia = null;

		try {

			agencia = em.find(Agencia.class, id);
			logger.info("Iniciando transa��o para deletar agencia do banco");
			em.getTransaction().begin();
			em.remove(agencia);
			em.getTransaction().commit();
			logger.info("agencia deletado, transa��o commitada no banco");

		} catch (Exception e) {
			em.getTransaction().rollback();
			logger.error("Falha ao deletar agencia: " + e.getMessage());
			return false;

		} finally {
			em.close();
		}

		return true;
	}

}
