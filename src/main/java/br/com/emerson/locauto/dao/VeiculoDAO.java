package br.com.emerson.locauto.dao;

import java.util.List;

import br.com.emerson.locauto.model.Veiculo;

public interface VeiculoDAO {

	public Veiculo salvar(Veiculo veiculo);
	public Veiculo buscaPorId(Integer id);
	public List<Veiculo> buscaTodos();
	public List<Veiculo> buscaPorTipo(String tipo);
	public boolean deleta(Integer id);
}
