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
import br.com.emerson.locauto.model.Veiculo;
import br.com.emerson.locauto.service.AgenciaService;
import br.com.emerson.locauto.service.FuncionarioService;
import br.com.emerson.locauto.service.VeiculoService;

/**
 * @author Emerson Sousa
 * 
 * Esta classe é um controller na aplicação.
 */
@Controller
public class AgenciaController {

	@Autowired
	private AgenciaService agenciaService;
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@Autowired
	private VeiculoService veiculoService;
	
	/**
	 * Esse método trata a requisição "/agencia, adiciona um objeto agencia na view e por fim
	 * retorna a view "agencia"
	 * @param map
	 * @return
	 */

	@RequestMapping("/agencia")
	public String agencia(Map<String, Object> map) {

		map.put("agencia", new Agencia());
		map.put("listaGerentes", funcionarioService.buscaPorTipo("G"));
		

		return "agencia";
	}

	/**
	 * Esse método trata a requisição "/add" monta o objeto agencia, vindo da view e salva no banco.
	 * @param agencia
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addAgencia(@ModelAttribute("agencia") Agencia agencia, BindingResult result) {

		agenciaService.salvar(agencia);

		return "redirect:/exibeAgencias";
	}
	
	/**
	 * Esse método trata a requisição "editar/add" monta o objeto agencia, vindo da view e edita no banco.
	 * @param agencia
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "editar/add", method = RequestMethod.POST)
	public String editAgencia(@ModelAttribute("agencia") Agencia agencia, BindingResult result) {
		
		System.out.println(" O ID da Agencia dentro do quando vou salvar é :" + agencia.getId());
		agenciaService.salvar(agencia);

		return "redirect:/exibeAgencias";
	}


	/**
	 * Esse método trata a requisição "/delete/{agenciaId}" recebe o id de uma agencia e deleta do banco
	 * @param agenciaId
	 * @return
	 */
	@RequestMapping("/delete/{agenciaId}")
	public ModelAndView deleteAgencia(@PathVariable("agenciaId") Integer agenciaId) {

		ModelAndView view = new ModelAndView();
		view.setViewName("exibeAgencias");
		view.addObject("agenciaList", agenciaService.buscaTodos());
		
		List<Veiculo> veiculos = veiculoService.buscaTodos();
		
		
		if(!veiculos.isEmpty()) {
			
		for(Veiculo veiculo: veiculoService.buscaTodos()) {
			
			
			Integer idVeiculoAgencia = veiculo.getAgencia().getId();
			
			
			if(idVeiculoAgencia.equals(agenciaId)) {
				view.setViewName("falhaDeletar");
				view.addObject("alertTitulo", "Falha ao deletar Agência");
				view.addObject("alertCorpo", "Não foi possível deletar a Agência ela está associada a um"
						+ " ou mais veiculos, para poder deletar associe os veículos a outra Agência");
				view.addObject("location", "/LocAuto/exibeAgencias");
			}else {
				
				agenciaService.deleta(agenciaId);
				view.setViewName("sucessoDeletar");			
				view.addObject("alertTitulo", "Sucessso ao deletar Agência");
				view.addObject("alertCorpo", "Agência foi deletada com sucesso da base de dados");
				view.addObject("location", "/LocAuto/exibeAgencias");

			}
		}
		}else {
			agenciaService.deleta(agenciaId);
			view.setViewName("sucessoDeletar");			
			view.addObject("alertTitulo", "Sucessso ao deletar Agência");
			view.addObject("alertCorpo", "Agência foi deletada com sucesso da base de dados");
			view.addObject("location", "/LocAuto/exibeAgencias");
		}
		
		

		return view;
	}
	
	/**
	 * Esse método trata a requisição "/editar/{agenciaId}" recebe o id de uma agencia e edita no banco
	 * @param agenciaId
	 * @return
	 */
	@RequestMapping(value = "/editar/{agenciaId}")
	public ModelAndView editAgencia(Map<String, Object> map,@PathVariable("agenciaId") Integer agenciaId) {

		ModelAndView view = new ModelAndView();
		view.setViewName("agencia");
		Agencia agencia = agenciaService.buscaPorId(agenciaId);
		view.addObject("listaGerentes", funcionarioService.buscaPorTipo("G"));
		view.addObject("agencia", agencia);
		

		return view;
	}
	
	/**
	 * Esse método trata a requisição "/exibeAgencias" envia para view "exibeAgencias" uma lista de Agencias para ser exibido
	 * para o usuário
	 * @param map
	 * @return
	 */
	
	@RequestMapping("/exibeAgencias")
	public String exibeAgencias(Map<String, Object> map) {
		map.put("agenciaList", agenciaService.buscaTodos());
		return "exibeAgencias";
	}
	
	
}
