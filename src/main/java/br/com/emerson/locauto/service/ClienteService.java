package br.com.emerson.locauto.service;

import java.util.List;

import br.com.emerson.locauto.model.Cliente;

public interface ClienteService {
	
	public Cliente salvar(Cliente cliente);
	public Cliente buscaPorId(Integer id);
	public List<Cliente> buscaTodos();
	public List<Cliente> buscaPorTipo(String tipo);
	public boolean deleta(Integer id);


}
