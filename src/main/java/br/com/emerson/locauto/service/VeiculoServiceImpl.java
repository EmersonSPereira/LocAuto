package br.com.emerson.locauto.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.emerson.locauto.dao.VeiculoDAO;
import br.com.emerson.locauto.model.Veiculo;
/**
 * @author Emerson Sousa
 * 
 * Esta classe é um service, camada responsávél pela utilização do DAOVeiculo
 */

@Service
public class VeiculoServiceImpl implements VeiculoService {
	
	@Autowired
	private VeiculoDAO dao;
	
	/**
	 *  Este método usa DAO para salvar umveículo no banco.
	 */
	@Transactional
	public Veiculo salvar(Veiculo veiculo) {
		
		return dao.salvar(veiculo);
	}
	
	/**
	 *  Este método usa DAO para buscar um veículo pelo id.
	 */
	@Transactional
	public Veiculo buscaPorId(Integer id) {
		
		return dao.buscaPorId(id);
	}
	
	/**
	 *  Este método usa DAO para buscar todos os veículos.
	 */
	@Transactional
	public List<Veiculo> buscaTodos() {

		return dao.buscaTodos();
	}
	
	/**
	 *  Este método usa DAO para buscar um veículo por tipo
	 */
	@Transactional
	public List<Veiculo> buscaPorTipo(String tipo) {

		return dao.buscaPorTipo(tipo);
	}
	
	/**
	 *  Este método usa DAO para deletar um veículo pelo id.
	 */
	@Transactional
	public boolean deleta(Integer id) {
		Boolean result = dao.deleta(id);
		return result;
	}

}
