package br.com.SaellusAPI.entity;

import java.io.Serializable;

public class Cliente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String cnpj;
	private String razaoSocial;
	private String endereco;
	private String numEndereco;
	
	
	//Getters and Setters
	
	public String getCnpj() {
		return cnpj;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getNumEndereco() {
		return numEndereco;
	}
	public void setNumEndereco(String numEndereco) {
		this.numEndereco = numEndereco;
	}
	

}
