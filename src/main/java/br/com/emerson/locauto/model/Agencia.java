package br.com.emerson.locauto.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * @author Emerson Sousa
 * 
 *         Esta classe representa a Agência na aplicação.
 */
@Entity
public class Agencia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String cnpj;
	private String inscEstadual;
	private String telefone;
	
	@OneToOne
	private Gerente GerenteResponsavel;
	private String localidade;

	public Integer getId() {
		return id;

	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getInscEstadual() {
		return inscEstadual;
	}

	public void setInscEstadual(String inscEstadual) {
		this.inscEstadual = inscEstadual;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Gerente getGerenteResponsavel() {
		return GerenteResponsavel;
	}

	public void setGerenteResponsavel(Gerente gerenteResponsavel) {
		GerenteResponsavel = gerenteResponsavel;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
