package br.com.emerson.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.emerson.locauto.model.Agencia;
import br.com.emerson.locauto.service.AgenciaService;


@Controller
public class AgenciaController {

	@Autowired
	private AgenciaService agenciaService;

	@RequestMapping("/agencia")
	public String listContacts(Map<String, Object> map) {

		map.put("contact", new Agencia());
		

		return "agencia";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addContact(@ModelAttribute("contact") Agencia agencia, BindingResult result) {

		agenciaService.salvar(agencia);

		return "redirect:/exibeAgencias";
	}

	@RequestMapping("/delete/{contactId}")
	public String deleteContact(@PathVariable("contactId") Integer agenciaId) {

		agenciaService.deleta(agenciaId);

		return "redirect:/exibeAgencias";
	}
	
	@RequestMapping("/exibeAgencias")
	public String exibeAgencias(Map<String, Object> map) {
		map.put("contactList", agenciaService.buscaTodos());
		return "exibeAgencias";
	}

}
