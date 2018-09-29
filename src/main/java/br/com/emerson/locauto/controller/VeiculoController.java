package br.com.emerson.locauto.controller;



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
/**
 * @author Emerson Sousa
 * 
 * Esta classe é um controller na aplicação.
 */
@Controller
public class VeiculoController {

	@Autowired
	private VeiculoService veiculoService;
	
	
	/**
	 * Esse método trata a requisição "/veiculoC, adiciona um objeto planoC na view
	 *  e por fim retorna a view "carro"
	 * @param map
	 * @return
	 */
	@RequestMapping("/veiculoC")
	public String veiculoC(Map<String, Object> map) {

		map.put("veiculoC", new Carro());

		return "carro";
	}
	
	
	/**
	 * Esse método trata a requisição "/salvaVeiculoC" monta o objeto veiculoC, vindo da view e salva no banco.
	 * @param carro
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/salvaVeiculoC", method = RequestMethod.POST)
	public String addCarro(@ModelAttribute("veiculoC") Carro carro, BindingResult result) {

		veiculoService.salvar(carro);

		return "redirect:/exibeVeiculos";
	}

	
	/**
	 * Esse método trata a requisição "/veiculoM, adiciona um objeto veiculoM na view
	 *  e por fim retorna a view "motocicleta"
	 * @param map
	 * @return
	 */
	@RequestMapping("/veiculoM")
	public String veiculoM(Map<String, Object> map) {

		map.put("veiculoM", new Motocicleta());

		return "motocicleta";
	}
	
	
	/**
	 * Esse método trata a requisição "/salvaVeiculoM" monta o objeto veiculoM, vindo da view e salva no banco.
	 * @param moto
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/salvaVeiculoM", method = RequestMethod.POST)
	public String addMotocicleta(@ModelAttribute("veiculoM") Motocicleta moto, BindingResult result) {

		veiculoService.salvar(moto);

		return "redirect:/exibeVeiculos";
	}
	
	
	/**
	 * Esse método trata a requisição "/delete/{veiculoId}" recebe o id de um veiculo e deleta do banco
	 * @param clienteId
	 * @return
	 */
	@RequestMapping("/deleteVeiculo/{veiculoId}")
	public String deleteVeiculo(@PathVariable("veiculoId") Integer clienteId) {

		veiculoService.deleta(clienteId);

		return "redirect:/exibeVeiculos";
	}

	
	/**
	 * Esse método trata a requisição "/exibeVeiculos" envia para view "exibeVeiculos" um lista de carros 
	 * e uma lista de motos  para ser exibido
	 * @param map
	 * @return
	 */
	@RequestMapping("/exibeVeiculos")
	public String exibeVeiculos(Map<String, Object> map) {

		map.put("listaVeiculosC", veiculoService.buscaPorTipo("C"));
		map.put("listaVeiculosM", veiculoService.buscaPorTipo("M"));

		return "exibeVeiculos";
	}
	

}
