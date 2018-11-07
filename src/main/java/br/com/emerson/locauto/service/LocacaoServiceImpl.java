package br.com.emerson.locauto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.emerson.locauto.dao.LocacaoDAO;
import br.com.emerson.locauto.model.Locacao;
import br.com.emerson.locauto.model.LocacaoClientePF;

@Service
public class LocacaoServiceImpl implements LocacaoService {

	@Autowired
	private LocacaoDAO dao;

	@Transactional
	public Locacao salvar(Locacao locacao) {

		return dao.salvar(locacao);
	}

	@Transactional
	public Locacao buscaPorId(Integer id) {

		return dao.buscaPorId(id);
	}

	@Transactional
	public List<Locacao> buscaTodos() {

		return dao.buscaTodos();
	}

	@Transactional
	public boolean deleta(Integer id) {
		Boolean result = dao.deleta(id);
		return result;
	}

	@Transactional
	public List<Locacao> buscaPorTipoCliente(String clienteTipo) {
		
		return dao.buscaPorTipoCliente(clienteTipo);
	}

	@Transactional
	public List<Locacao> buscaPorTipoClienteStatus(String clienteTipo, String situacao) {
		// TODO Auto-generated method stub
		return dao.buscaPorTipoClienteStatus(clienteTipo, situacao);
	}

}
