package br.com.emerson.locauto.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.emerson.locauto.model.Cliente;

@Repository
public class ClienteDAOImpl implements ClienteDAO {

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

		sessionFactory.getCurrentSession().saveOrUpdate(cliente);
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

		cliente = sessionFactory.getCurrentSession().find(Cliente.class, id);

		return cliente;

	}

	/**
	 * Recupera uma lista de todos os Clientes armazenados no banco.
	 * 
	 * @return
	 */
	public List<Cliente> buscaTodos() {

		List<Cliente> cliente = null;

		cliente = sessionFactory.getCurrentSession().createQuery("from Cliente").list();

		return cliente;
	}
	
	/**
	 * Recupera os clientes pelo tipo passado pelo parametro podendo ser PF ou PJ
	 * @param tipo
	 * @return
	 */
	public List<Cliente> buscaPorTipo(String tipo) {

		List<Cliente> cliente = null;

		cliente = sessionFactory.getCurrentSession().createQuery("select c from Cliente c where c.tipo = :tipo", Cliente.class).setParameter("tipo", tipo).getResultList();

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

		cliente = sessionFactory.getCurrentSession().find(Cliente.class, id);

		if (cliente != null) {

			sessionFactory.getCurrentSession().delete(cliente);

			return true;
		} else {

			return false;
		}
	}

}
