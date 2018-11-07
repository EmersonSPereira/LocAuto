package br.com.emerson.locauto.dao;

import java.util.List;

import br.com.emerson.locauto.model.Locacao;

public interface LocacaoDAO {

	public Locacao salvar(Locacao locacao);
	public Locacao buscaPorId(Integer id);
	public List<Locacao> buscaPorTipoCliente(String clienteTipo);
	public List<Locacao> buscaPorTipoClienteStatus(String clienteTipo, String situacao);
	public List<Locacao> buscaTodos();
	public boolean deleta(Integer id); 
}
