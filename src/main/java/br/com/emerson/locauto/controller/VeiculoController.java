package br.com.emerson.locauto.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.emerson.locauto.model.Carro;
import br.com.emerson.locauto.model.Motocicleta;
import br.com.emerson.locauto.service.AgenciaService;
import br.com.emerson.locauto.service.VeiculoService;

/**
 * @author Emerson Sousa
 * 
 *         Esta classe � um controller na aplica��o.
 */
@Controller
public class VeiculoController {

	@Autowired
	private VeiculoService veiculoService;
	
	@Autowired
	private AgenciaService agenciaService;

	/**
	 * Esse m�todo trata a requisi��o "/veiculoC, adiciona um objeto planoC na view
	 * e por fim retorna a view "carro"
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("/veiculoC")
	public String veiculoC(Map<String, Object> map) {

		map.put("veiculoC", new Carro());
		map.put("agenciasList", agenciaService.buscaTodos());

		return "carro";
	}

	/**
	 * Esse m�todo trata as requisi��es "/salvaVeiculoC", "editarVeiculoC/salvaVeiculoC" monta o objeto veiculoC,
	 * vindo da view, caso o veiculo n�o exista salva no banco, se existir edita.
	 * 
	 * @param carro
	 * @param result
	 * @return
	 */
	@RequestMapping(value = { "/salvaVeiculoC", "editarVeiculoC/salvaVeiculoC" }, method = RequestMethod.POST)
	public String addCarro(@ModelAttribute("veiculoC") Carro carro, BindingResult result) {

		veiculoService.salvar(carro);

		return "redirect:/exibeVeiculos";
	}

	/**
	 * Esse m�todo trata a requisi��o "/veiculoM, adiciona um objeto veiculoM na
	 * view e por fim retorna a view "motocicleta"
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("/veiculoM")
	public String veiculoM(Map<String, Object> map) {

		map.put("veiculoM", new Motocicleta());
		map.put("agenciasList", agenciaService.buscaTodos());


		return "motocicleta";
	}

	/**
	 * Esse m�todo trata as requisi��es "/salvaVeiculoM", "editarVeiculoM/salvaVeiculoM" monta o objeto veiculoM,
	 * vindo da view, caso o veiculo n�o exista salva no banco se existir edita.
	 * 
	 * @param moto
	 * @param result
	 * @return
	 */
	@RequestMapping(value = { "/salvaVeiculoM", "editarVeiculoM/salvaVeiculoM" }, method = RequestMethod.POST)
	public String addMotocicleta(@ModelAttribute("veiculoM") Motocicleta moto, BindingResult result) {

		veiculoService.salvar(moto);

		return "redirect:/exibeVeiculos";
	}

	/**
	 * Esse m�todo trata a requisi��o "/delete/{veiculoId}" recebe o id de um
	 * veiculo e deleta do banco
	 * 
	 * @param clienteId
	 * @return
	 */
	@RequestMapping("/deleteVeiculo/{veiculoId}")
	public String deleteVeiculo(@PathVariable("veiculoId") Integer clienteId) {

		veiculoService.deleta(clienteId);

		return "redirect:/exibeVeiculos";
	}

	/**
	 * Esse m�todo trata a requisi��o "/editarVeiculoC/{veiculoId}" recebe o id de
	 * um veiculo e carrega o veiculo do banco e envia o objeto para view para ser
	 * editado.
	 * 
	 * @param clienteId
	 * @return
	 */
	@RequestMapping(value = "/editarVeiculoC/{veiculoId}")
	public ModelAndView editVeiculoC(Map<String, Object> map, @PathVariable("veiculoId") Integer veiculoId) {

		ModelAndView view = new ModelAndView();
		view.setViewName("carro");
		view.addObject("veiculoC", veiculoService.buscaPorId(veiculoId));
		view.addObject("agenciasList", agenciaService.buscaTodos());


		return view;
	}

	/**
	 * Esse m�todo trata a requisi��o "/editarVeiculoM/{veiculoId}" recebe o id de
	 * um veiculo e carrega o veiculo do banco e envia o objeto para view para ser
	 * editado.
	 * 
	 * @param clienteId
	 * @return
	 */
	@RequestMapping(value = "/editarVeiculoM/{veiculoId}")
	public ModelAndView editVeiculoM(Map<String, Object> map, @PathVariable("veiculoId") Integer veiculoId) {

		ModelAndView view = new ModelAndView();
		view.setViewName("motocicleta");
		view.addObject("veiculoM", veiculoService.buscaPorId(veiculoId));
		view.addObject("agenciasList", agenciaService.buscaTodos());


		return view;
	}

	/**
	 * Esse m�todo trata a requisi��o "/exibeVeiculos" envia para view
	 * "exibeVeiculos" um lista de carros e uma lista de motos para ser exibido
	 * 
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
