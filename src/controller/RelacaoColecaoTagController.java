package controller;

import java.util.LinkedList;

import model.RelacaoColecaoTag;

public class RelacaoColecaoTagController {
	private static RelacaoColecaoTagController instance = null;
	private LinkedList<RelacaoColecaoTag> listaDeRelacoes = new LinkedList<RelacaoColecaoTag>();
	
	private RelacaoColecaoTagController() {
        // Construtor privado para impedir a criação de instâncias fora da classe.
    }
	
	public static RelacaoColecaoTagController getInstance() {
	        if (instance == null) {
	            instance = new RelacaoColecaoTagController();
	        }
	        return instance;
	}
	public void realizarAssociacao(RelacaoColecaoTag relacao) {
		this.listaDeRelacoes.add(relacao);
	}
	public String buscarColecoesPorTag(String tagNome) {
		String resultado = "Coleções com a Tag selecionada:\n";
		for(int i=0; i<= this.listaDeRelacoes.size()-1;i++) {
			if(this.listaDeRelacoes.get(i).getTag().getNome() == tagNome) {
				resultado += this.listaDeRelacoes.get(i).getColecao().getTitulo() + "\n ";
			}
		}
		return resultado;
	}
}
