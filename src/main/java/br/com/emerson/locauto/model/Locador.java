package br.com.emerson.locauto.model;

/**
 * @author Emerson Sousa
 * 
 * Esta classe representa um Funcion�rio do tipo Locador na aplica��o.
 */

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "L")
public class Locador extends Funcionario {

}
