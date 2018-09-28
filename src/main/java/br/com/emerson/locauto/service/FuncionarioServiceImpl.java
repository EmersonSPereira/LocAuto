package br.com.emerson.locauto.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.emerson.locauto.dao.FuncionarioDAO;
import br.com.emerson.locauto.model.Funcionario;

/**
 * @author Emerson Sousa
 * 
 * Esta classe é um service, camada responsávél pela utilização do DAOFuncionario
 */


@Service
public class FuncionarioServiceImpl implements FuncionarioService{
	
	@Autowired
	private FuncionarioDAO dao;
	
	@Transactional
	public Funcionario salvar(Funcionario funcionario) {
		
		return dao.salvar(funcionario);
	}
	
	@Transactional
	public Funcionario buscaPorId(Integer id) {
		
		return dao.buscaPorId(id);
	}
	
	@Transactional
	public List<Funcionario> buscaTodos() {

		return dao.buscaTodos();
	}
	
	@Transactional
	public List<Funcionario> buscaPorTipo(String tipo) {

		return dao.buscaPorTipo(tipo);
	}
	
	@Transactional
	public boolean deleta(Integer id) {
		Boolean result = dao.deleta(id);
		return result;
	}

}
