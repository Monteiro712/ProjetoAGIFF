package model;

import java.util.Date;
import java.util.LinkedList;

public class Publicacao {
	
	private String autor, titulo, link;
	private Date dataCriacao;
	private Colecao colecao;
	
	public Publicacao(String autor, String titulo, String link, Date dataCriacao) {
		this.autor = autor;
		this.titulo = titulo;
		this.link = link;
		this.dataCriacao = dataCriacao;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public String getAutor() {
		return this.autor;
	}

	public String getLink() {
		return this.link;
	}

	public Date getDataCriacao() {
		return this.dataCriacao;
	}

	public Colecao getColecao() {
		return this.colecao;
	}

	public void setColecao(Colecao colecao) {
		this.colecao = colecao;
	}
	
	public String toString() {
		String publicaoToStrig = "Título: " + this.titulo + " -  " + "Autor: " + this.autor + "\n" +
							     "Link: " + this.link + "\n";
		return publicaoToStrig;

	}
}
