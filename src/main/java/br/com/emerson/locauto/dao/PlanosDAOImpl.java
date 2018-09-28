package br.com.emerson.locauto.dao;


import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.emerson.locauto.model.Planos;
/**
 * @author Emerson Sousa
 * 
 * Esta classe faz o gerenciamento (CRUD) da classe Planos no banco de dados
 */

@Repository
public class PlanosDAOImpl implements PlanosDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private final Logger logger = LoggerFactory.getLogger(PlanosDAOImpl.class);

	/**
	 * Salva um Plano no banco de dados caso a mesmo nãoo exista, se já existe faz
	 * um upload do Plano no banco.
	 * 
	 * @param planos
	 * @return
	 */
	public Planos salvar(Planos plano) {

		logger.info("Iniciando transação para salvar/editar registro da plano");

		try {

			sessionFactory.getCurrentSession().saveOrUpdate(plano);

			logger.info("plano salvo com sucesso");

		} catch (Exception e) {

			logger.error("Falha ao salvar plano: " + e.getMessage());
		}

		return plano;
	}

	/**
	 * Busca o plano no banco de dados pelo o id passado como parï¿½metro e retorna
	 * o plano encontrado.
	 * 
	 * @param id
	 * @return
	 */
	public Planos buscaPorId(Integer id) {

		Planos plano = null;

		logger.info("Iniciando transação para buscar registro da plano por id");

		try {

			plano = sessionFactory.getCurrentSession().find(Planos.class, id);

			logger.info("plano encontrada com sucesso");

		} catch (Exception e) {

			logger.error("Falha ao buscar plano: " + e.getMessage());
		}

		return plano;
	}

	/**
	 * Recupera uma lista de todos os planos armazenados no banco.
	 * 
	 * @return
	 */
	public List<Planos> buscaTodos() {

		List<Planos> planos = null;

		logger.info("Iniciando transação para buscar todas as planos no banco");

		try {

			planos = sessionFactory.getCurrentSession().createQuery("from Planos", Planos.class).list();

			logger.info("planos encontrada com sucesso");

		} catch (Exception e) {

			logger.error("Falha ao buscar planos: " + e.getMessage());
		}

		return planos;
	}

	/**
	 * Recupera os Funcionários pelo tipo passado pelo parametro podendo ser PC para
	 * planos de carros ou PM para planos de motocicletas
	 * 
	 * @param tipo
	 * @return
	 */
	public List<Planos> buscaPorTipo(String tipo) {

		List<Planos> planos = null;

		logger.info("Iniciando transação para buscar planos por tipo no banco");

		try {

			planos = sessionFactory.getCurrentSession()
					.createQuery("select c from Planos c where c.tipo = :tipo", Planos.class).setParameter("tipo", tipo)
					.getResultList();

			logger.info("planos encontrado com sucesso");

		} catch (Exception e) {

			logger.error("Falha ao buscar planos do tipo = " + tipo + "erro: " + e.getMessage());
		}

		return planos;
	}

	/**
	 * Deleta do banco de dados o funcionário com id passado como parâmetro.
	 * 
	 * @param id
	 * @return
	 */
	public boolean deleta(Integer id) {

		Planos plano = null;

		logger.info("Iniciando transação para deletar plano no banco");

		try {

			plano = sessionFactory.getCurrentSession().find(Planos.class, id);

			if (plano != null) {

				sessionFactory.getCurrentSession().delete(plano);

				logger.info("sucesso ao deletar plano");

				return true;
			} else {

				logger.error("Falha ao deletar plano com id = " + id + " não existe");

			}

		} catch (Exception e) {

			logger.error("Falha ao deletar plano" + "erro:" + e.getMessage());
		}
		
		return false;

	}
}
