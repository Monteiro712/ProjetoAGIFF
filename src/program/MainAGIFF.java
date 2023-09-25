package program;

import view.MainView;
import controller.ProxyColecaoController;

import controller.PublicacaoController;
import controller.RelacaoColecaoTagController;
import controller.TagController;
import model.RelacaoColecaoTag;

public class MainAGIFF {

	public static void main(String[] args) {
		
		ProxyColecaoController colecaoController = new ProxyColecaoController();
		PublicacaoController publicacaoController = PublicacaoController.getInstance();
		TagController tagController = TagController.getInstance();
		RelacaoColecaoTagController relacaoController = RelacaoColecaoTagController.getInstance();
		MainView view = new MainView(colecaoController, publicacaoController,tagController, relacaoController);
		view.displayTelaInicial();
	}

	
}