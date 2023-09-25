package controller;

import java.util.LinkedList;

import model.Colecao;

public interface IColecaoController {
	
    void cadastrarColecao(Colecao colecao);
    LinkedList<Colecao> getListaColecoes();
    Colecao buscarColecao(String colecaoTitulo);

}
