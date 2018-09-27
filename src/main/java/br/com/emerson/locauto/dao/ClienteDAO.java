package br.com.emerson.locauto.dao;

import java.util.List;

import br.com.emerson.locauto.model.Cliente;

public interface ClienteDAO {
	
	public Cliente salvar(Cliente cliente);
	public Cliente buscaPorId(Integer id);
	public List<Cliente> buscaTodos();
	public List<Cliente> buscaPorTipo(String tipo);
	public boolean deleta(Integer id);

}
