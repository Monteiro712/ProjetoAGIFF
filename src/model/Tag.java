package model;


public class Tag {
	private String nome, descricao;
	
	public Tag(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}

	public String getNome() {
		return this.nome;
	}
}
