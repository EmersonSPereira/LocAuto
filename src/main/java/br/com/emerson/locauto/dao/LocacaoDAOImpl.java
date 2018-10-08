package br.com.emerson.locauto.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.emerson.locauto.model.LocacaoClientePF;

@Repository
public class LocacaoDAOImpl implements LocacaoDAO {

private final Logger logger = LoggerFactory.getLogger(LocacaoDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Salva uma Locacao no banco de dados caso a mesma n�o exista, se j� existe faz
	 * um upload da ag�ncia no banco.
	 * 
	 * @param LocacaoClientePF
	 * @return
	 */
	public LocacaoClientePF salvar(LocacaoClientePF locacao) {

		logger.info("Iniciando transa��o para salvar/editar registro da Locacao");
		try {
			
			sessionFactory.getCurrentSession().saveOrUpdate(locacao);
			
			logger.info("Locacao salva com sucesso");
			
		} catch (Exception e) {
			
			logger.error("Falha ao salvar Locacao: " + e.getMessage() );
		}
		
		
		return locacao;
//		
	}

	/**
	 * Busca  a ag�ncia no banco de dados pelo o id passado como par�metro e retorna a ag�ncia encontrada.
	 * @param id
	 * @return
	 */
	public LocacaoClientePF buscaPorId(Integer id) {

		LocacaoClientePF locacao = null;
		
		logger.info("Iniciando transa��o para buscar registro da Locacao por id");
		
		try {
			
			locacao  =  sessionFactory.getCurrentSession().find(LocacaoClientePF.class, id);
			
			logger.info("Locacao encontrada com sucesso");
			
		} catch (Exception e) {
			
			logger.error("Falha ao buscar Locacao: " + e.getMessage() );
		}
		
		
		return locacao;
//		

	}

	/**
	 * Recupera uma lista de todas as ag�ncias armazenadas no banco
	 * 
	 * @return
	 */
	public List<LocacaoClientePF> buscaTodos() {

		List<LocacaoClientePF> Locacacoes = null;
		
		logger.info("Iniciando transa��o para buscar todas as Locacaos no banco");
		
		try {
			
			Locacacoes = sessionFactory.getCurrentSession().createQuery("from Locacao", LocacaoClientePF.class).list();
			
			logger.info("Locacaos encontrada com sucesso");
			
		} catch (Exception e) {
			
			logger.error("Falha ao buscar Locacaos: " + e.getMessage() );


		}
		
		
		return Locacacoes;
//		
	}

	/**
	 * Deleta do banco de dados aag�ncias com id passado como par�metro do banco de
	 * dados
	 * 
	 * @param id
	 * @return
	 */
	public boolean deleta(Integer id) {

		LocacaoClientePF locacao = null;
		
		logger.info("Iniciando transa��o para deletar Locacao no banco");
		
		try {
			
			locacao = sessionFactory.getCurrentSession().find(LocacaoClientePF.class, id);
			
			if(locacao != null) {
				
				sessionFactory.getCurrentSession().delete(locacao);
				
				logger.info("sucesso ao deletar Locacao");
				
				return true;
			}else {
				
				logger.error("Falha ao deletar Locacao com id = " + id + " n�o existe");
			}
			
		} catch (Exception e) {
			
			logger.error("Falha ao deletar Locacao" + "erro:" + e.getMessage());
		}
		return false;
		
		
		
		
		
	}


}
