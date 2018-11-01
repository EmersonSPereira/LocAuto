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
	
	/**
	 * Este método usa DAO para salvar um funcionário no banco
	 */
	@Transactional
	public Funcionario salvar(Funcionario funcionario) {
		
		return dao.salvar(funcionario);
	}
	
	/**
	 * Este método usa DAO para buscar um funcionário por id.
	 */
	@Transactional
	public Funcionario buscaPorId(Integer id) {
		
		return dao.buscaPorId(id);
	}
	
	/**
	 * Este método usa DAO para buscar todos os funcionarios do banco.
	 */
	@Transactional
	public List<Funcionario> buscaTodos() {

		return dao.buscaTodos();
	}
	
	/**
	 * Este método usa DAO para buscar uma lista de clientes por tipo.
	 */
	@Transactional
	public List<Funcionario> buscaPorTipo(String tipo) {

		return dao.buscaPorTipo(tipo);
	}
	
	/**
	 * Este método usa DAO para deletar um cliente pelo id.
	 */
	@Transactional
	public boolean deleta(Integer id) {
		Boolean result = dao.deleta(id);
		return result;
	}

}
