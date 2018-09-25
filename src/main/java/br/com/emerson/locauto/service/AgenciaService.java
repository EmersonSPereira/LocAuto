package br.com.emerson.locauto.service;

import java.util.List;

import br.com.emerson.locauto.model.Agencia;

public interface AgenciaService {

	public Agencia salvar(Agencia agencia);
	public Agencia buscaPorId(Integer id);
	public List<Agencia> buscaTodos();
	public boolean deleta(Integer id);
}
