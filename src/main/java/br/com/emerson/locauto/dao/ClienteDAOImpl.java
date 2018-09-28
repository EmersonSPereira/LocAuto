package br.com.emerson.locauto.dao;


import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.emerson.locauto.model.Cliente;
/**
 * @author Emerson Sousa
 * 
 * Esta classe faz o gerenciamento (CRUD) da classe CLiente no banco de dados
 */
@Repository
public class ClienteDAOImpl implements ClienteDAO {

	private final Logger logger = LoggerFactory.getLogger(ClienteDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Salva um Cliente no banco de dados caso a mesmo nao exista, se ja existe faz
	 * um upload do Cliente no banco.
	 * 
	 * @param funcionario
	 * @return
	 */
	public Cliente salvar(Cliente cliente) {

		logger.info("Iniciando transação para salvar/editar registro da cliente");
		try {

			sessionFactory.getCurrentSession().saveOrUpdate(cliente);

			logger.info("cliente salvo com sucesso");

		} catch (Exception e) {

			logger.error("Falha ao salvar cliente: " + e.getMessage());
		}

		return cliente;

	}

	/**
	 * Busca o Cliente no banco de dados pelo o id passado como parametro e retorna
	 * o Cliente encontrado.
	 * 
	 * @param id
	 * @return
	 */
	public Cliente buscaPorId(Integer id) {

		Cliente cliente = null;

		logger.info("Iniciando transação para buscar registro da cliente por id");

		try {

			cliente = sessionFactory.getCurrentSession().find(Cliente.class, id);

			logger.info("cliente encontrada com sucesso");

		} catch (Exception e) {

			logger.error("Falha ao buscar cliente: " + e.getMessage());
		}

		return cliente;

	}

	/**
	 * Recupera uma lista de todos os Clientes armazenados no banco.
	 * 
	 * @return
	 */
	public List<Cliente> buscaTodos() {

		List<Cliente> cliente = null;

		logger.info("Iniciando transação para buscar todas as clientes no banco");

		try {

			cliente = sessionFactory.getCurrentSession().createQuery("from Cliente", Cliente.class).list();

			logger.info("clientes encontrada com sucesso");

		} catch (Exception e) {

			logger.error("Falha ao buscar clientes: " + e.getMessage());
		}

		return cliente;
	}

	/**
	 * Recupera os clientes pelo tipo passado pelo parametro podendo ser PF ou PJ
	 * 
	 * @param tipo
	 * @return
	 */
	public List<Cliente> buscaPorTipo(String tipo) {

		List<Cliente> cliente = null;

		logger.info("Iniciando transação para buscar clientes por tipo no banco");

		try {

			cliente = sessionFactory.getCurrentSession()
					.createQuery("select c from Cliente c where c.tipo = :tipo", Cliente.class)
					.setParameter("tipo", tipo).getResultList();

			logger.info("clientes encontrado com sucesso");

		} catch (Exception e) {

			logger.error("Falha ao buscar clientes do tipo = " + tipo + "erro: " + e.getMessage());
		}

		return cliente;
	}

	/**
	 * Deleta do banco de dados o cliente com id passado como parametro.
	 * 
	 * @param id
	 * @return
	 */
	public boolean deleta(Integer id) {

		Cliente cliente = null;

		logger.info("Iniciando transação para deletar cliente no banco");
		try {

			cliente = sessionFactory.getCurrentSession().find(Cliente.class, id);

			if (cliente != null) {

				sessionFactory.getCurrentSession().delete(cliente);
				logger.info("sucesso ao deletar cliente");

				return true;
			} else {
				
				logger.error("Falha ao deletar cliente com id = " + id + " não existe");

			}

		} catch (Exception e) {

			logger.error("Falha ao deletar cliente" + "erro:" + e.getMessage());
		}
		
		return false;

	}

}
