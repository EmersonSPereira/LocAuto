package br.com.emerson.locauto.dao;

/**
 * @author Emerson Sousa
 * 
 * Esta classe faz o gerenciamento (CRUD) da classe Funcionï¿½rio no banco de dados
 */
import java.util.List;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import br.com.emerson.locauto.model.Funcionario;

@Repository
public class FuncionarioDAOImpl implements FuncionarioDAO{

	// private final Logger logger = LoggerFactory.getLogger(FuncionarioDAO.class);
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Salva um Funcionario no banco de dados caso a mesmo nï¿½o exista, se jï¿½ existe
	 * faz um upload do Funcionario no banco.
	 * 
	 * @param funcionario
	 * @return
	 */
	public Funcionario salvar(Funcionario funcionario) {

		sessionFactory.getCurrentSession().saveOrUpdate(funcionario);
		return funcionario;

	}

	/**
	 * Busca o funcionï¿½rio no banco de dados pelo o id passado como parï¿½metro e
	 * retorna o funcionï¿½rio encontrado.
	 * 
	 * @param id
	 * @return
	 */
	public Funcionario buscaPorId(Integer id) {

		Funcionario funcionario = null;

		funcionario = sessionFactory.getCurrentSession().find(Funcionario.class, id);

		return funcionario;
	}

	/**
	 * Recupera uma lista de todos os funcionï¿½rios armazenados no banco.
	 * 
	 * @return
	 */

	public List<Funcionario> buscaTodos() {

		List<Funcionario> funcionarios = null;

		funcionarios = sessionFactory.getCurrentSession().createQuery("from Funcionario", Funcionario.class).list();

		return funcionarios;
	}
	
	/**
	 * Recupera os Funcionários pelo tipo passado pelo parametro podendo ser G para gerente ou L para locador
	 * @param tipo
	 * @return
	 */
	public List<Funcionario> buscaPorTipo(String tipo) {

		List<Funcionario> funcionarios = null;

		funcionarios = sessionFactory.getCurrentSession().createQuery("select c from Funcionario c where c.tipo = :tipo", Funcionario.class).setParameter("tipo", tipo).getResultList();

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

		funcionario = sessionFactory.getCurrentSession().find(Funcionario.class, id);

		if (funcionario != null) {

			sessionFactory.getCurrentSession().delete(funcionario);

			return true;
		} else {

			return false;
		}

	}
}
