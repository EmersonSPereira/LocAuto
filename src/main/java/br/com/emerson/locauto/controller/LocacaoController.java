package br.com.emerson.locauto.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
	view.addObject("listaClientes", clienteService.buscaPorTipo("PF"));
	view.addObject("listaLocadores", funcionarioService.buscaPorTipo("L"));
	view.addObject("listaVeiculos", veiculoService.buscaTodos());
	view.addObject("listaPlanos", planosService.buscaTodos());
		

		return view;
	}

}
