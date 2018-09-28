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

/**
 * @author Emerson Sousa
 * 
 * Esta classe � um controller na aplica��o.
 */
@Controller
public class AgenciaController {

	@Autowired
	private AgenciaService agenciaService;
	
	/**
	 * Esse m�todo trata a requisi��o "/agencia, adicioa um objeto agencia na view e por fim
	 * retorna a view "agencia"
	 * @param map
	 * @return
	 */

	@RequestMapping("/agencia")
	public String agencia(Map<String, Object> map) {

		map.put("agencia", new Agencia());
		

		return "agencia";
	}

	/**
	 * Esse m�todo trata a requisi��o "/add" monta o objeto agencia, vindo da view e salva no banco.
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
	 * Esse m�todo trata a requisi��o "/delete/{agenciaId}" recebe o id de uma agencia e deleta do banco
	 * @param agenciaId
	 * @return
	 */
	@RequestMapping("/delete/{agenciaId}")
	public String deleteAgencia(@PathVariable("agenciaId") Integer agenciaId) {

		agenciaService.deleta(agenciaId);

		return "redirect:/exibeAgencias";
	}
	
	/**
	 * Esse m�todo trata a requisi��o "/exibeAgencias" envia para view "exibeAgencias" uma lista de Agencias para ser exibido
	 * para o usu�rio
	 * @param map
	 * @return
	 */
	
	@RequestMapping("/exibeAgencias")
	public String exibeAgencias(Map<String, Object> map) {
		map.put("agenciaList", agenciaService.buscaTodos());
		return "exibeAgencias";
	}

}
