package br.com.emerson.locauto.controller;

import java.text.DateFormat;
import java.text.ParseException;
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
import br.com.emerson.locauto.model.LocacaoClientePJ;
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
	
	/**
	 * 
	 * @return 
	 */
	@RequestMapping("/locacaoClientePF")
	public ModelAndView LocacaoClientePF() {

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
		
		/*
		 * Aqui � que criada a data de locac�o que eh o dia atual, em seguida eh convertida para o formato dd/mm/yyyy
		 */
		Date data = new Date();
		String dataFormatada =  new SimpleDateFormat("dd/MM/yyyy").format(data);

		/*
		 * Aqui � convertida a data de devolucao da locac�o que vem da view no formato "yyyy-mm-dd", 
		 * em seguida eh convertida para o formato dd/mm/yyyy para poder ser salva no banco
		 */
		DateFormat formatUS = new SimpleDateFormat("yyyy-mm-dd");
		
		Date date = new Date();
		try {
			 date = formatUS.parse(locacao.getDataDevolucao());
		} catch (ParseException e) {
			System.out.println("A convers�o falhou");
			e.printStackTrace();
		}
		
		DateFormat formatBR = new SimpleDateFormat("dd/mm/yyyy");
		String dateFormated = formatBR.format(date);
		
		
		locacao.setDataDevolucao(dateFormated);
		
		locacao.setDataLocacao(dataFormatada);
		locacaoService.salvar(locacao);
		
		ModelAndView view = new ModelAndView();
		view.setViewName("redirect:/exibeLocacoes");
		
		return view;
		
	}
	
	@RequestMapping("/locacaoClientePJ")
	public ModelAndView LocacaoClientePJ() {

	ModelAndView view = new ModelAndView();
	
	view.setViewName("locacaoClientePJ");
	view.addObject("locacao", new LocacaoClientePJ());
	view.addObject("listaClientes", clienteService.buscaPorTipo("PJ"));
	view.addObject("listaLocadores", funcionarioService.buscaPorTipo("L"));
	view.addObject("listaVeiculos", veiculoService.buscaTodos());
	view.addObject("listaPlanos", planosService.buscaTodos());
		

		return view;
	}
	
	@RequestMapping(value = "/locacaoClientePJ/salvar", method = RequestMethod.POST)
	public ModelAndView salvarLocacaoClientePJ(@ModelAttribute("locacao") LocacaoClientePJ locacao, BindingResult result) {
		
		Date data = new Date();
		String dataFormatada =  new SimpleDateFormat("dd/MM/yyyy").format(data);
		
		/*
		 * Aqui � convertida a data de devolucao da locac�o que vem da view no formato "yyyy-mm-dd", 
		 * em seguida eh convertida para o formato dd/mm/yyyy para poder ser salva no banco
		 */
		DateFormat formatUS = new SimpleDateFormat("yyyy-mm-dd");
		
		Date date = new Date();
		try {
			 date = formatUS.parse(locacao.getDataDevolucao());
		} catch (ParseException e) {
			System.out.println("A convers�o falhou");
			e.printStackTrace();
		}
		
		DateFormat formatBR = new SimpleDateFormat("dd/mm/yyyy");
		String dateFormated = formatBR.format(date);
		
		locacao.setDataDevolucao(dateFormated);
		
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
		
		view.addObject("locacoesListPF", locacaoService.buscaPorTipoCliente("PF"));
		view.addObject("locacoesListPJ", locacaoService.buscaPorTipoCliente("PJ"));
		
		return view;
		
	}

}