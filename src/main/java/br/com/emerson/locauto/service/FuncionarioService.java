package br.com.emerson.locauto.service;

import java.util.List;

import br.com.emerson.locauto.model.Funcionario;

public interface FuncionarioService {
	
	public Funcionario salvar(Funcionario funcionario);
	public Funcionario buscaPorId(Integer id);
	public List<Funcionario> buscaTodos();
	public boolean deleta(Integer id);

}
