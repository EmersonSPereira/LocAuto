package br.com.emerson.locauto.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 * 
 * @author Emerson Essta classe representa uma locação para um clientePF na
 *         aplicação
 */
@Entity
@DiscriminatorValue("PJ")
public class LocacaoClientePJ extends Locacao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManyToOne
	ClientePJ clientePJ;

	public ClientePJ getClientePJ() {
		return clientePJ;
	}

	public void setClientePJ(ClientePJ clientePJ) {
		this.clientePJ = clientePJ;
	}

}
