package br.com.emerson.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.emerson.locauto.model.Cliente;
import br.com.emerson.locauto.model.ClientePF;
import br.com.emerson.locauto.service.ClienteService;

@Controller
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@RequestMapping("/clientePF")
	public String clientePF(Map<String, Object> map) {

		map.put("cliente", new ClientePF());

		return "clientePF";
	}

	@RequestMapping(value = "/salvaCliente", method = RequestMethod.POST)
	public String addCliente(@ModelAttribute("cliente") ClientePF clientePF, BindingResult result) {

		clienteService.salvar(clientePF);

		return "redirect:/exibeClientes";
	}

	@RequestMapping("/deleteCliente/{clienteId}")
	public String deleteContact(@PathVariable("clienteId") Integer clienteId) {

		clienteService.deleta(clienteId);
		
		return "redirect:/exibeClientes";
	}
	
	@RequestMapping("/exibeClientes")
	public String exibeAgencias(Map<String, Object> map) {
		
		map.put("listaclientes", clienteService.buscaTodos());
		
		return "exibeClientes";
	}

}
