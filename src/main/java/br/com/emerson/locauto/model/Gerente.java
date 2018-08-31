package br.com.emerson.locauto.model;

/**
 * @author Emerson Sousa
 * 
 * Esta classe representa um Funcionário do tipo Gerente na aplicação.
 */

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "G")
public class Gerente extends Funcionario {

}
