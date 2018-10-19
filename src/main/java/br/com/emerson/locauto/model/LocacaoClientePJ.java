package br.com.emerson.locauto.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * 
 * @author Emerson
 *Essta classe representa uma locação para um clientePF na aplicação
 */
@Entity
@DiscriminatorValue("PJ")
public class LocacaoClientePJ extends Locacao {
	
	
	@ManyToOne
	private ClientePJ clientePJ;

	public ClientePJ getClientePJ() {
		return clientePJ;
	}

	public void setClientePJ(ClientePJ clientePJ) {
		this.clientePJ = clientePJ;
	}
	
	
	

}
