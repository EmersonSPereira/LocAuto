package br.com.emerson.locauto.dao;

import java.util.List;

import br.com.emerson.locauto.model.Planos;

public interface PlanosDAO {
	
	public Planos salvar(Planos plano);
	public Planos buscaPorId(Integer id);
	public List<Planos> buscaTodos();
	public List<Planos> buscaPorTipo(String tipo);
	public boolean deleta(Integer id);

}
