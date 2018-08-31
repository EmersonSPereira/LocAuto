package br.com.emerson.locauto.model;

/**
 * @author Emerson Sousa
 * 
 * Esta classe representa um Funcion�rio do tipo Gerente na aplica��o.
 */

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "G")
public class Gerente extends Funcionario {

}
