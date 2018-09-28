package br.com.emerson.locauto.model;



import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
/**
 * @author Emerson Sousa
 * 
 * Esta classe representa os Planos de loca��o  para carro na aplica��o.
 */
@Entity
@DiscriminatorValue(value = "PC")
public class PlanosCarro extends Planos {
	
	private String acessorios;

	public String getAcessorios() {
		return acessorios;
	}

	public void setAcessorios(String acessorios) {
		this.acessorios = acessorios;
	}
	
	

}