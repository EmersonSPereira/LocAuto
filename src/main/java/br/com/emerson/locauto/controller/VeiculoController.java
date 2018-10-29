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

import br.com.emerson.locauto.model.Carro;
import br.com.emerson.locauto.model.Locacao;
import br.com.emerson.locauto.model.Motocicleta;
import br.com.emerson.locauto.service.AgenciaService;
import br.com.emerson.locauto.service.LocacaoService;
import br.com.emerson.locauto.service.VeiculoService;

/**
 * @author Emerson Sousa
 * 
 *         Esta classe é um controller na aplicação.
 */
@Controller
public class VeiculoController {

	@Autowired
	private VeiculoService veiculoService;

	@Autowired
	private AgenciaService agenciaService;

	@Autowired
	private LocacaoService locacaoService;

	/**
	 * Esse método trata a requisição "/veiculoC, adiciona um objeto planoC na view
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
	 * Esse método trata as requisições "/salvaVeiculoC",
	 * "editarVeiculoC/salvaVeiculoC" monta o objeto veiculoC, vindo da view, caso o
	 * veiculo não exista salva no banco, se existir edita.
	 * 
	 * @param carro
	 * @param result
	 * @return
	 */
	@RequestMapping(value = { "/salvaVeiculoC", "editarVeiculoC/salvaVeiculoC" }, method = RequestMethod.POST)
	public ModelAndView addCarro(@ModelAttribute("veiculoC") Carro carro, BindingResult result) {

		veiculoService.salvar(carro);

		ModelAndView view = new ModelAndView();
		view.setViewName("sucessoSalvar");
		view.addObject("alertTitulo", "Sucesso ao salvar Carro");
		view.addObject("alertCorpo", "Você será direcionado para: Veículos");
		view.addObject("location", "/LocAuto/exibeVeiculos");
		
		return view;
	}

	/**
	 * Esse método trata a requisição "/veiculoM, adiciona um objeto veiculoM na
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
	 * Esse método trata as requisições "/salvaVeiculoM",
	 * "editarVeiculoM/salvaVeiculoM" monta o objeto veiculoM, vindo da view, caso o
	 * veiculo não exista salva no banco se existir edita.
	 * 
	 * @param moto
	 * @param result
	 * @return
	 */
	@RequestMapping(value = { "/salvaVeiculoM", "editarVeiculoM/salvaVeiculoM" }, method = RequestMethod.POST)
	public ModelAndView addMotocicleta(@ModelAttribute("veiculoM") Motocicleta moto, BindingResult result) {

		veiculoService.salvar(moto);
		
		ModelAndView view = new ModelAndView();
		view.setViewName("sucessoSalvar");
		view.addObject("alertTitulo", "Sucesso ao salvar Motocicleta");
		view.addObject("alertCorpo", "Você será direcionado para: Veículos");
		view.addObject("location", "/LocAuto/exibeVeiculos");
		
		return view;
	}

	/**
	 * Esse método trata a requisição "/delete/{veiculoId}" recebe o id de um
	 * veiculo e deleta do banco
	 * 
	 * @param clienteId
	 * @return
	 */
	@RequestMapping("/deleteVeiculo/{veiculoId}")
	public ModelAndView deleteVeiculo(@PathVariable("veiculoId") Integer veiculoId) {

		ModelAndView view = new ModelAndView();
		List<Locacao> locacoes = locacaoService.buscaTodos();

		if (!locacoes.isEmpty()) {
			for (Locacao locacao : locacoes) {

				Integer idVeiculoLocacao = locacao.getVeiculo().getId();

				if (idVeiculoLocacao.equals(veiculoId)) {
					view.setViewName("falhaDeletar");
					view.addObject("alertTitulo", "Falha ao deletar Veículo");
					view.addObject("alertCorpo",
							"Este veículo já foi disponibilizado para uma locacao" + " e não pode ser deletado");
					view.addObject("location", "/LocAuto/exibeVeiculos");
				} else {
					veiculoService.deleta(veiculoId);
					view.setViewName("sucessoDeletar");
					view.addObject("alertTitulo", "Sucessso ao deletar Veículo");
					view.addObject("alertCorpo", "O Veículo foi deletado com sucesso da base de dados");
					view.addObject("location", "/LocAuto/exibeVeiculos");
				}
			}
		} else {
			veiculoService.deleta(veiculoId);
			view.setViewName("sucessoDeletar");
			view.addObject("alertTitulo", "Sucessso ao deletar Veículo");
			view.addObject("alertCorpo", "O Veículo foi deletado com sucesso da base de dados");
			view.addObject("location", "/LocAuto/exibeVeiculos");
		}

		return view;
	}

	/**
	 * Esse método trata a requisição "/editarVeiculoC/{veiculoId}" recebe o id de
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
	 * Esse método trata a requisição "/editarVeiculoM/{veiculoId}" recebe o id de
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
	 * Esse método trata a requisição "/exibeVeiculos" envia para view
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
