package br.com.emerson.locauto.model;

/**
 * @author Emerson Sousa
 * 
 * Esta classe representa um ve�culo do tipo carro na aplica��o.
 */

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "C")
public class Carro extends Veiculo {

	private String acessorios;

	public String getAcessorios() {
		return acessorios;
	}

	public void setAcessorios(String acessorios) {
		this.acessorios = acessorios;
	}

}
