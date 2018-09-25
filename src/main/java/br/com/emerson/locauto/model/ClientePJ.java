package br.com.emerson.locauto.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "PJ")
public class ClientePJ extends Cliente {

	private String cnpj;
	private String razaoSocial;
	private String nomeFantasia;
	private String inscEstadual;

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getInscEstadual() {
		return inscEstadual;
	}

	public void setInscEstadual(String inscEstadual) {
		this.inscEstadual = inscEstadual;
	}

}
