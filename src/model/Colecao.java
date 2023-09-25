package model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Colecao {

	private String titulo;
	private Date dataCriacao;
	private String usuario;
	private int numeroDePublicacoes = 0;
	
	Date thisDate = new Date();
	SimpleDateFormat dateForm = new SimpleDateFormat("MM/dd/YY");
	
	public Colecao(String titulo, Date dataCriacao, String usuario) {
		this.titulo = titulo;
		this.dataCriacao = dataCriacao;
		this.usuario = usuario;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setNumeroDePublicacoes(int numeroDePublicacoes) {
		this.numeroDePublicacoes = numeroDePublicacoes;
	}
	public int getNumeroDePublicacoes() {
		return this.numeroDePublicacoes;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String toString() {
		String colecaoToString = "Título da Coleçãoo: " + this.titulo + "\nData de criação: "+ dateForm.format(this.dataCriacao) + "\n" + 
								"Usuário: " + this.usuario;
		return colecaoToString;
	}
	

}
