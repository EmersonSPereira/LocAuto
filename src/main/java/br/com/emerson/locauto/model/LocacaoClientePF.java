package br.com.emerson.locauto.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
/**
 * 
 * @author Emerson
 *Essta classe representa uma locação para um clientePF na aplicação
 */
@Entity
@DiscriminatorValue("PF")
public class LocacaoClientePF extends Locacao{

	@ManyToOne
	ClientePF clientePF;

	public ClientePF getClientePF() {
		return clientePF;
	}

	public void setClientePF(ClientePF clientePF) {
		this.clientePF = clientePF;
	}
	
	


}
