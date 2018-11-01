package br.com.emerson.locauto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.emerson.locauto.service.LocacaoService;

/**
 * @author Emerson Sousa
 * 
 *         Esta classe � um controller na aplica��o.
 */
@Controller
public class HomeController {
	
	@Autowired
	LocacaoService locacaoService;
	/**
	 * Este m�todo recebe uma requisi��o "/" e retorna a HomePage
	 * @return
	 */
	@RequestMapping("/")
	public ModelAndView homePage() {
		
		ModelAndView view = new  ModelAndView();
		view.setViewName("home");
		view.addObject("locacoesListPF", locacaoService.buscaPorTipoClienteStatus("PF", "Ativa"));
		view.addObject("locacoesListPJ", locacaoService.buscaPorTipoClienteStatus("PJ", "Ativa"));
		
		
		return view;
		
	}

}
