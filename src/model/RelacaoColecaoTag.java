package model;

public class RelacaoColecaoTag {
	private Colecao colecao;
	private Tag tag;
	
	public RelacaoColecaoTag(Colecao colecao, Tag tag) {
		this.colecao = colecao;
		this.tag = tag;
	}
	
	public Colecao getColecao() {
		return this.colecao;
	}
	public Tag getTag() {
		return this.tag;
	}

}
