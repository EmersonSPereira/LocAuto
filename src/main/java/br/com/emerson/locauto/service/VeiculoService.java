package br.com.emerson.locauto.service;

import java.util.List;

import br.com.emerson.locauto.model.Veiculo;

public interface VeiculoService {
	public Veiculo salvar(Veiculo veiculo);
	public Veiculo buscaPorId(Integer id);
	public List<Veiculo> buscaTodos();
	public boolean deleta(Integer id);

}
