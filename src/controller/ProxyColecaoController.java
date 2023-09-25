package controller;


import java.util.LinkedList;

import javax.swing.JOptionPane;
import controller.ColecaoControllerReal;
import model.Colecao;

public class ProxyColecaoController implements IColecaoController  {
   
	private ColecaoController ColecaoControllerReal;
	

    public ProxyColecaoController() {
    	this.ColecaoControllerReal =   ColecaoController.getInstance();
    }


    @Override
    public LinkedList<Colecao> getListaColecoes() {
    	return ColecaoControllerReal.getListaColecoes();
	}
    
    @Override
    public void cadastrarColecao(Colecao colecao)  
    {
        if (verificarPermissaoDeCriacao()) 
        {
            ColecaoControllerReal.cadastrarColecao(colecao);
        } 
        else 
        {
        	JOptionPane.showMessageDialog(null, "Permiss�o negada para criar cole��o", "AgIFF", JOptionPane.PLAIN_MESSAGE);
        }
    }
    
    @Override
    public Colecao buscarColecao(String colecaoTitulo){
    	
    	return ColecaoControllerReal.buscarColecao(colecaoTitulo);
    }

    private boolean verificarPermissaoDeCriacao() {
        // Lógica para verificar as permissões do usuário para criar coleções
        // Por exemplo, verifique se o usuário tem a função apropriada ou se atende a critérios específicos
        return true;
    }
}