package br.com.emerson.locauto.dao;


import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.emerson.locauto.model.Veiculo;
/**
 * @author Emerson Sousa
 * 
 * Esta classe faz o gerenciamento (CRUD) da classe veículo no banco de dados
 */
@Repository
public class VeiculoDAOImpl implements VeiculoDAO {

	private final Logger logger = LoggerFactory.getLogger(VeiculoDAO.class);
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Salva um veículo no banco de dados caso a mesmo não exista, se já existe faz
	 * um upload do veículo no banco.
	 * 
	 * @param veiculo
	 * @return
	 */
	public Veiculo salvar(Veiculo veiculo) {

		logger.info("Iniciando transação para salvar/editar registro da veiculo");

		try {

			sessionFactory.getCurrentSession().saveOrUpdate(veiculo);

			logger.info("veiculo salvo com sucesso");

		} catch (Exception e) {

			logger.error("Falha ao salvar veiculo: " + e.getMessage());
		}

		return veiculo;

	}

	/**
	 * Busca o veículo no banco de dados pelo o id passado como parâmetro e retorna
	 * o veículo encontrado.
	 * 
	 * @param id
	 * @return
	 */
	public Veiculo buscaPorId(Integer id) {

		Veiculo veiculo = null;

		logger.info("Iniciando transação para buscar registro da veiculo por id");

		try {

			veiculo = sessionFactory.getCurrentSession().find(Veiculo.class, id);

			logger.info("veiculo encontrada com sucesso");

		} catch (Exception e) {

			logger.error("Falha ao buscar veiculo: " + e.getMessage());
		}

		veiculo = sessionFactory.getCurrentSession().find(Veiculo.class, id);

		return veiculo;

	}

	/**
	 * Recupera uma lista de todos os veículos armazenados no banco.
	 * 
	 * @return
	 */
	public List<Veiculo> buscaTodos() {

		List<Veiculo> veiculos = null;

		logger.info("Iniciando transação para buscar todas as veiculos no banco");

		try {

			veiculos = sessionFactory.getCurrentSession().createQuery("from Veiculo", Veiculo.class).list();

			logger.info("veiculos encontrada com sucesso");

		} catch (Exception e) {

			logger.error("Falha ao buscar veiculos: " + e.getMessage());
		}

		return veiculos;
	}

	/**
	 * Recupera os veiculos pelo tipo passado pelo parametro podendo ser C para
	 * carrto ou M para motocicleta
	 * 
	 * @param tipo
	 * @return
	 */
	public List<Veiculo> buscaPorTipo(String tipo) {

		List<Veiculo> veiculos = null;

		logger.info("Iniciando transação para buscar veiculos por tipo no banco");

		try {

			veiculos = sessionFactory.getCurrentSession()
					.createQuery("select c from Veiculo c where c.tipo = :tipo", Veiculo.class)
					.setParameter("tipo", tipo).getResultList();

			logger.info("veiculos encontrado com sucesso");

		} catch (Exception e) {

			logger.error("Falha ao buscar veiculos do tipo = " + tipo + "erro: " + e.getMessage());
		}

		veiculos = sessionFactory.getCurrentSession()
				.createQuery("select c from Veiculo c where c.tipo = :tipo", Veiculo.class).setParameter("tipo", tipo)
				.getResultList();

		return veiculos;
	}

	/**
	 * Deleta do banco de dados o veículo com id passado como parâmetro.
	 * 
	 * @param id
	 * @return
	 */
	public boolean deleta(Integer id) {

		Veiculo veiculo = null;

		logger.info("Iniciando transação para deletar veiculo no banco");

		try {

			veiculo = sessionFactory.getCurrentSession().find(Veiculo.class, id);

			if (veiculo != null) {

				sessionFactory.getCurrentSession().delete(veiculo);
				logger.info("sucesso ao deletar veiculo");

				return true;
			} else {

				logger.error("Falha ao deletar veiculo com id = " + id + " não existe");
			}

		} catch (Exception e) {

			logger.error("Falha ao deletar veiculo" + "erro:" + e.getMessage());
		}

		return false;

	}

}
