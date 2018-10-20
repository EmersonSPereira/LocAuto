package br.com.emerson.locauto.model;



import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author Emerson Sousa
 * 
 * Esta classe representa um veículo do tipo carro na aplicação.
 */
@Entity
@DiscriminatorValue(value = "C")
public class Carro extends Veiculo {

	private String acessorios;
	private Integer potencia;


	public Integer getPotencia() {
		return potencia;
	}

	public void setPotencia(Integer potencia) {
		this.potencia = potencia;
	}

	public String getAcessorios() {
		return acessorios;
	}

	public void setAcessorios(String acessorios) {
		this.acessorios = acessorios;
	}

}
