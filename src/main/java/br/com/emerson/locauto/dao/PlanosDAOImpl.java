package br.com.emerson.locauto.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.emerson.locauto.model.Planos;

@Repository
public class PlanosDAOImpl implements PlanosDAO {

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Salva um Plano no banco de dados caso a mesmo nãoo exista, se já existe faz
	 * um upload do Plano no banco.
	 * 
	 * @param planos
	 * @return
	 */
	public Planos salvar(Planos plano) {

		sessionFactory.getCurrentSession().saveOrUpdate(plano);
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

		plano = sessionFactory.getCurrentSession().find(Planos.class, id);

		return plano;
	}

	/**
	 * Recupera uma lista de todos os planos armazenados no banco.
	 * 
	 * @return
	 */
	public List<Planos> buscaTodos() {

		List<Planos> planos = null;

		planos = sessionFactory.getCurrentSession().createQuery("from Planos", Planos.class).list();

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

		planos = sessionFactory.getCurrentSession()
				.createQuery("select c from Planos c where c.tipo = :tipo", Planos.class).setParameter("tipo", tipo)
				.getResultList();

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

		plano = sessionFactory.getCurrentSession().find(Planos.class, id);

		if (plano != null) {

			sessionFactory.getCurrentSession().delete(plano);

			return true;
		} else {

			return false;
		}

	}
}
