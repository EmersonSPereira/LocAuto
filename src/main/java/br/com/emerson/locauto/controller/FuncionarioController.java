package br.com.emerson.locauto.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.emerson.locauto.model.Gerente;
import br.com.emerson.locauto.model.Locador;
import br.com.emerson.locauto.service.FuncionarioService;

/**
 * @author Emerson Sousa
 * 
 * Esta classe é um controller na aplicação.
 */

@Controller
public class FuncionarioController {

	@Autowired
	FuncionarioService funcionarioService;
	
	/**
	 * Esse método trata a requisição "/funcionarioG, adiciona um objeto funcionarioPF na view  e por fim
	 * retorna a view "gerente"
	 * @param map
	 * @return
	 */
	@RequestMapping("/funcionarioG")
	public String funcionarioG(Map<String, Object> map) {

		map.put("funcionarioG", new Gerente());

		return "gerente";
	}
	
	/**
	 * Esse método trata a requisição "/salvafuncionarioG" monta o objeto funcionarioG, vindo da view e salva no banco.
	 * @param gerente
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/salvaFuncionarioG", method = RequestMethod.POST)
	public String addFuncionarioG(@ModelAttribute("funcionarioG") Gerente gerente, BindingResult result) {

		funcionarioService.salvar(gerente);

		return "redirect:/exibeFuncionarios";
	}
	
	/**
	 * Esse método trata a requisição "/funcionarioL, adiciona um objeto funcionarioL na view  e por fim
	 * retorna a view "locador"
	 * @param map
	 * @return
	 */
	@RequestMapping("/funcionarioL")
	public String funcionarioL(Map<String, Object> map) {

		map.put("funcionarioL", new Locador());

		return "locador";
	}

	/**
	 * Esse método trata a requisição "/salvaFuncionarioL" monta o objeto funcionarioL, vindo da view e salva no banco.
	 * @param locador
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/salvaFuncionarioL", method = RequestMethod.POST)
	public String addFuncionarioL(@ModelAttribute("funcionarioL") Locador locador, BindingResult result) {

		funcionarioService.salvar(locador);

		return "redirect:/exibeFuncionarios";
	}
	
	/**
	 * Esse método trata a requisição "/delete/{funcionarioId}" recebe o id de um funcionario e deleta do banco
	 * @param funcionarioId
	 * @return
	 */
	@RequestMapping("/deleteFuncionario/{funcionarioId}")
	public String deleteFuncionario(@PathVariable("funcionarioId") Integer funcionarioId) {

		funcionarioService.deleta(funcionarioId);

		return "redirect:/exibeFuncionarios";
	}

	/**
	 * Esse método trata a requisição "/exibefuncionarios" envia para view "exibefuncionarios" um lista de funcionariosG 
	 * e uma lista de funcionariosL  para ser exibido
	 * para o usuário
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
