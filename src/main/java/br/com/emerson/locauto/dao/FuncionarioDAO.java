package br.com.emerson.locauto.dao;

/**
 * @author Emerson Sousa
 * 
 * Esta classe faz o gerenciamento (CRUD) da classe Funcionário no banco de dados
 */
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.emerson.locauto.connection.ConnectionFactory;
import br.com.emerson.locauto.model.Funcionario;


public class FuncionarioDAO {

	private final Logger logger = LoggerFactory.getLogger(FuncionarioDAO.class);

	/**
	 * Salva um Funcionario no banco de dados caso a mesmo não exista,
	 * se já existe faz um upload do Funcionario no banco.
	 * @param funcionario
	 * @return
	 */
	public Funcionario salvar(Funcionario funcionario) {

		EntityManager em = new ConnectionFactory().getConection();
		try {
			logger.info("Iniciando conexao para salvar/editar registro do funcionario");
			em.getTransaction().begin();

			if (funcionario.getId() == null) {
				logger.info("Transação inciada");
				em.persist(funcionario);
				logger.info("Funcionario salva no banco");

			} else {

				em.merge(funcionario);
				logger.info(" Edição em Funcionario salva no banco");
			}

			logger.info("transação comitada no banco");
			em.getTransaction().commit();

		} catch (Exception e) {
			logger.error("Falha ao salvar/editar Funcionario: " + e.getMessage());
			em.getTransaction().rollback();
		} finally {
			em.close();
		}

		return funcionario;

	}

	/**
	 * Busca  o funcionário no banco de dados pelo o id passado como parâmetro e retorna o funcionário encontrado.
	 * @param id
	 * @return
	 */
	public Funcionario buscaPorId(Integer id) {

		EntityManager em = new ConnectionFactory().getConection();
		Funcionario funcionario = null;

		try {

			logger.info("Realizando busca por id na tabela Funcionarios");
			funcionario = em.find(Funcionario.class, id);

		} catch (Exception e) {
			logger.error("A busca Falhou: " + e.getMessage());
		}

		logger.info("retornando resultado da busca");

		return funcionario;

	}
	/**
	 * Recupera uma lista de todos os funcionários armazenados no banco.
	 * @return
	 */

	public List<Funcionario> buscaTodos() {

		EntityManager em = new ConnectionFactory().getConection();
		List<Funcionario> funcionario = null;

		try {
			logger.info("Buscando todos os Funcionarios na tabela");
			funcionario = em.createQuery("FROM Funcionario").getResultList();
		} catch (Exception e) {

			logger.error("Falha na busca: " + e.getMessage());
		} finally {
			em.close();
		}

		return funcionario;
	}

	/**
	 * Deleta do banco de dados o funcionário com id passado como parâmetro.
	 * @param id
	 * @return
	 */
	public boolean deleta(Integer id) {

		EntityManager em = new ConnectionFactory().getConection();
		Funcionario funcionario = null;

		try {

			funcionario = em.find(Funcionario.class, id);
			logger.info("Iniciando transação para deletar Funcionario do banco");
			em.getTransaction().begin();
			em.remove(funcionario);
			em.getTransaction().commit();
			logger.info("Funcionario deletado, transação commitada no banco");

		} catch (Exception e) {
			em.getTransaction().rollback();
			logger.error("Falha ao deletar Funcionario: " + e.getMessage());
			return false;
		} finally {
			em.close();
		}

		return true;
	}

}
