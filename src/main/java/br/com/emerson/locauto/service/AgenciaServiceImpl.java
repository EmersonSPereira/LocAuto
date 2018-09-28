package br.com.emerson.locauto.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.emerson.locauto.dao.AgenciaDAO;
import br.com.emerson.locauto.model.Agencia;
/**
 * @author Emerson Sousa
 * 
 * Esta classe é um service, camada responsávél pela utilização do DAOAgencia 
 */
@Service
public class AgenciaServiceImpl implements AgenciaService {
	
	@Autowired
	private AgenciaDAO dao;
	
	@Transactional
	public Agencia salvar(Agencia agencia) {
		
		return dao.salvar(agencia);
	}
	
	@Transactional
	public Agencia buscaPorId(Integer id) {
		
		return dao.buscaPorId(id);
	}
	
	@Transactional
	public List<Agencia> buscaTodos() {

		return dao.buscaTodos();
	}
	
	@Transactional
	public boolean deleta(Integer id) {
		Boolean result = dao.deleta(id);
		return result;
	}

}
