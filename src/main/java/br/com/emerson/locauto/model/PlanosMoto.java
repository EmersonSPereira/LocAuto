package br.com.emerson.locauto.model;



import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
/**
 * @author Emerson Sousa
 * 
 * Esta classe representa os Planos de loca��o para motocicleta na aplica��o.
 */
@Entity
@DiscriminatorValue(value = "PM")
public class PlanosMoto extends Planos {

}
