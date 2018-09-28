package br.com.emerson.locauto.dao;


import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.emerson.locauto.model.Funcionario;
/**
 * @author Emerson Sousa
 * 
 * Esta classe faz o gerenciamento (CRUD) da classe funcionario no banco de dados
 */
@Repository
public class FuncionarioDAOImpl implements FuncionarioDAO {

	private final Logger logger = LoggerFactory.getLogger(FuncionarioDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Salva um Funcionario no banco de dados caso a mesmo não exista, se já existe
	 * faz um upload do Funcionario no banco.
	 * 
	 * @param funcionario
	 * @return
	 */
	public Funcionario salvar(Funcionario funcionario) {

		logger.info("Iniciando transação para salvar/editar registro da funcionario");

		try {

			sessionFactory.getCurrentSession().saveOrUpdate(funcionario);

			logger.info("funcionario salvo com sucesso");

		} catch (Exception e) {

			logger.error("Falha ao salvar funcionario: " + e.getMessage());
		}

		return funcionario;

	}

	/**
	 * Busca o funcionario no banco de dados pelo o id passado como parâmetro e
	 * retorna o funcionario encontrado.
	 * 
	 * @param id
	 * @return
	 */
	public Funcionario buscaPorId(Integer id) {

		Funcionario funcionario = null;

		logger.info("Iniciando transação para buscar registro da funcionario por id");

		try {

			funcionario = sessionFactory.getCurrentSession().find(Funcionario.class, id);

			logger.info("funcionario encontrada com sucesso");

		} catch (Exception e) {

			logger.error("Falha ao buscar funcionario: " + e.getMessage());
		}

		return funcionario;
	}

	/**
	 * Recupera uma lista de todos os funcionarios armazenados no banco.
	 * 
	 * @return
	 */

	public List<Funcionario> buscaTodos() {

		List<Funcionario> funcionarios = null;

		logger.info("Iniciando transação para buscar todas as funcionarios no banco");

		try {

			funcionarios = sessionFactory.getCurrentSession().createQuery("from Funcionario", Funcionario.class).list();

			logger.info("funcionarios encontrada com sucesso");
		} catch (Exception e) {

			logger.error("Falha ao buscar funcionarios: " + e.getMessage());
		}

		return funcionarios;
	}

	/**
	 * Recupera os Funcionários pelo tipo passado pelo parametro podendo ser G para
	 * gerente ou L para locador
	 * 
	 * @param tipo
	 * @return
	 */
	public List<Funcionario> buscaPorTipo(String tipo) {

		List<Funcionario> funcionarios = null;

		logger.info("Iniciando transação para buscar funcionarios por tipo no banco");

		try {

			funcionarios = sessionFactory.getCurrentSession()
					.createQuery("select c from Funcionario c where c.tipo = :tipo", Funcionario.class)
					.setParameter("tipo", tipo).getResultList();

			logger.info("funcionarios encontrado com sucesso");

		} catch (Exception e) {

			logger.error("Falha ao buscar funcionarios do tipo = " + tipo + "erro: " + e.getMessage());
		}

		return funcionarios;
	}

	/**
	 * Deleta do banco de dados o funcionário com id passado como parâmetro.
	 * 
	 * @param id
	 * @return
	 */
	public boolean deleta(Integer id) {

		Funcionario funcionario = null;

		logger.info("Iniciando transação para deletar funcionario no banco");

		try {

			funcionario = sessionFactory.getCurrentSession().find(Funcionario.class, id);

			if (funcionario != null) {

				sessionFactory.getCurrentSession().delete(funcionario);

				logger.info("sucesso ao deletar funcionario");

				return true;
			} else {

				logger.error("Falha ao deletar funcionario com id = " + id + " não existe");
			}

		} catch (Exception e) {

			logger.error("Falha ao deletar funcionario" + "erro:" + e.getMessage());
		}

		return false;

	}
}
