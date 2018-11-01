package br.com.emerson.locauto.model;




import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
/**
 * @author Emerson Sousa
 * 
 * Esta classe representa o Cliente pessoa fisica na aplicação.
 */
@Entity
@DiscriminatorValue(value = "PF")
public class ClientePF extends Cliente {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	private String cpf;
	private String rg;
	private String datNasc;
	private String naturalidade;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getDatNasc() {
		return datNasc;
	}

	public void setDatNasc(String datNasc) {
		this.datNasc = datNasc;
	}

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

}
