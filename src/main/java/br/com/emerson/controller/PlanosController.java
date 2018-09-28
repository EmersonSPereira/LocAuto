package br.com.emerson.controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.emerson.locauto.model.PlanosCarro;
import br.com.emerson.locauto.model.PlanosMoto;
import br.com.emerson.locauto.service.PlanosService;
/**
 * @author Emerson Sousa
 * 
 * Esta classe é um controller na aplicação.
 */

@Controller
public class PlanosController {

	@Autowired
	private PlanosService planosService;

	private PlanosCarro planoCarroA, planoCarroB, planoCarroC, planoCarroD, planoCarroE, planoCarroF, planoCarroG;
	private PlanosMoto planoMotoA, planoMotoB, planoMotoC, planoMotoD;

	/**
	 * Esse método trata a requisição "/planoC, adiciona um objeto planoC na view
	 *  e por fim retorna a view "planoCarro"
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
	 * Esse método trata a requisição "/salvaPlanoC" monta o objeto planoC, vindo da view e salva no banco.
	 * @param planoCarro
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/salvaPlanoC", method = RequestMethod.POST)
	public String addPlanoC(@ModelAttribute("planoC") PlanosCarro planoCarro, BindingResult result) {

		planosService.salvar(planoCarro);

		return "redirect:/exibePlanos";
	}

	/**
	 * Esse método trata a requisição "/planoM, adiciona um objeto planoM na view
	 *  e por fim retorna a view "planoCarro"
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
	 * Esse método trata a requisição "/salvaPlanoM" monta o objeto planoM, vindo da view e salva no banco.
	 * @param planoMoto
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/salvaPlanoM", method = RequestMethod.POST)
	public String addPlanoM(@ModelAttribute("planoM") PlanosMoto planoMoto, BindingResult result) {

		planosService.salvar(planoMoto);

		return "redirect:/exibePlanos";
	}

	/**
	 * Esse método trata a requisição "/delete/{planoId}" recebe o id de um plano e deleta do banco
	 * @param planoId
	 * @return
	 */
	@RequestMapping("/deletePlano/{planoId}")
	public String deletePlano(@PathVariable("planoId") Integer planoId) {

		planosService.deleta(planoId);

		return "redirect:/exibePlanos";
	}

	/**
	 * Esse método trata a requisição "/exibePlanos" envia para view "exibePlanos" um lista de planoC 
	 * e uma lista de planoM  para ser exibido
	 * para o usuário
	 * @param map
	 * @return
	 */
	@RequestMapping("/exibePlanos")
	public String exibePlanos(Map<String, Object> map) {

		map.put("listaPlanosC", planosService.buscaPorTipo("PC"));
		map.put("listaPlanosM", planosService.buscaPorTipo("PM"));

		return "exibePlanos";
	}

	public boolean salvaPlanosCarro() {

		planoCarroA = new PlanosCarro();
		planoCarroA.setPlano("A");
		planoCarroA.setVeiculos("Celta, Pálio, Gol ");
		planoCarroA.setCilindradas(1000);
		planoCarroA.setAcessorios("Sem AC - 2P");

		planoCarroB = new PlanosCarro();
		planoCarroB.setPlano("B");
		planoCarroB.setVeiculos("Celta, Pálio, Gol, Sandero ");
		planoCarroB.setCilindradas(1000);
		planoCarroB.setAcessorios("AC - 2P/4P");

		planoCarroC = new PlanosCarro();
		planoCarroC.setPlano("C");
		planoCarroC.setVeiculos("Corsa, Prisma, Sandero ");
		planoCarroC.setCilindradas(1400);
		planoCarroC.setAcessorios("AC - DH - 2P/4P");

		planoCarroD = new PlanosCarro();
		planoCarroD.setPlano("D");
		planoCarroD.setVeiculos("Clio, Logan, Sandero, Fox ");
		planoCarroD.setCilindradas(1600);
		planoCarroD.setAcessorios("AC - DH - VE - 2P/4P");

		planoCarroE = new PlanosCarro();
		planoCarroE.setPlano("E");
		planoCarroE.setVeiculos("Corsa, Stilo, Prisma ");
		planoCarroE.setCilindradas(1800);
		planoCarroE.setAcessorios("Corsa, Stilo, Prisma");

		planoCarroF = new PlanosCarro();
		planoCarroF.setPlano("F");
		planoCarroF.setVeiculos("Corsa, Vectra, Astra ");
		planoCarroF.setCilindradas(2000);
		planoCarroF.setAcessorios("AC - DH - VE - TE - 4P");

		planoCarroG = new PlanosCarro();
		planoCarroG.setPlano("G");
		planoCarroG.setVeiculos("Corolla XEI, Civic XLS, Jetta ");
		planoCarroG.setCilindradas(1800);
		planoCarroG.setAcessorios("Corolla XEI, Civic XLS, Jetta ");

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

		planoMotoB = new PlanosMoto();
		planoMotoB.setPlano("B");
		planoMotoB.setVeiculos("Honda CBX, Yahaha XTZ ");
		planoMotoB.setCilindradas(250);

		planoMotoC = new PlanosMoto();
		planoMotoC.setPlano("C");
		planoMotoC.setVeiculos(" Honda Shadow ");
		planoMotoC.setCilindradas(400);

		planoMotoD = new PlanosMoto();
		planoMotoD.setPlano("D");
		planoMotoD.setVeiculos("Kawasaki ZX10");
		planoMotoD.setCilindradas(1000);

		planosService.salvar(planoMotoA);
		planosService.salvar(planoMotoB);
		planosService.salvar(planoMotoC);
		planosService.salvar(planoMotoD);

		return true;

	}

}
