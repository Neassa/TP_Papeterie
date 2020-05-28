package fr.eni.papeterie.ihm;

import fr.eni.papeterie.bll.BLLException;
import fr.eni.papeterie.bll.CatalogueManager;
import fr.eni.papeterie.bo.Article;

import java.util.List;

public class GestionArticle {
    //artibut
    private List<Article> catalogue;
    private CatalogueManager cm;

    private static GestionArticle instance;

    //Constructeur
    private GestionArticle() {
        if (cm==null){
            try {
                cm = new CatalogueManager();
                catalogue = cm.getCatalogue();
            } catch (BLLException e) {
                e.printStackTrace();
            }
        }
    }

    public static GestionArticle getInstance() {
        if (instance==null){
            instance = new GestionArticle();
        }
        return instance;
    }

    public void previous(){


    }

    public void next(){

    }

    public void update(){

    }

    public void save(){

    }

    public void newArticle(){

    }
}
