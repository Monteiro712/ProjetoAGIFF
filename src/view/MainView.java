package view;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import controller.ProxyColecaoController;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import controller.*;
import model.Colecao;
import model.Publicacao;
import model.RelacaoColecaoTag;
import model.Tag;

public class MainView {
	ProxyColecaoController colecaoController;
	PublicacaoController publicacaoController;
	TagController tagController;
	RelacaoColecaoTagController relacaoController;
	Calendar c = Calendar.getInstance();
	ImageIcon icon_1 = new ImageIcon("C:\\Nova Pasta\\logo_02.jpg");

	public MainView(ProxyColecaoController colecaoController, PublicacaoController publicacaoControler,TagController tagController, RelacaoColecaoTagController relacaoController){
		this.colecaoController = colecaoController;
		this.publicacaoController = publicacaoControler;
		this.tagController = tagController;
		this.relacaoController = relacaoController;
	}
	
	public void proxyValidador(){
		
		JOptionPane.showMessageDialog(null, "Bem vindo!", "AgIFF", JOptionPane.PLAIN_MESSAGE, icon_1);
		
	}
	
	
	public void displayTelaInicial() {
		JOptionPane.showMessageDialog(null, "Bem vindo!", "AgIFF", JOptionPane.PLAIN_MESSAGE, icon_1);
		String[] arrayOpcoes = new String[8];
		arrayOpcoes[0] = "Cadastrar Coleção";
		arrayOpcoes[1] = "Cadastrar Publicação";
		arrayOpcoes[2] = "Cadastrar uma Tag";
		arrayOpcoes[3] = "Visualizar uma Coleção";
		arrayOpcoes[4] = "Visualizar todas as Coleções cadastradas";
		arrayOpcoes[5] = "Associar Tag e Coleção";
		arrayOpcoes[6] = "Buscar Coleções usando uma Tag";
		arrayOpcoes[7] = "Sair";
		Object opcaoEscolhida = JOptionPane.showInputDialog(null, "Escolha uma opção.", "AgIFF" , JOptionPane.PLAIN_MESSAGE, null, arrayOpcoes, "Regular");
		displayEscolha(opcaoEscolhida,arrayOpcoes);
	}
	public void displayEscolha(Object opcaoEscolhida, String[] arrayOpcoes) {
		
		while((opcaoEscolhida != null) && (opcaoEscolhida.toString().length()>0) && (opcaoEscolhida != "Sair")) {	

			if(opcaoEscolhida == "Cadastrar Coleção") {	
				String titulo = JOptionPane.showInputDialog("Informe o título da coleção: ");
				Date data = c.getTime();
				String usuario = JOptionPane.showInputDialog("Informe o usuário responsável pela coleção: ");
				if(titulo.isBlank() || titulo.isEmpty() ) {
					JOptionPane.showMessageDialog(null, "Título inválido", "AgIFF", JOptionPane.PLAIN_MESSAGE);
				}
				else {
					this.colecaoController.cadastrarColecao(new Colecao(titulo,data,usuario));				
				}
			}
			if((opcaoEscolhida == "Cadastrar Publicação") && (this.colecaoController.getListaColecoes().isEmpty()!=true)) {	
				//Para cadastrar uma publicacao, o usuario deve escolher uma colecao primeiro
				String[] arrayOpcoesDeColecoes = new String[this.colecaoController.getListaColecoes().size()];
				Iterator iterador = this.colecaoController.getListaColecoes().iterator() ;
				int i =0;
				while (iterador.hasNext()) {
					Colecao temp = (Colecao) iterador.next();
					arrayOpcoesDeColecoes[i] = temp.getTitulo();
					i++;
				}
				Object colecaoTitulo = JOptionPane.showInputDialog(null, "Escolha uma coleção para cadastrar sua publicacao.", "AgIFF" , JOptionPane.PLAIN_MESSAGE, null, arrayOpcoesDeColecoes, "Regular");
				String titulo = JOptionPane.showInputDialog("Informe o título da publicação: ");
				String autor = JOptionPane.showInputDialog("Informe o autor da publicação: ");
				String link = JOptionPane.showInputDialog("Informe o link da publicação: ");
				Date data = c.getTime(); 
				if(this.publicacaoController.associarPublicacao(new Publicacao(titulo, autor, link, data), this.colecaoController.buscarColecao(colecaoTitulo.toString())) == true) {
					JOptionPane.showMessageDialog(null, "Publicação adicionada em " + colecaoTitulo + ".", "AgIFF", JOptionPane.PLAIN_MESSAGE);
				}
			}
			if(opcaoEscolhida == "Cadastrar uma Tag") {	
				String nome = JOptionPane.showInputDialog("Informe o nome da Tag: ");
				String descricao = JOptionPane.showInputDialog("Informe a descricacao da Tag: ");
				if(nome.isBlank()||nome.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nome inválido. Tente novamente.", "AgIFF" , JOptionPane.PLAIN_MESSAGE);
				}
				else {
					this.tagController.cadastrarTag(new Tag(nome, descricao));
					JOptionPane.showMessageDialog(null, "Tag cadastrada.", "AgIFF" , JOptionPane.PLAIN_MESSAGE);
				}				
			}
			if(opcaoEscolhida == "Visualizar uma Coleção") {
				String[] arrayOpcoesDeColecoes = new String[this.colecaoController.getListaColecoes().size()];
				Iterator iterador = this.colecaoController.getListaColecoes().iterator();
				int i =0;
				try {
					while (iterador.hasNext()) {
						Colecao temp = (Colecao) iterador.next();
						arrayOpcoesDeColecoes[i] = temp.getTitulo();
						i++;
					}
					Object colecaoEscolhida = JOptionPane.showInputDialog(null, "Escolha uma coleção para visualizar.", "AgIFF" , JOptionPane.PLAIN_MESSAGE, null, arrayOpcoesDeColecoes, "Regular");
					JOptionPane.showMessageDialog(null,"Confira os dados da Coleção: \n"+this.colecaoController.buscarColecao(colecaoEscolhida.toString()).toString()+"\nPublicações: \n"+this.publicacaoController.imprimirPublicacoes(this.colecaoController.buscarColecao(colecaoEscolhida.toString())) , "AgIFF", JOptionPane.INFORMATION_MESSAGE, icon_1);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Não", "AgIFF", JOptionPane.PLAIN_MESSAGE);
				}
	
			}
			if(opcaoEscolhida == "Visualizar todas as Coleções cadastradas") {
				String impressaoTotal = "Cofira os dados de todas as Coleções cadastradas:\n";
				Iterator iteradorColecoes = this.colecaoController.getListaColecoes().iterator();
				while (iteradorColecoes.hasNext()) {
					Colecao temp = (Colecao) iteradorColecoes.next();
					impressaoTotal += temp.toString();
					impressaoTotal += "\nPublicações:\n";
					impressaoTotal += this.publicacaoController.imprimirPublicacoes(temp);
					impressaoTotal += "\n";

				}
				JOptionPane.showMessageDialog(null, impressaoTotal, "AgIFF", JOptionPane.INFORMATION_MESSAGE, icon_1);
			}
			if(opcaoEscolhida == "Associar Tag e Coleção") {
				String[] arrayOpcoesDeTags = new String[this.tagController.getListaTags().size()];
				Iterator iterador = this.tagController.getListaTags().iterator();
				int i =0;
				try {
					while (iterador.hasNext()) {
						Tag temp = (Tag) iterador.next();
						arrayOpcoesDeTags[i] = temp.getNome();
						i++;
					}
					Object tagEscolhida = JOptionPane.showInputDialog(null, "Escolha uma Tag.", "AgIFF" , JOptionPane.PLAIN_MESSAGE, null, arrayOpcoesDeTags, "Regular");
					String[] arrayOpcoesDeColecoes = new String[this.colecaoController.getListaColecoes().size()];
					iterador = this.colecaoController.getListaColecoes().iterator();
					int j =0;
					while (iterador.hasNext()) {
						 Colecao temp = (Colecao) iterador.next();
						 arrayOpcoesDeColecoes[j] = temp.getTitulo();
						 j++;
						}
					Object colecaoEscolhida = JOptionPane.showInputDialog(null, "Escolha uma Coleção para associar a Tag.", "AgIFF" , JOptionPane.PLAIN_MESSAGE, null, arrayOpcoesDeColecoes, "Regular");
					RelacaoColecaoTag auxiliar = new RelacaoColecaoTag(this.colecaoController.buscarColecao(colecaoEscolhida.toString()), this.tagController.buscarTag(tagEscolhida.toString()));
					this.relacaoController.realizarAssociacao(auxiliar);
					JOptionPane.showMessageDialog(null, "Operação concluida", "AgIFF", JOptionPane.PLAIN_MESSAGE);
					} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Houve um problema. Tente novamente.", "AgIFF", JOptionPane.PLAIN_MESSAGE);
				}
	
			}
			if(opcaoEscolhida == "Buscar Coleções usando uma Tag") {
				String[] arrayOpcoesDeTags = new String[this.tagController.getListaTags().size()];
				Iterator iterador = this.tagController.getListaTags().iterator();
				int i =0;
				try {
	
					while (iterador.hasNext()) {
						Tag temp = (Tag) iterador.next();
						arrayOpcoesDeTags[i] = temp.getNome();
						i++;
					}
					Object tagEscolhida = JOptionPane.showInputDialog(null, "Escolha uma Tag.", "AgIFF" , JOptionPane.PLAIN_MESSAGE, null, arrayOpcoesDeTags, "Regular");
					String listaDeColecoes = this.relacaoController.buscarColecoesPorTag(tagEscolhida.toString());
					
					JOptionPane.showMessageDialog(null, listaDeColecoes, "AgIFF", JOptionPane.PLAIN_MESSAGE);
					} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Houve um problema. Tente novamente.", "AgIFF", JOptionPane.PLAIN_MESSAGE);
				}
	
			}
			opcaoEscolhida = JOptionPane.showInputDialog(null, "Escolha uma opção.", "AgIFF" , JOptionPane.PLAIN_MESSAGE, null, arrayOpcoes, "Regular");
		}
	}
}
