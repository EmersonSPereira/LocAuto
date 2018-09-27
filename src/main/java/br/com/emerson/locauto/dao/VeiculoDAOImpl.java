package br.com.emerson.locauto.dao;
/**
 * @author Emerson Sousa
 * 
 * Esta classe faz o gerenciamento (CRUD) da classe Ve�culo no banco de dados
 */

import java.util.List;



import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import br.com.emerson.locauto.model.Veiculo;

@Repository
public class VeiculoDAOImpl implements VeiculoDAO {

	// private final Logger logger = LoggerFactory.getLogger(VeiculoDAO.class);
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Salva um Ve�culo no banco de dados caso a mesmo n�o exista, se j� existe faz
	 * um upload do Ve�culo no banco.
	 * 
	 * @param veiculo
	 * @return
	 */
	public Veiculo salvar(Veiculo veiculo) {

		sessionFactory.getCurrentSession().saveOrUpdate(veiculo);
		return veiculo;

	}

	/**
	 * Busca o Ve�culo no banco de dados pelo o id passado como par�metro e retorna
	 * o Ve�culo encontrado.
	 * 
	 * @param id
	 * @return
	 */
	public Veiculo buscaPorId(Integer id) {

		Veiculo veiculo = null;

		veiculo = sessionFactory.getCurrentSession().find(Veiculo.class, id);

		return veiculo;

	}

	/**
	 * Recupera uma lista de todos os Ve�culos armazenados no banco.
	 * 
	 * @return
	 */
	public List<Veiculo> buscaTodos() {

		List<Veiculo> veiculos = null;

		veiculos = sessionFactory.getCurrentSession().createQuery("from Veiculo").list();

		return veiculos;
	}
	
	/**
	 * Recupera os veiculos pelo tipo passado pelo parametro podendo ser C para carrto ou M para motocicleta
	 * @param tipo
	 * @return
	 */
	public List<Veiculo> buscaPorTipo(String tipo) {

		List<Veiculo> veiculos = null;

		veiculos = sessionFactory.getCurrentSession().createQuery("select c from Veiculo c where c.tipo = :tipo", Veiculo.class).setParameter("tipo", tipo).getResultList();

		return veiculos;
	}

	/**
	 * Deleta do banco de dados o Ve�culo com id passado como par�metro.
	 * 
	 * @param id
	 * @return
	 */
	public boolean deleta(Integer id) {

		Veiculo veiculo = null;

		veiculo = sessionFactory.getCurrentSession().find(Veiculo.class, id);

		if (veiculo != null) {

			sessionFactory.getCurrentSession().delete(veiculo);

			return true;
		} else {

			return false;
		}

	}

}
