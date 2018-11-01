package br.com.emerson.locauto.model;



import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
/**
 * @author Emerson Sousa
 * 
 * Esta classe representa um Funcionário do tipo Locador na aplicação.
 */
@Entity
@DiscriminatorValue(value = "L")
public class Locador extends Funcionario {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
