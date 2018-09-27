package br.com.emerson.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.emerson.locauto.model.ClientePF;
import br.com.emerson.locauto.model.Gerente;
import br.com.emerson.locauto.model.Locador;
import br.com.emerson.locauto.service.FuncionarioService;

@Controller
public class FuncionarioController {

	@Autowired
	FuncionarioService funcionarioService;

	@RequestMapping("/funcionarioG")
	public String clientePF(Map<String, Object> map) {

		map.put("funcionarioG", new Gerente());

		return "gerente";
	}

	@RequestMapping(value = "/salvaFuncionarioG", method = RequestMethod.POST)
	public String addFuncionarioG(@ModelAttribute("funcionarioG") Gerente gerente, BindingResult result) {

		funcionarioService.salvar(gerente);

		return "redirect:/exibeFuncionarios";
	}

	@RequestMapping("/funcionarioL")
	public String clientePJ(Map<String, Object> map) {

		map.put("funcionarioL", new Locador());

		return "locador";
	}

	@RequestMapping(value = "/salvaFuncionarioL", method = RequestMethod.POST)
	public String addFuncionarioL(@ModelAttribute("funcionarioL") Locador locador, BindingResult result) {

		funcionarioService.salvar(locador);

		return "redirect:/exibeFuncionarios";
	}

	@RequestMapping("/deleteFuncionario/{funcionarioId}")
	public String deleteContact(@PathVariable("funcionarioId") Integer funcionarioId) {

		funcionarioService.deleta(funcionarioId);

		return "redirect:/exibeFuncionarios";
	}

	@RequestMapping("/exibeFuncionarios")
	public String exibeAgencias(Map<String, Object> map) {

		map.put("listaFuncionariosG", funcionarioService.buscaPorTipo("G"));
		map.put("listaFuncionariosL", funcionarioService.buscaPorTipo("L"));

		return "exibeFuncionarios";
	}

}
