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
import br.com.emerson.locauto.model.Devolucao;
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

/**
 * @author Emerson Sousa
 * 
 *         Esta classe � um controller na aplica��o.
 */
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
		 * Aqui � que criada a data de locac�o que eh o dia atual, em seguida eh
		 * convertida para o formato dd/mm/yyyy
		 */
		Date dataRetirada = new Date();
		String dataFormatada = new SimpleDateFormat("dd/MM/yyyy").format(dataRetirada);

		/*
		 * Aqui � convertida a data de devolucao da locac�o que vem da view no formato
		 * "yyyy-mm-dd", em seguida eh convertida para o formato dd/mm/yyyy para poder
		 * ser salva no banco
		 */

		DateFormat formatUS = new SimpleDateFormat("yyyy-mm-dd");// formato para exibicao do cliente

		Date dataDevolucao = new Date();
		try {
			dataDevolucao = formatUS.parse(locacao.getDataDevolucao());
		} catch (ParseException e) {
			System.out.println("A convers�o falhou");
			e.printStackTrace();
		}

		/*
		 * Formatando data para realizar o calculo de di�rias com framework jude-time
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

		/*
		 * adicionado um pois � m�todo conta os dias entre as datas exemplo: entre os
		 * dias 24 e 26 cont�m um dia, por�m s�o duas di�rias por isso � adicionado 1 a
		 * quantidade de di�rias
		 */
		int diarias = calculaDiasLocacao(dtEntrada, dtDevolucao) + 1;

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

		// atualizando
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
		 * Aqui � que criada a data de locac�o que eh o dia atual, em seguida eh
		 * convertida para o formato dd/mm/yyyy
		 */
		Date dataRetirada = new Date();
		String dataFormatadaPJ = new SimpleDateFormat("dd/MM/yyyy").format(dataRetirada);

		/*
		 * Aqui � convertida a data de devolucao da locac�o que vem da view no formato
		 * "yyyy-mm-dd", em seguida eh convertida para o formato dd/mm/yyyy para poder
		 * ser salva no banco
		 */

		DateFormat formatUS = new SimpleDateFormat("yyyy-mm-dd");// formato para exibicao do cliente

		Date dataDevolucao = new Date();
		try {
			dataDevolucao = formatUS.parse(locacao.getDataDevolucao());
		} catch (ParseException e) {
			System.out.println("A convers�o falhou");
			e.printStackTrace();
		}

		/*
		 * Formatando data para realizar o calculo de di�rias com framework jude-time
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

		/*
		 * adicionado um pois � m�todo conta os dias entre as datas exemplo: entre os
		 * dias 24 e 26 cont�m um dia, por�m s�o duas di�rias por isso � adicionado 1 a
		 * quantidade de di�rias
		 */
		int diarias = calculaDiasLocacao(dtEntrada, dtDevolucao) + 1;

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

		// atualizando
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
		System.out.println("==================================" + id);

		locacao.setSituacao("Pago");

		locacaoService.salvar(locacao);

		return view;

	}

	@RequestMapping("/locacaoClientePF/calcularDebitos/{locacaoID}")
	public ModelAndView calcularDebitosClientePF(@PathVariable("locacaoID") Integer id) {

		ModelAndView view = new ModelAndView();
		view.setViewName("saldarDebitosClientePF");
		view.addObject("devolucao", new Devolucao());

		LocacaoClientePF locacao = (LocacaoClientePF) locacaoService.buscaPorId(id);
		ClientePF cliente = (ClientePF) clienteService.buscaPorId(locacao.getClientePF().getId());
		Locador locador = (Locador) funcionarioService.buscaPorId(locacao.getLocador().getId());
		Planos plano = planosService.buscaPorId(locacao.getPlano().getId());
		Veiculo veiculo = veiculoService.buscaPorId(locacao.getVeiculo().getId());

		view.addObject("locacao", locacao);
		view.addObject("nomeCliente", cliente.getNome());
		view.addObject("nomeLocador", locador.getNome());
		view.addObject("plano", plano);
		view.addObject("modeloVeiculo", veiculo.getModelo());

		return view;

	}

	@RequestMapping(value = "/locacaoClientePf/finalizarSaldarDebitos", method = RequestMethod.POST)
	public ModelAndView finalizarSaldarDebitosClientePF(@ModelAttribute("devolucao") Devolucao devolucao,
			BindingResult result) throws ParseException {

		LocacaoClientePF locacao = (LocacaoClientePF) locacaoService.buscaPorId(devolucao.getLocacaoId());
		Planos plano = planosService.buscaPorId(locacao.getPlano().getId());
		ClientePF cliente = (ClientePF) clienteService.buscaPorId(locacao.getClientePF().getId());
		Locador locador = (Locador) funcionarioService.buscaPorId(locacao.getLocador().getId());
		Veiculo veiculo = veiculoService.buscaPorId(locacao.getVeiculo().getId());

		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date dtDevolucaoPrevista = formato.parse(locacao.getDataDevolucao());

		DateTime dataDevolucaoFinal = new DateTime();
		DateTime dataDevolucaoPrevista = new DateTime(dtDevolucaoPrevista);

		int diasDeAtraso = calculaDiasLocacao(dataDevolucaoPrevista, dataDevolucaoFinal) ;
		int valorDiaria = plano.getValorDiaria();
		int valorMulta = (5 * (diasDeAtraso * plano.getValorDiaria())) / 100;
		int valorDiariasAtrasadas = diasDeAtraso * valorDiaria;
		int valorTotalatraso = valorDiariasAtrasadas + valorMulta;
		int taxaAbastecimento = calculaTanque(devolucao.getNivelDoTanque());
		int danos = calculaDanos(devolucao.getDanos());
		int totalDevolucao = valorTotalatraso + taxaAbastecimento + danos;

		locacao.setValorTotalLocacao(locacao.getValorTotalLocacao() + valorTotalatraso);
		locacaoService.salvar(locacao);

		ModelAndView view = new ModelAndView();
		view.setViewName("finalizarSaldarDebitosPF");

		view.addObject("locacao", locacao);
		view.addObject("nomeCliente", cliente.getNome());
		view.addObject("nomeLocador", locador.getNome());
		view.addObject("plano", plano);
		view.addObject("modeloVeiculo", veiculo.getModelo());
		view.addObject("diasDeAtraso", diasDeAtraso);
		view.addObject("valorMulta", valorMulta);
		view.addObject("valorTotalatraso", valorTotalatraso);
		view.addObject("valorDiariasAtrasadas", valorDiariasAtrasadas);
		view.addObject("danos", danos);
		view.addObject("taxaAbastecimento", taxaAbastecimento);
		view.addObject("totalDevolucao", totalDevolucao);
		
		return view;

	}
	
	@RequestMapping("/locacaoClientePf/finalizarSaldarDebitos/finalizar/{locacaoID}")
	public ModelAndView finalizarDebitosClientePF(@PathVariable("locacaoID") Integer id) {
		
		LocacaoClientePF locacao = (LocacaoClientePF) locacaoService.buscaPorId(id);
		locacao.setStatus("Finalizada");
		locacaoService.salvar(locacao);
		
		ModelAndView view = new ModelAndView();
		view.setViewName("sucessoSalvar");
		view.addObject("alertTitulo", "Sucesso ao salvar Devolu��o");
		view.addObject("alertCorpo", "Voc� ser� direcionado para: Loca��es Finalizadas");
		view.addObject("location", "/LocAuto/exibeLocacoes");
		
		return view;
		
	}

	@RequestMapping("/locacaoClientePJ/calcularDebitos/{locacaoID}")
	public ModelAndView calcularDebitosClientePJ(@PathVariable("locacaoID") Integer id) {

		ModelAndView view = new ModelAndView();
		view.setViewName("calcalarDebitosPJ");
		LocacaoClientePJ locacao = (LocacaoClientePJ) locacaoService.buscaPorId(id);
		view.addObject("locacao", locacao);

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
	 * Esse m�todo calcula a quantidade de dias que se passam entre a data de
	 * retirada do ve�culo e da devolu��o do mesmo.
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
	 * esse m�to calcula o valor do seguro
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

	public int calculaTanque(String nivelDoTanque) {

		int valor = 0;

		if (nivelDoTanque.equals("cobrar")) {

			valor = 150;
		}

		return valor;
	}

	public int calculaDanos(String danos) {
		int valor = 0;

		if (danos.equals("arranhao")) {
			valor = 80;
		} else if (danos.equals("amassadoLeve")) {
			valor = 180;
		} else if (danos.equals("amassadoGrave")) {
			valor = 350;
		} else if (danos.equals("rouboPerda")) {
			valor = 5000;
		}
		
		return valor;
	}
}
