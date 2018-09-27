package br.com.emerson.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.emerson.locauto.model.Carro;
import br.com.emerson.locauto.model.Motocicleta;
import br.com.emerson.locauto.service.VeiculoService;

@Controller
public class VeiculoController {

	@Autowired
	private VeiculoService veiculoService;
	
	@RequestMapping("/veiculoC")
	public String clientePF(Map<String, Object> map) {

		map.put("veiculoC", new Carro());

		return "carro";
	}
	
	@RequestMapping(value = "/salvaVeiculoC", method = RequestMethod.POST)
	public String addCarro(@ModelAttribute("veiculoC") Carro carro, BindingResult result) {

		veiculoService.salvar(carro);

		return "redirect:/exibeVeiculos";
	}

	@RequestMapping("/veiculoM")
	public String clientePJ(Map<String, Object> map) {

		map.put("veiculoM", new Motocicleta());

		return "motocicleta";
	}
	
	@RequestMapping(value = "/salvaVeiculoM", method = RequestMethod.POST)
	public String addMotocicleta(@ModelAttribute("veiculoM") Motocicleta moto, BindingResult result) {

		veiculoService.salvar(moto);

		return "redirect:/exibeVeiculos";
	}
	
	@RequestMapping("/deleteVeiculo/{veiculoId}")
	public String deleteContact(@PathVariable("veiculoId") Integer clienteId) {

		veiculoService.deleta(clienteId);

		return "redirect:/exibeVeiculos";
	}

	@RequestMapping("/exibeVeiculos")
	public String exibeAgencias(Map<String, Object> map) {

		map.put("listaVeiculosC", veiculoService.buscaPorTipo("C"));
		map.put("listaVeiculosM", veiculoService.buscaPorTipo("M"));

		return "exibeVeiculos";
	}
	

}
