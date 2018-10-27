package br.com.emerson.locauto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.emerson.locauto.service.LocacaoService;

/**
 * @author Emerson Sousa
 * 
 *         Esta classe é um controller na aplicação.
 */
@Controller
public class HomeController {
	
	@Autowired
	LocacaoService locacaoService;
	
	@RequestMapping("/")
	public ModelAndView homePage() {
		
		ModelAndView view = new  ModelAndView();
		view.setViewName("home");
		view.addObject("locacoesListPF", locacaoService.buscaPorTipoCliente("PF"));
		view.addObject("locacoesListPJ", locacaoService.buscaPorTipoCliente("PJ"));
		
		
		return view;
		
	}

}
