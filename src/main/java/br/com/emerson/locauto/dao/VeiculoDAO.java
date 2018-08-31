package br.com.emerson.locauto.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.emerson.locauto.connection.ConnectionFactory;
import br.com.emerson.locauto.model.Veiculo;

public class VeiculoDAO {
	
	
	private final Logger logger = LoggerFactory.getLogger(VeiculoDAO.class);
	
	
	public Veiculo salvar(Veiculo veiculo) {
		
		EntityManager em  =  new ConnectionFactory().getConection();		
		try {
			
			logger.info("Iniciando conexao para salvar/editar registro do Veiculo");
			em.getTransaction().begin();
			if(veiculo.getId() == null) {
				logger.info("veiculo salvo");
				em.persist(veiculo);
			} else {
				logger.info("veiculo editado");
				em.merge(veiculo);
			}
			
			logger.info("transação comitada no banco");
			em.getTransaction().commit();
		
			
		} catch (Exception e) {
			logger.error("Falha ao salvar/editar Veiculo: " + e.getMessage());
			em.getTransaction().rollback();
		}
		
		return veiculo;
	}
	
	
	public Veiculo buscaPorId(Integer id) {
		
		EntityManager em = new ConnectionFactory().getConection();
		Veiculo veiculo = null;
		
		try {

			logger.info("Realizando busca por id na tabela Veiculos");
			veiculo = em.find(Veiculo.class, id);
			
		} catch (Exception e) {
			logger.error("A busca Falhou: " +  e.getMessage());
		}
		
		logger.info("retornando resultado da busca");
		
		return veiculo;
		
		
	}
	
	public List<Veiculo> buscaTodos(){
		
		EntityManager em = new ConnectionFactory().getConection();
		List<Veiculo> veiculos = null;
		
		try {
			logger.info("Buscando todos os veiculos na tabela");
			veiculos = em.createQuery("FROM Veiculo").getResultList();
		} catch (Exception e){
			
			logger.error("Falha na busca: " + e.getMessage());
		} finally {
			em.close();
		}
		
		return veiculos;
	}
	
	public boolean deleta(Integer id) {
		
		EntityManager em = new ConnectionFactory().getConection();
		Veiculo veiculo = null;
		
		try {
			
			veiculo = em.find(Veiculo.class, id);
			logger.info("Iniciando transação para deletar veiculo do banco");
			em.getTransaction().begin();
			em.remove(veiculo);
			em.getTransaction().commit();
			logger.info("Veiculo deletado, transação commitada no banco");
			
		} catch (Exception e) {
			em.getTransaction().rollback();
			logger.error("Falha ao deletar veiculo: " + e.getMessage());
			return false;
		} finally {
			em.close();
		}
		
		return true;
	}
	
	

}
