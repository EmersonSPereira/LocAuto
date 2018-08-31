package br.com.emerson.locauto.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.emerson.locauto.connection.ConnectionFactory;
import br.com.emerson.locauto.model.Agencia;



public class AgenciaDAO {

	private final Logger logger = LoggerFactory.getLogger(AgenciaDAO.class);

	public Agencia salvar(Agencia agencia) {

		logger.info("Iniciando conexao para salvar/editar registro da agencia");
		EntityManager em = new ConnectionFactory().getConection();

		try {

			logger.info("Transação inciada");
			em.getTransaction().begin();
			if (agencia.getId() == null) {

				em.persist(agencia);
				logger.info("Agencia salva no banco");
			} else {

				em.merge(agencia);
				logger.info("Edição de Agencia salva no banco");
				
			}

			logger.info("transação comitada no banco");
			em.getTransaction().commit();

		} catch (Exception e) {
			logger.error("Falha ao salvar/editar agencia: " + e.getMessage());
			em.getTransaction().rollback();
		} finally {

			em.close();

		}

		return agencia;
	}
	
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


	public boolean deleta(Integer id) {

		EntityManager em = new ConnectionFactory().getConection();
		Agencia agencia = null;

		try {

			agencia = em.find(Agencia.class, id);
			logger.info("Iniciando transação para deletar agencia do banco");
			em.getTransaction().begin();
			em.remove(agencia);
			em.getTransaction().commit();
			logger.info("agencia deletado, transação commitada no banco");

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
