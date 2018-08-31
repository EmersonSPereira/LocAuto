package br.com.emerson.locauto.model;

/**
 * @author Emerson Sousa
 * 
 * Esta classe representa um Funcionário do tipo Locador na aplicação.
 */

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "L")
public class Locador extends Funcionario {

}
