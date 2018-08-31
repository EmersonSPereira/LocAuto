package br.com.emerson.locauto.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author Emerson Sousa
 * 
 * Esta classe representa um ve�culo do tipo motocicleta na aplica��o.
 */

@Entity
@DiscriminatorValue(value = "M")
public class Motocicleta extends Veiculo {

	private Integer cilindradas;
	private String freios;

	public Integer getCilindradas() {
		return cilindradas;
	}

	public void setCilindradas(Integer cilindradas) {
		this.cilindradas = cilindradas;
	}

	public String getFreios() {
		return freios;
	}

	public void setFreios(String freios) {
		this.freios = freios;
	}

}
