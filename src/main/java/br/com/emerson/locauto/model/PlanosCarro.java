package br.com.emerson.locauto.model;



import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
/**
 * @author Emerson Sousa
 * 
 * Esta classe representa os Planos de locação  para carro na aplicação.
 */
@Entity
@DiscriminatorValue(value = "PC")
public class PlanosCarro extends Planos {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String acessorios;
	private String potencia;
	
	

	public String getPotencia() {
		return potencia;
	}

	public void setPotencia(String potencia) {
		this.potencia = potencia;
	}

	public String getAcessorios() {
		return acessorios;
	}

	public void setAcessorios(String acessorios) {
		this.acessorios = acessorios;
	}
	
	

}
