package br.com.emerson.locauto.dao;
/**
 * @author Emerson Sousa
 * 
 * Esta classe faz o gerenciamento (CRUD) da classe agencia no banco de dados
 */

import java.util.List;


import org.hibernate.SessionFactory;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import br.com.emerson.locauto.model.Agencia;

@Repository
public class AgenciaDAOImpl implements AgenciaDAO {

	//private final Logger logger = LoggerFactory.getLogger(AgenciaDAO.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Salva uma agencia no banco de dados caso a mesma n�o exista, se j� existe faz
	 * um upload da ag�ncia no banco.
	 * 
	 * @param agencia
	 * @return
	 */
	public Agencia salvar(Agencia agencia) {

		//logger.info("Iniciando conexao para salvar/editar registro da agencia");
		
		sessionFactory.getCurrentSession().save(agencia);
		
		return agencia;
//		
	}

	/**
	 * Busca  a ag�ncia no banco de dados pelo o id passado como par�metro e retorna a ag�ncia encontrada.
	 * @param id
	 * @return
	 */
	public Agencia buscaPorId(Integer id) {

		Agencia agencia = null;
		
		agencia  =  sessionFactory.getCurrentSession().find(Agencia.class, id);
		
		return agencia;
//		

	}

	/**
	 * Recupera uma lista de todas as ag�ncias armazenadas no banco
	 * 
	 * @return
	 */
	public List<Agencia> buscaTodos() {

		List<Agencia> agencias = null;
		
		agencias = sessionFactory.getCurrentSession().createQuery("from Agencia").list();
		
		return agencias;
//		
	}

	/**
	 * Deleta do banco de dados a ag�ncia com id passado como par�metro do banco de
	 * dados
	 * 
	 * @param id
	 * @return
	 */
	public boolean deleta(Integer id) {

		Agencia agencia = null;
		
		agencia = sessionFactory.getCurrentSession().load(Agencia.class, id);
		
		if(agencia != null) {
			
			sessionFactory.getCurrentSession().delete(agencia);
			
			return true;
		}else {
			
			return false;
		}
		
	}

}
