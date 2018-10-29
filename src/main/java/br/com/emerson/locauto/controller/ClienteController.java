package br.com.emerson.locauto.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.emerson.locauto.model.ClientePF;
import br.com.emerson.locauto.model.ClientePJ;
import br.com.emerson.locauto.model.Locacao;
import br.com.emerson.locauto.model.LocacaoClientePF;
import br.com.emerson.locauto.model.LocacaoClientePJ;
import br.com.emerson.locauto.service.ClienteService;
import br.com.emerson.locauto.service.LocacaoService;

/**
 * @author Emerson Sousa
 * 
 *         Esta classe é um controller na aplicação.
 */
@Controller
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private LocacaoService locacaoService;

	/**
	 * Esse método trata a requisição "/clientePF, adiciona um objeto clientePF na
	 * view "clientePF" e por fim retorna a view "clientePF"
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("/clientePF")
	public String clientePF(Map<String, Object> map) {

		map.put("clientePF", new ClientePF());

		return "clientePF";
	}

	/**
	 * Esse método trata a requisição "/clientePJ, adiciona um objeto clientePJ na
	 * view "clientePJ" e por fim retorna a view "clientePJ"
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("/clientePJ")
	public String clientePJ(Map<String, Object> map) {

		map.put("clientePJ", new ClientePJ());

		return "clientePJ";
	}

	/**
	 * Esse método trata as requisições
	 * "/salvaClientePJ","editarClientePJ/salvaClientePJ" monta o objeto clientePF,
	 * vindo da view e caso o objeto não exista salva no banco se o já existir edita
	 * no banco.
	 * 
	 * @param clientePF
	 * @param result
	 * @return
	 */
	@RequestMapping(value = { "/salvaClientePF", "editarClientePF/salvaClientePF" }, method = RequestMethod.POST)
	public ModelAndView addClientePF(@ModelAttribute("clientePF") ClientePF clientePF, BindingResult result) {

		clienteService.salvar(clientePF);

		ModelAndView view = new ModelAndView();
		view.setViewName("sucessoSalvar");
		view.addObject("alertTitulo", "Sucesso ao salvar Cliente");
		view.addObject("alertCorpo", "Você será direcionado para: Clientes");
		view.addObject("location", "/LocAuto/exibeClientes");
		
		return view;
	}

	/**
	 * Esse método trata as requisições
	 * "/salvaClientePJ","editarClientePJ/salvaClientePJ" monta o objeto clientePJ,
	 * vindo da view e salva no banco caso ainda não exista se existir apenas edita
	 * as informações.
	 * 
	 * @param clientePJ
	 * @param result
	 * @return
	 */
	@RequestMapping(value = { "/salvaClientePJ", "editarClientePJ/salvaClientePJ" }, method = RequestMethod.POST)
	public ModelAndView addClientePJ(@ModelAttribute("cliente") ClientePJ clientePJ, BindingResult result) {

		clienteService.salvar(clientePJ);

		ModelAndView view = new ModelAndView();
		view.setViewName("sucessoSalvar");
		view.addObject("alertTitulo", "Sucesso ao salvar Cliente");
		view.addObject("alertCorpo", "Você será direcionado para: Clientes");
		view.addObject("location", "/LocAuto/exibeClientes");
		
		return view;
	}

	/**
	 * Esse método trata a requisição "/delete/{clienteId}" recebe o id de uma
	 * cliente e deleta do banco
	 * 
	 * @param clienteId
	 * @return
	 */
	@RequestMapping("/deleteCliente/{clienteId}")
	public ModelAndView deleteCliente(@PathVariable("clienteId") Integer clienteId) {

		ModelAndView view = new ModelAndView();
		List<Locacao> locacoes = locacaoService.buscaTodos();
		if (!locacoes.isEmpty()) {
			for (Locacao locacao : locacoes) {
				// declarando Clientes
				LocacaoClientePF lcpf = null;
				LocacaoClientePJ lcpj = null;

				// Inicializando os IDs com valores que não existem no banco
				Integer idLCPF = -1;
				Integer idLCPJ = -2;

				/*
				 * Esse if verificao se a locação é do tipo cliente PF OU PJ em caso de um ou
				 * outro ser verdadeiro preenche o objeto declarado anteriormente recupera seu
				 * id
				 */
				if (locacao.getCliente().equals("PF")) {
					lcpf = (LocacaoClientePF) locacao;
					idLCPF = lcpf.getClientePF().getId();
				} else {
					lcpj = (LocacaoClientePJ) locacao;
					idLCPJ = lcpj.getClientePJ().getId();
				}

				/*
				 * Verificando se o Cliente está associado a alguma locação caso esteja a
				 * deleção não é permitida
				 */
				if (idLCPF.equals(clienteId) || idLCPJ.equals(clienteId)) {

					view.setViewName("falhaDeletar");
					view.addObject("alertTitulo", "Falha ao deletar Cliente");
					view.addObject("alertCorpo",
							"Não foi possível deletar este cliente, o mesmo está associado a uma Locação");
					view.addObject("location", "/LocAuto/exibeClientes");

				} else {

					clienteService.deleta(clienteId);
					view.setViewName("sucessoDeletar");
					view.addObject("alertTitulo", "Sucessso ao deletar Cliente");
					view.addObject("alertCorpo", "O CLiente foi deletado com sucesso da base de dados");
					view.addObject("location", "/LocAuto/exibeClientes");

				}
			}
		} else {
			clienteService.deleta(clienteId);
			view.setViewName("sucessoDeletar");
			view.addObject("alertTitulo", "Sucessso ao deletar Cliente");
			view.addObject("alertCorpo", "O CLiente foi deletado com sucesso da base de dados");
			view.addObject("location", "/LocAuto/exibeClientes");
		}

		return view;
	}

	/**
	 * Esse método trata a requisição "/editarCLientePF/{clienteId}" recebe o id de
	 * uma cliente e carrega o cliente do banco e envia o objeto para view para ser
	 * editado.
	 * 
	 * @param clienteId
	 * @return
	 */
	@RequestMapping(value = "/editarClientePF/{clienteId}")
	public ModelAndView editClientePF(Map<String, Object> map, @PathVariable("clienteId") Integer clienteId) {

		ModelAndView view = new ModelAndView();
		view.setViewName("clientePF");
		view.addObject("clientePF", clienteService.buscaPorId(clienteId));

		return view;
	}

	@RequestMapping(value = "/editarClientePJ/{clienteId}")
	public ModelAndView editClientePJ(Map<String, Object> map, @PathVariable("clienteId") Integer clienteId) {

		ModelAndView view = new ModelAndView();
		view.setViewName("clientePJ");
		view.addObject("clientePJ", clienteService.buscaPorId(clienteId));

		return view;
	}

	/**
	 * Esse método trata a requisição "/exibeclientes" envia para view
	 * "exibeclientes" uma lista de clientesPF e uma lista de clientesPJ para ser
	 * exibido para o usuário
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("/exibeClientes")
	public String exibeClientes(Map<String, Object> map) {

		map.put("listaclientesPF", clienteService.buscaPorTipo("PF"));
		map.put("listaclientesPJ", clienteService.buscaPorTipo("PJ"));

		return "exibeClientes";
	}

}
