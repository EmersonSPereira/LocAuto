package br.com.emerson.locauto.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author Emerson Sousa
 * 
 *         Esta classe representa um veículo do tipo motocicleta na aplicação.
 */

@Entity
@DiscriminatorValue(value = "M")
public class Motocicleta extends Veiculo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cilindradas;
	private String freios;

	public String getCilindradas() {
		return cilindradas;
	}

	public void setCilindradas(String cilindradas) {
		this.cilindradas = cilindradas;
	}

	public String getFreios() {
		return freios;
	}

	public void setFreios(String freios) {
		this.freios = freios;
	}

}
