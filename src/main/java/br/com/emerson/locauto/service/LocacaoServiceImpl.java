package br.com.emerson.locauto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.emerson.locauto.dao.LocacaoDAO;
import br.com.emerson.locauto.model.LocacaoClientePF;

@Service
public class LocacaoServiceImpl implements LocacaoService {

	@Autowired
	private LocacaoDAO dao;

	@Transactional
	public LocacaoClientePF salvar(LocacaoClientePF locacao) {

		return dao.salvar(locacao);
	}

	@Transactional
	public LocacaoClientePF buscaPorId(Integer id) {

		return dao.buscaPorId(id);
	}

	@Transactional
	public List<LocacaoClientePF> buscaTodos() {

		return dao.buscaTodos();
	}

	@Transactional
	public boolean deleta(Integer id) {
		Boolean result = dao.deleta(id);
		return result;
	}

}
