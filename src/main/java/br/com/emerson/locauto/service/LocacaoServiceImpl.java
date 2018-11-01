package br.com.emerson.locauto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.emerson.locauto.dao.LocacaoDAO;
import br.com.emerson.locauto.model.Locacao;
import br.com.emerson.locauto.model.LocacaoClientePF;

/**
 * Esta classe é um service, camada responsávél pela utilização do DAOLocacao
 * @author Emerson
 *
 */
@Service
public class LocacaoServiceImpl implements LocacaoService {

	@Autowired
	private LocacaoDAO dao;

	/**
	 * Este método usa DAO para salvar uma locação no banco.
	 */
	@Transactional
	public Locacao salvar(Locacao locacao) {

		return dao.salvar(locacao);
	}

	/**
	 * Este método usa DAO para buscar uma locacao pelo id.
	 */
	@Transactional
	public Locacao buscaPorId(Integer id) {

		return dao.buscaPorId(id);
	}

	/**
	 * Este método usa DAO para buscar todos as locações no banco.
	 */
	@Transactional
	public List<Locacao> buscaTodos() {

		return dao.buscaTodos();
	}

	/**
	 * Este método usa DAO para deletar uma locação pelo id.
	 */
	@Transactional
	public boolean deleta(Integer id) {
		Boolean result = dao.deleta(id);
		return result;
	}

	/**
	 * Este método usa DAO para buscar uma lista de  locações por tipo de cliente.
	 */
	@Transactional
	public List<Locacao> buscaPorTipoCliente(String clienteTipo) {
		
		return dao.buscaPorTipoCliente(clienteTipo);
	}

	/**
	 *  Este método usa DAO para buscar uma lista de  locações por tipo de cliente e Status da locação.
	 */
	@Transactional
	public List<Locacao> buscaPorTipoClienteStatus(String clienteTipo, String situacao) {
		
		return dao.buscaPorTipoClienteStatus(clienteTipo, situacao);
	}

}
