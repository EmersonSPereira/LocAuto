package br.com.emerson.locauto.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.emerson.locauto.model.LocacaoClientePF;
import br.com.emerson.locauto.service.ClienteService;
import br.com.emerson.locauto.service.FuncionarioService;
import br.com.emerson.locauto.service.LocacaoService;
import br.com.emerson.locauto.service.PlanosService;
import br.com.emerson.locauto.service.VeiculoService;

@Controller
public class LocacaoController {
	
	@Autowired
	private LocacaoService locacaoService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private VeiculoService veiculoService;
	
	@Autowired
	private PlanosService planosService;
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	
	@RequestMapping("/locacaoClientePF")
	public ModelAndView agencia() {

	ModelAndView view = new ModelAndView();
	
	view.setViewName("locacaoClientePF");
	view.addObject("locacao", new LocacaoClientePF());
	view.addObject("listaClientes", clienteService.buscaPorTipo("PF"));
	view.addObject("listaLocadores", funcionarioService.buscaPorTipo("L"));
	view.addObject("listaVeiculos", veiculoService.buscaTodos());
	view.addObject("listaPlanos", planosService.buscaTodos());
		

		return view;
	}
	
	@RequestMapping(value = "/locacaoClientePF/salvar", method = RequestMethod.POST)
	public ModelAndView salvarLocacao(@ModelAttribute("locacao") LocacaoClientePF locacao, BindingResult result) {
		
		Date data = new Date();
		String dataFormatada =  new SimpleDateFormat("dd/MM/yyyy").format(data);
		
		locacao.setDataLocacao(dataFormatada);
		locacaoService.salvar(locacao);
		
		ModelAndView view = new ModelAndView();
		view.setViewName("redirect:/exibeLocacoes");
		
		return view;
		
	}
	
	@RequestMapping("/exibeLocacoes")
	public ModelAndView exibirLocacoes() {
		
		ModelAndView view = new ModelAndView();
		view.setViewName("exibeLocacoes");
		
		view.addObject("locacoesList", locacaoService.buscaTodos());
		
		return view;
		
	}

}
