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

import br.com.emerson.locauto.model.Agencia;
import br.com.emerson.locauto.model.Gerente;
import br.com.emerson.locauto.model.Locacao;
import br.com.emerson.locauto.model.Locador;
import br.com.emerson.locauto.service.AgenciaService;
import br.com.emerson.locauto.service.FuncionarioService;
import br.com.emerson.locauto.service.LocacaoService;

/**
 * @author Emerson Sousa
 * 
 *         Esta classe � um controller na aplica��o.
 */

@Controller
public class FuncionarioController {

	@Autowired
	FuncionarioService funcionarioService;

	@Autowired
	AgenciaService agenciaService;

	@Autowired
	LocacaoService locacaoService;

	/**
	 * Esse m�todo trata a requisi��o "/funcionarioG, adiciona um objeto
	 * funcionarioPF na view e por fim retorna a view "gerente"
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("/funcionarioG")
	public String funcionarioG(Map<String, Object> map) {

		map.put("funcionarioG", new Gerente());

		return "gerente";
	}

	/**
	 * Esse m�todo trata a requisi��o "/salvafuncionarioG" monta o objeto
	 * funcionarioG, vindo da view e salva no banco.
	 * 
	 * @param gerente
	 * @param result
	 * @return
	 */
	@RequestMapping(value = { "/salvaFuncionarioG",
			"editarFuncionarioG/salvaFuncionarioG" }, method = RequestMethod.POST)
	public ModelAndView addFuncionarioG(@ModelAttribute("funcionarioG") Gerente gerente, BindingResult result) {

		funcionarioService.salvar(gerente);
		ModelAndView view = new ModelAndView();
		view.setViewName("sucessoSalvar");
		view.addObject("alertTitulo", "Sucesso ao salvar Gerente");
		view.addObject("alertCorpo", "Voc� ser� direcionado para: Funcion�rios");
		view.addObject("location", "/LocAuto/exibeFuncionarios");
		
		return view;
	}

	/**
	 * Esse m�todo trata a requisi��o "/funcionarioL, adiciona um objeto
	 * funcionarioL na view e por fim retorna a view "locador"
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("/funcionarioL")
	public String funcionarioL(Map<String, Object> map) {

		map.put("funcionarioL", new Locador());

		return "locador";
	}

	/**
	 * Esse m�todo trata a requisi��o "/salvaFuncionarioL" monta o objeto
	 * funcionarioL, vindo da view e salva no banco.
	 * 
	 * @param locador
	 * @param result
	 * @return
	 */
	@RequestMapping(value = { "/salvaFuncionarioL",
			"editarFuncionarioL/salvaFuncionarioL" }, method = RequestMethod.POST)
	public ModelAndView addFuncionarioL(@ModelAttribute("funcionarioL") Locador locador, BindingResult result) {

		funcionarioService.salvar(locador);

		ModelAndView view = new ModelAndView();
		view.setViewName("sucessoSalvar");
		view.addObject("alertTitulo", "Sucesso ao salvar Locador");
		view.addObject("alertCorpo", "Voc� ser� direcionado para: Funcion�rios");
		view.addObject("location", "/LocAuto/exibeFuncionarios");
		
		return view;
	}

