package br.com.emerson.locauto.model;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
/**
 * @author Emerson Sousa
 * 
 * Esta classe representa um Funcionário do tipo Gerente na aplicação.
 */
@Entity
@DiscriminatorValue(value = "G")
public class Gerente extends Funcionario {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
