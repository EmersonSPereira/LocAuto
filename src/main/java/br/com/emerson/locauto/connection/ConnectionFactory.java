package br.com.emerson.locauto.connection;
/**
 * @author Emerson Sousa
 * 
 * Esta classe gerencia as conexões ao banco de dados.
 */
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("locadoraPU");
	
	/**
	 * Retorna uma coneção com o banco de dados
	 * @return
	 */
	public EntityManager getConection() {
		
		return emf.createEntityManager();
	}

}
