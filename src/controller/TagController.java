package controller;

import java.util.LinkedList;

import model.Tag;

public class TagController {
	private static TagController instance = null;
	private LinkedList<Tag> listaTags = new LinkedList<Tag>();
	
	private TagController() {
        // Construtor privado para impedir a criação de instâncias fora da classe.
    }
	public static TagController getInstance() {
	        if (instance == null) {
	            instance = new TagController();
	        }
	        return instance;
	}
	public void cadastrarTag(Tag tag) {
		this.listaTags.add(tag);
	}
	public LinkedList<Tag> getListaTags() {
		return this.listaTags;
	}
	public Tag buscarTag(String tagNome) {
		for(int i=0;i<=this.getListaTags().size()-1;i++ ) {
			if(this.getListaTags().get(i).getNome().contains(tagNome)){
				return this.getListaTags().get(i);
			}
		}
		return null;
	}
}
