package br.com.emerson.locauto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.emerson.locauto.dao.VeiculoDAO;
import br.com.emerson.locauto.model.Veiculo;

@Service
public class VeiculoServiceImpl implements VeiculoService {
	
	@Autowired
	private VeiculoDAO dao;
	
	@Transactional
	public Veiculo salvar(Veiculo veiculo) {
		
		return dao.salvar(veiculo);
	}
	
	@Transactional
	public Veiculo buscaPorId(Integer id) {
		
		return dao.buscaPorId(id);
	}
	
	@Transactional
	public List<Veiculo> buscaTodos() {

		return dao.buscaTodos();
	}
	
	@Transactional
	public List<Veiculo> buscaPorTipo(String tipo) {

		return dao.buscaPorTipo(tipo);
	}
	
	@Transactional
	public boolean deleta(Integer id) {
		Boolean result = dao.deleta(id);
		return result;
	}

}
