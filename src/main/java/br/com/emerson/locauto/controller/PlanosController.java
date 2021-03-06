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

import br.com.emerson.locauto.model.Locacao;
import br.com.emerson.locauto.model.PlanosCarro;
import br.com.emerson.locauto.model.PlanosMoto;
import br.com.emerson.locauto.service.LocacaoService;
import br.com.emerson.locauto.service.PlanosService;

/**
 * @author Emerson Sousa
 * 
 *         Esta classe � um controller na aplica��o.
 */

@Controller
public class PlanosController {

	@Autowired
	private PlanosService planosService;

	@Autowired
	private LocacaoService locacaoService;

	private PlanosCarro planoCarroA, planoCarroB, planoCarroC, planoCarroD, planoCarroE, planoCarroF, planoCarroG;
	private PlanosMoto planoMotoA, planoMotoB, planoMotoC, planoMotoD;

	/**
	 * Esse m�todo trata a requisi��o "/planoC, adiciona um objeto planoC na view e
	 * por fim retorna a view "planoCarro"
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("/planoC")
	public String planoC(Map<String, Object> map) {

		map.put("planoC", new PlanosCarro());

		if (planosService.buscaTodos().isEmpty()) {
			salvaPlanosCarro();
			salvaPlanosMoto();
		}

		return "planoCarro";
	}

	/**
	 * Esse m�todo trata as requisi��es "/salvaPlanoC","editarPlanoC/salvaPlanoC"
	 * monta o objeto planoC, vindo da view caso o objeto n�o exista salva no banco
	 * se j� existir edita.
	 * 
	 * @param planoCarro
	 * @param result
	 * @return
	 */
	@RequestMapping(value = { "/salvaPlanoC", "editarPlanoC/salvaPlanoC" }, method = RequestMethod.POST)
	public ModelAndView addPlanoC(@ModelAttribute("planoC") PlanosCarro planoCarro, BindingResult result) {

		planosService.salvar(planoCarro);

		ModelAndView view = new ModelAndView();
		view.setViewName("sucessoSalvar");
		view.addObject("alertTitulo", "Sucesso ao salvar Plano");
		view.addObject("alertCorpo", "Voc� ser� direcionado para: Planos");
		view.addObject("location", "/LocAuto/exibePlanos");
		
		return view;
	}

	/**
	 * Esse m�todo trata as requisi��o "/planoM, adiciona um objeto planoM na view e
	 * por fim retorna a view "planoCarro"
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("/planoM")
	public String planoM(Map<String, Object> map) {

		map.put("planoM", new PlanosMoto());

		if (planosService.buscaTodos().isEmpty()) {
			salvaPlanosCarro();
			salvaPlanosMoto();
		}

		return "planoMotocicleta";
	}

	/**
	 * Esse m�todo trata as requisi��es "/salvaPlanoM","editaplamoM/salvaPlanoM"
	 * monta o objeto planoM, vindo da view caso o objeto n�o exista salva no banco,
	 * se j� existir edita.
	 * 
	 * @param planoMoto
	 * @param result
	 * @return
	 */
	@RequestMapping(value = { "/salvaPlanoM", "editarPlanoM/salvaPlanoM" }, method = RequestMethod.POST)
	public ModelAndView addPlanoM(@ModelAttribute("planoM") PlanosMoto planoMoto, BindingResult result) {

		planosService.salvar(planoMoto);

		ModelAndView view = new ModelAndView();
		view.setViewName("sucessoSalvar");
		view.addObject("alertTitulo", "Sucesso ao salvar Plano");
		view.addObject("alertCorpo", "Voc� ser� direcionado para: Planos");
		view.addObject("location", "/LocAuto/exibePlanos");
		
		return view;
	}

	/**
	 * Esse m�todo trata a requisi��o "/delete/{planoId}" recebe o id de um plano e
	 * deleta do banco
	 * 
	 * @param planoId
	 * @return
	 */
	@RequestMapping("/deletePlano/{planoId}")
	public ModelAndView deletePlano(@PathVariable("planoId") Integer planoId) {

		ModelAndView view = new ModelAndView();
		List<Locacao> locacoes = locacaoService.buscaTodos();

		if (!locacoes.isEmpty()) {
			for (Locacao locacao : locacoes) {

				Integer idPlanoLocacao = locacao.getPlano().getId();

				if (idPlanoLocacao.equals(planoId)) {

					view.setViewName("falhaDeletar");
					view.addObject("alertTitulo", "Falha ao deletar Plano");
					view.addObject("alertCorpo",
							"Este Plano est� associado a uma loca��o" + " e n�o pode ser deletado");
					view.addObject("location", "/LocAuto/exibePlanos");
				} else {

					planosService.deleta(planoId);
					view.setViewName("sucessoDeletar");
					view.addObject("alertTitulo", "Sucessso ao deletar Plano");
					view.addObject("alertCorpo", "O Ve�culo foi deletado com sucesso da base de dados");
					view.addObject("location", "/LocAuto/exibePlanos");

				}
			}
		} else {
			planosService.deleta(planoId);
			view.setViewName("sucessoDeletar");
			view.addObject("alertTitulo", "Sucessso ao deletar Plano");
			view.addObject("alertCorpo", "O Ve�culo foi deletado com sucesso da base de dados");
			view.addObject("location", "/LocAuto/exibePlanos");
		}

		return view;
	}

