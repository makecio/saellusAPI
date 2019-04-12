package br.com.SaellusAPI.entity;

import java.io.Serializable;

public class TabelaCampos implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String coluna;// name campo label
	private String tipoColuna;
	private int tamanhoColuna;
	private String nameColuna; // name coluna input
	private String perfilAcessoColuna; //separados por , ex: 1,2,3
	private int ativo;
	private int codCliente;
	private String tabela;
	private String nameTabela;
	private int tipoForm;//campo para separar o campo por tipo de form , o cliente pode ter mais de um tipo de formulario para pedido por segmento por exemplo
	private String opcoes;
	
	
	//Getters and Setters
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getColuna() {
		return coluna;
	}
	public void setColuna(String coluna) {
		this.coluna = coluna;
	}
	public String getTipoColuna() {
		return tipoColuna;
	}
	public void setTipoColuna(String tipoColuna) {
		this.tipoColuna = tipoColuna;
	}
	public int getTamanhoColuna() {
		return tamanhoColuna;
	}
	public void setTamanhoColuna(int tamanhoColuna) {
		this.tamanhoColuna = tamanhoColuna;
	}
	public String getNameColuna() {
		return nameColuna;
	}
	public void setNameColuna(String nameColuna) {
		this.nameColuna = nameColuna;
	}
	public String getPerfilAcessoColuna() {
		return perfilAcessoColuna;
	}
	public void setPerfilAcessoColuna(String perfilAcessoColuna) {
		this.perfilAcessoColuna = perfilAcessoColuna;
	}
	public int getAtivo() {
		return ativo;
	}
	public void setAtivo(int ativo) {
		this.ativo = ativo;
	}
	public int getCodCliente() {
		return codCliente;
	}
	public void setCodCliente(int codCliente) {
		this.codCliente = codCliente;
	}
	public String getTabela() {
		return tabela;
	}
	public void setTabela(String tabela) {
		this.tabela = tabela;
	}
	public String getNameTabela() {
		return nameTabela;
	}
	public void setNameTabela(String nameTabela) {
		this.nameTabela = nameTabela;
	}
	public int getTipoForm() {
		return tipoForm;
	}
	public void setTipoForm(int tipoForm) {
		this.tipoForm = tipoForm;
	}
	public String getOpcoes() {
		return opcoes;
	}
	public void setOpcoes(String opcoes) {
		this.opcoes = opcoes;
	}
	
	
}
