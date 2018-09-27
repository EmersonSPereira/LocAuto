package br.com.emerson.locauto.dao;

import java.util.List;

import br.com.emerson.locauto.model.Funcionario;

public interface FuncionarioDAO {
	
	public Funcionario salvar(Funcionario funcionario);
	public Funcionario buscaPorId(Integer id);
	public List<Funcionario> buscaTodos();
	public List<Funcionario> buscaPorTipo(String tipo);
	public boolean deleta(Integer id);

}