	/**
	 * Esse m�todo trata a requisi��o "/editarPlanoC/{clienteId}" recebe o id de uma
	 * plano e carrega o plano do banco e envia o objeto para view para ser editado.
	 * 
	 * @param clienteId
	 * @return
	 */
	@RequestMapping(value = "/editarPlanoC/{planoId}")
	public ModelAndView editPlanoC(Map<String, Object> map, @PathVariable("planoId") Integer planoId) {

		ModelAndView view = new ModelAndView();
		view.setViewName("planoCarro");
		view.addObject("planoC", planosService.buscaPorId(planoId));

		return view;
	}

	/**
	 * Esse m�todo trata a requisi��o "/editarPlanoM/{clienteId}" recebe o id de uma
	 * plano e carrega o plano do banco e envia o objeto para view para ser editado.
	 * 
	 * @param clienteId
	 * @return
	 */
	@RequestMapping(value = "/editarPlanoM/{planoId}")
	public ModelAndView editPlanoM(Map<String, Object> map, @PathVariable("planoId") Integer planoId) {

		ModelAndView view = new ModelAndView();
		view.setViewName("planoMotocicleta");
		view.addObject("planoM", planosService.buscaPorId(planoId));

		return view;
	}

	/**
	 * Esse m�todo trata a requisi��o "/exibePlanos" envia para view "exibePlanos"
	 * um lista de planoC e uma lista de planoM para ser exibido para o usu�rio
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("/exibePlanos")
	public String exibePlanos(Map<String, Object> map) {

		if (planosService.buscaTodos().isEmpty()) {
			salvaPlanosCarro();
			salvaPlanosMoto();
		}

		map.put("listaPlanosC", planosService.buscaPorTipo("PC"));
		map.put("listaPlanosM", planosService.buscaPorTipo("PM"));

		return "exibePlanos";
	}

	public boolean salvaPlanosCarro() {

		planoCarroA = new PlanosCarro();
		planoCarroA.setPlano("A");
		planoCarroA.setVeiculos("Celta, P�lio, Gol ");
		planoCarroA.setPotencia("1.0");
		planoCarroA.setAcessorios("Sem AC - 2P");
		planoCarroA.setValorDiaria(100);

		planoCarroB = new PlanosCarro();
		planoCarroB.setPlano("B");
		planoCarroB.setVeiculos("Celta, P�lio, Gol, Sandero ");
		planoCarroB.setPotencia("1.0");
		planoCarroB.setAcessorios("AC - 2P/4P");
		planoCarroB.setValorDiaria(120);

		planoCarroC = new PlanosCarro();
		planoCarroC.setPlano("C");
		planoCarroC.setVeiculos("Corsa, Prisma, Sandero ");
		planoCarroC.setPotencia("1.4");
		planoCarroC.setAcessorios("AC - DH - 2P/4P");
		planoCarroC.setValorDiaria(130);

		planoCarroD = new PlanosCarro();
		planoCarroD.setPlano("D");
		planoCarroD.setVeiculos("Clio, Logan, Sandero, Fox ");
		planoCarroD.setPotencia("1.6");
		planoCarroD.setAcessorios("AC - DH - VE - 2P/4P");
		planoCarroD.setValorDiaria(200);

		planoCarroE = new PlanosCarro();
		planoCarroE.setPlano("E");
		planoCarroE.setVeiculos("Corsa, Stilo, Prisma ");
		planoCarroE.setPotencia("1.8");
		planoCarroE.setAcessorios("Corsa, Stilo, Prisma");
		planoCarroE.setValorDiaria(220);

		planoCarroF = new PlanosCarro();
		planoCarroF.setPlano("F");
		planoCarroF.setVeiculos("Corsa, Vectra, Astra ");
		planoCarroF.setPotencia("2.0");
		planoCarroF.setAcessorios("AC - DH - VE - TE - 4P");
		planoCarroF.setValorDiaria(240);

		planoCarroG = new PlanosCarro();
		planoCarroG.setPlano("G");
		planoCarroG.setVeiculos("Corolla XEI, Civic XLS, Jetta ");
		planoCarroG.setPotencia("1.8");
		planoCarroG.setAcessorios("Corolla XEI, Civic XLS, Jetta ");
		planoCarroG.setValorDiaria(280);

		planosService.salvar(planoCarroA);
		planosService.salvar(planoCarroB);
		planosService.salvar(planoCarroC);
		planosService.salvar(planoCarroD);
		planosService.salvar(planoCarroE);
		planosService.salvar(planoCarroF);
		planosService.salvar(planoCarroG);

		return true;

	}

	public boolean salvaPlanosMoto() {

		planoMotoA = new PlanosMoto();
		planoMotoA.setPlano("A");
		planoMotoA.setVeiculos("Honda Biz, Honda CG, Yahama YBR, Traxx Fly");
		planoMotoA.setCilindradas(125);
		planoMotoA.setValorDiaria(50);

		planoMotoB = new PlanosMoto();
		planoMotoB.setPlano("B");
		planoMotoB.setVeiculos("Honda CBX, Yahaha XTZ ");
		planoMotoB.setCilindradas(250);
		planoMotoB.setValorDiaria(80);

		planoMotoC = new PlanosMoto();
		planoMotoC.setPlano("C");
		planoMotoC.setVeiculos(" Honda Shadow ");
		planoMotoC.setCilindradas(400);
		planoMotoC.setValorDiaria(100);

		planoMotoD = new PlanosMoto();
		planoMotoD.setPlano("D");
		planoMotoD.setVeiculos("Kawasaki ZX10");
		planoMotoD.setCilindradas(1000);
		planoMotoD.setValorDiaria(150);

		planosService.salvar(planoMotoA);
		planosService.salvar(planoMotoB);
		planosService.salvar(planoMotoC);
		planosService.salvar(planoMotoD);

		return true;

	}

}
