package controller;


import java.util.LinkedList;

import javax.swing.JOptionPane;
import controller.ColecaoControllerReal;
import model.Colecao;

public class ProxyColecaoController implements IColecaoController  {
   
	private ColecaoControllerReal colecaoControllerReal;
	

    public ProxyColecaoController() {
    	this.colecaoControllerReal =   ColecaoControllerReal.getInstance();
    }


    @Override
    public LinkedList<Colecao> getListaColecoes() {
    	return colecaoControllerReal.getListaColecoes();
	}
    
    @Override
    public void cadastrarColecao(Colecao colecao)  
    {
        if (verificarPermissaoDeCriacao()) 
        {
            colecaoControllerReal.cadastrarColecao(colecao);
        } 
        else 
        {
        	JOptionPane.showMessageDialog(null, "Permiss�o negada para criar cole��o", "AgIFF", JOptionPane.PLAIN_MESSAGE);
        }
    }
    
    @Override
    public Colecao buscarColecao(String colecaoTitulo){
    	
    	return colecaoControllerReal.buscarColecao(colecaoTitulo);
    }

    private boolean verificarPermissaoDeCriacao() {
        // Lógica para verificar as permissões do usuário para criar coleções
        // Por exemplo, verifique se o usuário tem a função apropriada ou se atende a critérios específicos
        return true;
    }
}