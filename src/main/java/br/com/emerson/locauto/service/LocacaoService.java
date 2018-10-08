package br.com.emerson.locauto.service;

import java.util.List;

import br.com.emerson.locauto.model.LocacaoClientePF;

public interface LocacaoService {
	
	
	public LocacaoClientePF salvar(LocacaoClientePF locacao);
	public LocacaoClientePF buscaPorId(Integer id);
	public List<LocacaoClientePF> buscaTodos();
	public boolean deleta(Integer id); 

}