	/**
	 * Esse m�todo trata a requisi��o "/delete/{funcionarioId}" recebe o id de um
	 * funcionario e deleta do banco
	 * 
	 * @param funcionarioId
	 * @return
	 */
	@RequestMapping("/deleteFuncionario/{funcionarioId}")
	public ModelAndView deleteFuncionario(@PathVariable("funcionarioId") Integer funcionarioId) {

		ModelAndView view = new ModelAndView();
		List<Agencia> agencias = agenciaService.buscaTodos();
		List<Locacao> locacoes = locacaoService.buscaTodos();

		String tipoFuncionario = funcionarioService.buscaPorId(funcionarioId).getTipo();

		if (tipoFuncionario.equals("G")) {  //verificando se o funcion�rio � um gerente
			/*
			 * verificando se existe uma Agencia, se n�o existir permite a dele��o po�s o 
			 * gerente n�o responsav�l por uma ag�ncia
			 */
			if (!agencias.isEmpty()) {		

				/*
				 * verificando se o Gerente � responsav�l por alguma Ag�ncia, caso seja n�o ser� poss�vel deletalo
				 */
				for (Agencia agencia : agencias) {
					Integer idGerenteResponsalvel = agencia.getGerenteResponsavel().getId();
					if (idGerenteResponsalvel.equals(funcionarioId)) {
						view.setViewName("falhaDeletar");
						view.addObject("alertTitulo", "Falha ao deletar Gerente");
						view.addObject("alertCorpo", "N�o foi poss�vel deletar este gerente, ele � responsav�l por uma"
								+ " agencia, desvincule este gerente da agencia para poder deletalo");
						view.addObject("location", "/LocAuto/exibeFuncionarios");
					} else {
						funcionarioService.deleta(funcionarioId);
						view.setViewName("sucessoDeletar");
						view.addObject("alertTitulo", "Sucessso ao deletar Gerente");
						view.addObject("alertCorpo", "O Gerente foi deletado com sucesso da base de dados");
						view.addObject("location", "/LocAuto/exibeFuncionarios");

					}
				}
			} else {
				funcionarioService.deleta(funcionarioId);
				view.setViewName("sucessoDeletar");
				view.addObject("alertTitulo", "Sucessso ao deletar Gerente");
				view.addObject("alertCorpo", "O Gerente foi deletado com sucesso da base de dados");
				view.addObject("location", "/LocAuto/exibeFuncionarios");
			}
		} else {
			/*
			 * se o funcion�rio n�o � um gerente, � um locador, em seguida � verificado se ele est� associado a alguma locacao
			 * caso esteja n�o � permitida a dele��o.
			 */
			if(!locacoes.isEmpty()) {
			for (Locacao locacao : locacaoService.buscaTodos()) {
				Integer idLocadorLocacao = locacao.getLocador().getId();
				if (idLocadorLocacao.equals(funcionarioId)) {

					view.setViewName("falhaDeletar");
					view.addObject("alertTitulo", "Falha ao deletar Locador");
					view.addObject("alertCorpo",
							"N�o foi poss�vel deletar este Locador, ele est� associado a uma loca��o");
					view.addObject("location", "/LocAuto/exibeFuncionarios");
				} else {

					funcionarioService.deleta(funcionarioId);
					view.setViewName("sucessoDeletar");
					view.addObject("alertTitulo", "Sucessso ao deletar Locador");
					view.addObject("alertCorpo", "O Locador foi deletado com sucesso da base de dados");
					view.addObject("location", "/LocAuto/exibeFuncionarios");
				}
			}
		}else {
			
		
			funcionarioService.deleta(funcionarioId);
			view.setViewName("sucessoDeletar");
			view.addObject("alertTitulo", "Sucessso ao deletar Locador");
			view.addObject("alertCorpo", "O Locador foi deletado com sucesso da base de dados");
			view.addObject("location", "/LocAuto/exibeFuncionarios");
		}
			}

		return view;
	}

	/**
	 * Esse m�todo trata a requisi��o "/editarFuncionarioG/{funcionarioId}" recebe o
	 * id de uma funcionario do tipo gerente e carrega o funcionario do banco e
	 * envia o objeto para view para ser editado.
	 * 
	 * @param clienteId
	 * @return
	 */
	@RequestMapping(value = "/editarFuncionarioG/{funcionarioId}")
	public ModelAndView editFuncionarioPF(Map<String, Object> map,
			@PathVariable("funcionarioId") Integer funcionarioId) {

		ModelAndView view = new ModelAndView();
		view.setViewName("gerente");
		view.addObject("funcionarioG", funcionarioService.buscaPorId(funcionarioId));

		return view;
	}

	/**
	 * Esse m�todo trata a requisi��o "/editarFuncionarioG/{funcionarioId}" recebe o
	 * id de uma funcionario do tipo locador e carrega o funcionario do banco e
	 * envia o objeto para view para ser editado.
	 * 
	 * @param clienteId
	 * @return
	 */
	@RequestMapping(value = "/editarFuncionarioL/{funcionarioId}")
	public ModelAndView editFuncionarioPJ(Map<String, Object> map,
			@PathVariable("funcionarioId") Integer funcionarioId) {

		ModelAndView view = new ModelAndView();
		view.setViewName("locador");
		view.addObject("funcionarioL", funcionarioService.buscaPorId(funcionarioId));

		return view;
	}

	/**
	 * Esse m�todo trata a requisi��o "/exibefuncionarios" envia para view
	 * "exibefuncionarios" um lista de funcionariosG e uma lista de funcionariosL
	 * para ser exibido para o usu�rio
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("/exibeFuncionarios")
	public String exibeFuncionarios(Map<String, Object> map) {

		map.put("listaFuncionariosG", funcionarioService.buscaPorTipo("G"));
		map.put("listaFuncionariosL", funcionarioService.buscaPorTipo("L"));

		return "exibeFuncionarios";
	}

}
