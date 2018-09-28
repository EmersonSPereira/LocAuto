package br.com.emerson.locauto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.emerson.locauto.dao.PlanosDAO;
import br.com.emerson.locauto.model.Planos;
import br.com.emerson.locauto.model.Planos;

@Service
public class PlanosServiceImpl implements PlanosService {

	@Autowired
	private PlanosDAO dao;

	@Transactional
	public Planos salvar(Planos plano) {

		return dao.salvar(plano);
	}

	@Transactional
	public Planos buscaPorId(Integer id) {

		return dao.buscaPorId(id);
	}

	@Transactional
	public List<Planos> buscaTodos() {

		return dao.buscaTodos();
	}

	@Transactional
	public List<Planos> buscaPorTipo(String tipo) {

		return dao.buscaPorTipo(tipo);
	}

	@Transactional
	public boolean deleta(Integer id) {
		Boolean result = dao.deleta(id);
		return result;
	}

}
