package br.com.emerson.locauto.model;

import java.util.Date;

public class Devolucao {

	private Integer locacaoId;
	private String nivelDoTanque;

	private String danos;

	public String getNivelDoTanque() {
		return nivelDoTanque;
	}

	public void setNivelDoTanque(String nivelDoTanque) {
		this.nivelDoTanque = nivelDoTanque;
	}

	public String getDanos() {
		return danos;
	}

	public void setDanos(String danos) {
		this.danos = danos;
	}

	public Integer getLocacaoId() {
		return locacaoId;
	}

	public void setLocacaoId(Integer locacaoId) {
		this.locacaoId = locacaoId;
	}
	

}
