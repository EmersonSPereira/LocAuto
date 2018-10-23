package br.com.emerson.locauto.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.emerson.locauto.model.ClientePF;
import br.com.emerson.locauto.model.ClientePJ;
import br.com.emerson.locauto.model.Locacao;
import br.com.emerson.locauto.model.LocacaoClientePF;
import br.com.emerson.locauto.model.LocacaoClientePJ;
import br.com.emerson.locauto.model.Locador;
import br.com.emerson.locauto.model.Planos;
import br.com.emerson.locauto.model.Veiculo;
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
		 * Aqui é que criada a data de locacão que eh o dia atual, em seguida eh
		 * convertida para o formato dd/mm/yyyy
		 */
		Date dataRetirada = new Date();
		String dataFormatada = new SimpleDateFormat("dd/MM/yyyy").format(dataRetirada);

		/*
		 * Aqui é convertida a data de devolucao da locacão que vem da view no formato
		 * "yyyy-mm-dd", em seguida eh convertida para o formato dd/mm/yyyy para poder
		 * ser salva no banco
		 */

		DateFormat formatUS = new SimpleDateFormat("yyyy-mm-dd");// formato para exibicao do cliente

		Date dataDevolucao = new Date();
		try {
			dataDevolucao = formatUS.parse(locacao.getDataDevolucao());
		} catch (ParseException e) {
			System.out.println("A conversão falhou");
			e.printStackTrace();
		}

		/*
		 * Formatando data para realizar o calculo de diárias com framework jude-time
		 */

		DateFormat formatUSCalc = new SimpleDateFormat("yyyy-MM-dd");// formato usado para calculo

		Date dataDevolucaoCalc = new Date();
		try {
			dataDevolucaoCalc = formatUSCalc.parse(locacao.getDataDevolucao());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		DateFormat formatBR = new SimpleDateFormat("dd/mm/yyyy");
		String dateFormated = formatBR.format(dataDevolucao);

		locacao.setDataDevolucao(dateFormated);

		locacao.setDataLocacao(dataFormatada);
	

		// utilizando o frameword jude-time para calcular os dias que se passaram entre
		// uma data e outra

		DateTime dtEntrada = new DateTime(dataRetirada);
		DateTime dtDevolucao = new DateTime(dataDevolucaoCalc);

		System.out.println("==================================datas====================================");
		System.out.println("Data entrada: " + dtEntrada + "Data Saida: " + dtDevolucao);

		int diarias = calculaDiasLocacao(dtEntrada, dtDevolucao);

		// recuperando cliente, locador,veiculo e plano

		ClientePF cliente = (ClientePF) clienteService.buscaPorId(locacao.getClientePF().getId());
		Locador locador = (Locador) funcionarioService.buscaPorId(locacao.getLocador().getId());
		Planos plano = planosService.buscaPorId(locacao.getPlano().getId());
		Veiculo veiculo = veiculoService.buscaPorId(locacao.getVeiculo().getId());

		// recuperando valor da diaria do plano
		int valorPlano = plano.getValorDiaria();

		// Calculando Valores
		int valorDiarias = diarias * valorPlano;

		int valorSeguro = calcularValorSeguro(valorDiarias, locacao.getSeguro());

		int valorTotal = valorDiarias + valorSeguro;

		// recuperando nome do usuario e do locador

		ModelAndView view = new ModelAndView();
		view.setViewName("finalizarLocacaoClientePF");
		view.addObject("locacao", locacao);
		view.addObject("diarias", diarias);
		view.addObject("valorDiarias", valorDiarias);
		view.addObject("valorSeguro", valorSeguro);
		view.addObject("valorTotal", valorTotal);
		view.addObject("nomeCliente", cliente.getNome());
		view.addObject("nomeLocador", locador.getNome());
		view.addObject("plano", plano);
		view.addObject("modeloVeiculo", veiculo.getModelo());
		
		//atualizando 
		locacao.setValorTotalLocacao(valorTotal);
		locacaoService.salvar(locacao);

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
	public ModelAndView salvarLocacaoClientePJ(@ModelAttribute("locacao") LocacaoClientePJ locacao,
			BindingResult result) {

		Date dataLocacao = new Date();
		String dataFormatada = new SimpleDateFormat("dd/MM/yyyy").format(dataLocacao);

		/*
		 * Aqui é que criada a data de locacão que eh o dia atual, em seguida eh
		 * convertida para o formato dd/mm/yyyy
		 */
		Date dataRetirada = new Date();
		String dataFormatadaPJ = new SimpleDateFormat("dd/MM/yyyy").format(dataRetirada);

		/*
		 * Aqui é convertida a data de devolucao da locacão que vem da view no formato
		 * "yyyy-mm-dd", em seguida eh convertida para o formato dd/mm/yyyy para poder
		 * ser salva no banco
		 */

		DateFormat formatUS = new SimpleDateFormat("yyyy-mm-dd");// formato para exibicao do cliente

		Date dataDevolucao = new Date();
		try {
			dataDevolucao = formatUS.parse(locacao.getDataDevolucao());
		} catch (ParseException e) {
			System.out.println("A conversão falhou");
			e.printStackTrace();
		}

		/*
		 * Formatando data para realizar o calculo de diárias com framework jude-time
		 */

		DateFormat formatUSCalc = new SimpleDateFormat("yyyy-MM-dd");// formato usado para calculo

		Date dataDevolucaoCalc = new Date();
		try {
			dataDevolucaoCalc = formatUSCalc.parse(locacao.getDataDevolucao());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		DateFormat formatBR = new SimpleDateFormat("dd/mm/yyyy");
		String dateFormated = formatBR.format(dataDevolucao);

		locacao.setDataDevolucao(dateFormated);

		locacao.setDataLocacao(dataFormatadaPJ);
	

		// utilizando o frameword jude-time para calcular os dias que se passaram entre
		// uma data e outra

		DateTime dtEntrada = new DateTime(dataRetirada);
		DateTime dtDevolucao = new DateTime(dataDevolucaoCalc);

		System.out.println("==================================datas====================================");
		System.out.println("Data entrada: " + dtEntrada + "Data Saida: " + dtDevolucao);

		int diarias = calculaDiasLocacao(dtEntrada, dtDevolucao);

		// recuperando cliente, locador,veiculo e plano

		ClientePJ cliente = (ClientePJ) clienteService.buscaPorId(locacao.getClientePJ().getId());
		Locador locador = (Locador) funcionarioService.buscaPorId(locacao.getLocador().getId());
		Planos plano = planosService.buscaPorId(locacao.getPlano().getId());
		Veiculo veiculo = veiculoService.buscaPorId(locacao.getVeiculo().getId());

		// recuperando valor da diaria do plano
		int valorPlano = plano.getValorDiaria();

		// Calculando Valores
		int valorDiarias = diarias * valorPlano;

		int valorSeguro = calcularValorSeguro(valorDiarias, locacao.getSeguro());

		int valorTotal = valorDiarias + valorSeguro;

		// recuperando nome do usuario e do locador

		ModelAndView view = new ModelAndView();
		view.setViewName("finalizarLocacaoClientePJ");
		view.addObject("locacao", locacao);
		view.addObject("diarias", diarias);
		view.addObject("valorDiarias", valorDiarias);
		view.addObject("valorSeguro", valorSeguro);
		view.addObject("valorTotal", valorTotal);
		view.addObject("nomeCliente", cliente.getNomeFantasia());
		view.addObject("nomeLocador", locador.getNome());
		view.addObject("plano", plano);
		view.addObject("modeloVeiculo", veiculo.getModelo());
		
		//atualizando 
		locacao.setValorTotalLocacao(valorTotal);
		locacaoService.salvar(locacao);

		return view;

	}

	@RequestMapping("/locacaoClientePF/finalizar/{locacaoID}")
	public ModelAndView finalizarLocacaoClientePF(@PathVariable("locacaoID") Integer id) {

		ModelAndView view = new ModelAndView();
		view.setViewName("redirect:/exibeLocacoes");
		Locacao locacao = locacaoService.buscaPorId(id);

		locacao.setSituacao("Pago");
		
		locacaoService.salvar(locacao);

		return view;

	}
	
	@RequestMapping("/locacaoClientePJ/finalizar/{locacaoID}")
	public ModelAndView finalizarLocacaoClientePJ(@PathVariable("locacaoID") Integer id) {

		ModelAndView view = new ModelAndView();
		view.setViewName("redirect:/exibeLocacoes");
		LocacaoClientePJ locacao = (LocacaoClientePJ) locacaoService.buscaPorId(id);
		System.out.println("=================================="+id);

		locacao.setSituacao("Pago");
		
		locacaoService.salvar(locacao);

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

	/**
	 * Esse método calcula a quantidade de dias que se passam entre a data de
	 * retirada do veículo e da devolução do mesmo.
	 * 
	 * @param retirada
	 * @param devolucao
	 * @return
	 */
	public int calculaDiasLocacao(DateTime retirada, DateTime devolucao) {

		int dias = Days.daysBetween(retirada, devolucao).getDays();

		return dias;

	}

	/**
	 * esse méto calcula o valor do seguro
	 * 
	 * @param valorDiarias
	 * @param seguro
	 * @return
	 */
	public int calcularValorSeguro(int valorDiarias, String seguro) {

		int valorSeguro = 0;

		if (seguro.equals("Nenhum")) {

			valorSeguro = 0;

		} else if (seguro.equals("Parcial")) {

			valorSeguro = (25 * valorDiarias) / 100;

		} else {
			valorSeguro = (50 * valorDiarias) / 100;
		}

		return valorSeguro;
	}
}
