/**
 * 
 */
package br.com.makersweb.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author Anderson O. Aristides
 *
 */
@Entity
public class Hotel extends DefaultDomain implements Serializable {

	private static final long serialVersionUID = 2129550226004211589L;
	@Column(nullable = false, length = 100)
	private String nome;
	@Column(nullable = false, length = 150)
	private String endereco;
	@Column(nullable = false, length = 10)
	private String cep;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

}
